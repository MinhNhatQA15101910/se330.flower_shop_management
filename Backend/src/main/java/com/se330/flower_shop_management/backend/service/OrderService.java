package com.se330.flower_shop_management.backend.service;

import com.se330.flower_shop_management.backend.dto.AddOrderDto;
import com.se330.flower_shop_management.backend.dto.OrderResponseDto;
import com.se330.flower_shop_management.backend.dto.ProductDto;
import com.se330.flower_shop_management.backend.dto.UserResponseDto;
import com.se330.flower_shop_management.backend.entity.Order;
import com.se330.flower_shop_management.backend.entity.Product;
import com.se330.flower_shop_management.backend.entity.ProductImage;
import com.se330.flower_shop_management.backend.mapper.ProductMapper;
import com.se330.flower_shop_management.backend.repository.OrderRepository;
import com.se330.flower_shop_management.backend.repository.ProductImageRepository;
import com.se330.flower_shop_management.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductImageRepository productImageRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderResponseDto createOrder(AddOrderDto addOrderDto, String token) throws Exception {
        Long userId = jwtService.extractUserId(token);
        Product product = productRepository.findById(addOrderDto.getProductId())
                .orElseThrow(() -> new Exception("Product not found"));

        if (product.getStock() < 1) {
            throw new Exception(product.getName() + " is out of stock.");
        }

        product.setStock(product.getStock() - 1);
        product.setSold(product.getSold() + 1);
        productRepository.save(product);

        String totalPrice = String.valueOf(Double.parseDouble("2") + Double.parseDouble(product.getSalePrice()));

        Order order = new Order();
        order.setUserId(userId);
        order.setTotalPrice(totalPrice);
        order.setProductPrice(product.getSalePrice());
        order.setShippingPrice("2");
        order.setStatus("Pending");
        order.setEstimatedReceiveDate(addOrderDto.getEstimatedReceiveDate());
        order.setOrderDate(addOrderDto.getOrderDate());
        order.setInDeliveryDate(addOrderDto.getInDeliveryDate());
        order.setReceiveDate(addOrderDto.getReceiveDate());
        order.setProvince(addOrderDto.getProvince());
        order.setDistrict(addOrderDto.getDistrict());
        order.setWard(addOrderDto.getWard());
        order.setDetailAddress(addOrderDto.getDetailAddress());
        order.setReceiverName(addOrderDto.getReceiverName());
        order.setReceiverPhoneNumber(addOrderDto.getReceiverPhoneNumber());
        Order newOrder = orderRepository.save(order);
        List<String> imageUrls = productImageRepository.findByProductId(product.getId())
                .stream()
                .map(ProductImage::getImageUrl)
                .collect(Collectors.toList());
        ProductDto productDto = ProductMapper.toDto(product, imageUrls);

        List<ProductDto> products = List.of(productDto);
        List<Integer> quantities = List.of(1);

        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setUserId(userId);
        responseDto.setTotalPrice(newOrder.getTotalPrice());
        responseDto.setProductPrice(newOrder.getProductPrice());
        responseDto.setShippingPrice(newOrder.getShippingPrice());
        responseDto.setStatus(newOrder.getStatus());
        responseDto.setEstimatedReceiveDate(newOrder.getEstimatedReceiveDate());
        responseDto.setOrderDate(newOrder.getOrderDate());
        responseDto.setInDeliveryDate(newOrder.getInDeliveryDate());
        responseDto.setReceiveDate(newOrder.getReceiveDate());
        responseDto.setProvince(newOrder.getProvince());
        responseDto.setDistrict(newOrder.getDistrict());
        responseDto.setWard(newOrder.getWard());
        responseDto.setDetailAddress(newOrder.getDetailAddress());
        responseDto.setReceiverName(newOrder.getReceiverName());
        responseDto.setReceiverPhoneNumber(newOrder.getReceiverPhoneNumber());
        responseDto.setProducts(products);
        responseDto.setQuantities(quantities);

        return responseDto;
    }

    public Order getOrderById(Long id) {
        if (orderRepository.findAll().isEmpty()) {
            throw new RuntimeException("No order available!");
        }
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found."));
    }
}

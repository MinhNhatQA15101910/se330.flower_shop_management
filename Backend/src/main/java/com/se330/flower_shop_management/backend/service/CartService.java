package com.se330.flower_shop_management.backend.service;

import com.se330.flower_shop_management.backend.dto.ProductDto;
import com.se330.flower_shop_management.backend.dto.UserResponseDto;
import com.se330.flower_shop_management.backend.entity.Cart;
import com.se330.flower_shop_management.backend.entity.IDS.CartId;
import com.se330.flower_shop_management.backend.entity.Product;
import com.se330.flower_shop_management.backend.entity.ProductImage;
import com.se330.flower_shop_management.backend.entity.User;
import com.se330.flower_shop_management.backend.mapper.ProductMapper;
import com.se330.flower_shop_management.backend.repository.CartRepository;
import com.se330.flower_shop_management.backend.repository.ProductImageRepository;
import com.se330.flower_shop_management.backend.repository.ProductRepository;
import com.se330.flower_shop_management.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductImageRepository productImageRepository;
    @Autowired
    private JwtService jwtService;

    public UserResponseDto addToCart(Long productId, Long userId, String token) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Cart cart = cartRepository.findByUserAndProduct(user, product).orElse(null);

        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            cart.setProduct(product);
            cart.setQuantity(1);

            CartId cartId = new CartId();
            cartId.setUserId(userId);
            cartId.setProductId(productId);
            cart.setId(cartId);
        } else {
            cart.setQuantity(cart.getQuantity() + 1);
        }

        cartRepository.save(cart);

        List<Cart> cartItems = cartRepository.findByUserId(user.getId());
        List<Long> productIdsInCart = cartItems.stream()
                .map(cartItem -> cartItem.getProduct().getId())
                .collect(Collectors.toList());
        List<Product> products = productRepository.findAllById(productIdsInCart);

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setToken(token);
        userResponseDto.setId(user.getId());
        userResponseDto.setUsername(user.getUsername());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPassword(user.getPassword());
        userResponseDto.setImageUrl(user.getImageUrl());
        userResponseDto.setRole(user.getRole());


        List<ProductDto> productDtos = products
                .stream()
                .filter(Product::getIsAvailable)
                .map(productItem -> {
                    List<String> imageUrls = productImageRepository.findByProductId(productItem.getId())
                            .stream()
                            .map(ProductImage::getImageUrl)
                            .collect(Collectors.toList());
                    return ProductMapper.toDto(productItem, imageUrls);
                }).collect(Collectors.toList());

        List<Integer> quantities = cartItems.stream()
                .map(Cart::getQuantity)
                .collect(Collectors.toList());

        userResponseDto.setProducts(productDtos);
        userResponseDto.setQuantities(quantities);

        return userResponseDto;
    }

    public UserResponseDto removeFromCart(Long productId, String token) {
        Cart cartItem = cartRepository.findByUserIdAndProductId(jwtService.extractUserId(token), productId)
                .orElseThrow(() -> new RuntimeException("Product not found in cart"));

        int newQuantity = cartItem.getQuantity() - 1;

        if (newQuantity <= 0) {
            cartRepository.delete(cartItem);
        } else {
            cartItem.setQuantity(newQuantity);
            cartRepository.save(cartItem);
        }

        User user = userRepository.findById(jwtService.extractUserId(token)).orElseThrow();
        List<Cart> cartItems = cartRepository.findByUserId(user.getId());
        List<Long> productIdsInCart = cartItems.stream()
                .map(cart -> cart.getProduct().getId())
                .collect(Collectors.toList());
        List<Product> products = productRepository.findAllById(productIdsInCart);

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setToken(token);
        userResponseDto.setId(user.getId());
        userResponseDto.setUsername(user.getUsername());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPassword(user.getPassword());
        userResponseDto.setImageUrl(user.getImageUrl());
        userResponseDto.setRole(user.getRole());


        List<ProductDto> productDtos = products
                .stream()
                .filter(Product::getIsAvailable)
                .map(productItem -> {
                    List<String> imageUrls = productImageRepository.findByProductId(productItem.getId())
                            .stream()
                            .map(ProductImage::getImageUrl)
                            .collect(Collectors.toList());
                    return ProductMapper.toDto(productItem, imageUrls);
                }).collect(Collectors.toList());

        List<Integer> quantities = cartItems.stream()
                .map(Cart::getQuantity)
                .collect(Collectors.toList());

        userResponseDto.setProducts(productDtos);
        userResponseDto.setQuantities(quantities);

        return userResponseDto;
    }
}

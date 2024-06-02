package com.se330.flower_shop_management.backend.service;

import com.se330.flower_shop_management.backend.dto.ProductDto;
import com.se330.flower_shop_management.backend.dto.RecommendedProductsDto;
import com.se330.flower_shop_management.backend.entity.Product;
import com.se330.flower_shop_management.backend.entity.ProductImage;
import com.se330.flower_shop_management.backend.mapper.ProductMapper;
import com.se330.flower_shop_management.backend.repository.ProductImageRepository;
import com.se330.flower_shop_management.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductImageRepository productImageRepository;

    public RecommendedProductsDto getAllRecommendedProducts() {
        List<Product> products = productRepository.findAll();

        List<ProductDto> productDtos = products.stream().map(product -> {
            List<String> imageUrls = productImageRepository.findByProductId(product.getId())
                    .stream()
                    .map(ProductImage::getImageUrl)
                    .collect(Collectors.toList());
            return ProductMapper.toDto(product, imageUrls);
        }).collect(Collectors.toList());

        RecommendedProductsDto response = new RecommendedProductsDto();
        response.setPage(1); 
        response.setResults(productDtos);
        response.setTotalPages((int) Math.floor((double) products.size() / 10)); 
        response.setTotalResults(productDtos.size());

        return response;
    }
}

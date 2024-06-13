package com.se330.flower_shop_management.backend.service;

import com.se330.flower_shop_management.backend.dto.*;
import com.se330.flower_shop_management.backend.entity.Product;
import com.se330.flower_shop_management.backend.entity.ProductImage;
import com.se330.flower_shop_management.backend.mapper.ProductMapper;
import com.se330.flower_shop_management.backend.repository.ProductImageRepository;
import com.se330.flower_shop_management.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
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

    public RecommendedProductsDto getAllProducts() {
        List<Product> products = productRepository.findAll();

        List<ProductDto> productDtos = products
                .stream()
                .filter(Product::getIsAvailable)
                .map(product -> {
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

    public List<Product> getAllProd() {
        return productRepository.findAll();
    }

    public void addProduct(AddProductDto addProductDto) {
        if (addProductDto == null) {
            throw new IllegalArgumentException("Product data cannot be null");
        }

        Product product = new Product();
        product.setName(addProductDto.getName());
        product.setPrice(addProductDto.getPrice());
        product.setSalePrice(addProductDto.getSalePrice());
        product.setSalePercentage(addProductDto.getSalePercentage());
        product.setDetailDescription(addProductDto.getDetailDescription());
        product.setSize(addProductDto.getSize());
        product.setWeight(addProductDto.getWeight());
        product.setColor(addProductDto.getColor());
        product.setMaterial(addProductDto.getMaterial());
        product.setStock(addProductDto.getStock());
        product.setSold(addProductDto.getSold());
        product.setRatingAvg(addProductDto.getRatingAvg());
        product.setTotalRating(addProductDto.getTotalRating());
        product.setIsAvailable(addProductDto.getIsAvailable());

        productRepository.save(product);
    }

    public void updateProduct(Long productId, UpdateProductDto updateProductDto) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (updateProductDto.getName() != null) {
            product.setName(updateProductDto.getName());
        }
        if (updateProductDto.getPrice() != null) {
            product.setPrice(updateProductDto.getPrice());
        }
        if (updateProductDto.getSalePrice() != null) {
            product.setSalePrice(updateProductDto.getSalePrice());
        }
        if (updateProductDto.getSalePercentage() != null) {
            product.setSalePercentage(updateProductDto.getSalePercentage());
        }
        if (updateProductDto.getDetailDescription() != null) {
            product.setDetailDescription(updateProductDto.getDetailDescription());
        }
        if (updateProductDto.getSize() != null) {
            product.setSize(updateProductDto.getSize());
        }
        if (updateProductDto.getWeight() != null) {
            product.setWeight(updateProductDto.getWeight());
        }
        if (updateProductDto.getColor() != null) {
            product.setColor(updateProductDto.getColor());
        }
        if (updateProductDto.getMaterial() != null) {
            product.setMaterial(updateProductDto.getMaterial());
        }
        if (updateProductDto.getStock() != null) {
            product.setStock(updateProductDto.getStock());
        }
        if (updateProductDto.getIsAvailable() != null) {
            product.setIsAvailable(updateProductDto.getIsAvailable());
        }

        productRepository.save(product);
    }

    public void deleteProduct(Long id, DeleteProductDto deleteProductDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        product.setIsAvailable(deleteProductDto.getIsAvailable());

        productRepository.save(product);
    }

    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        List<String> imageUrls = productImageRepository.findByProductId(id).stream()
                .map(ProductImage::getImageUrl)
                .collect(Collectors.toList());

        return mapToProductDto(product, imageUrls);
    }

    private ProductDto mapToProductDto(Product product, List<String> imageUrls) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(String.valueOf(product.getPrice()));
        productDto.setSalePrice(String.valueOf(product.getSalePrice()));
        productDto.setSalePercentage(String.valueOf(product.getSalePercentage()));
        productDto.setDetailDescription(product.getDetailDescription());
        productDto.setSize(product.getSize());
        productDto.setWeight(String.valueOf(product.getWeight()));
        productDto.setColor(product.getColor());
        productDto.setMaterial(product.getMaterial());
        productDto.setStock(product.getStock());
        productDto.setSold(product.getSold());
        productDto.setRatingAvg(String.valueOf(product.getRatingAvg()));
        productDto.setTotalRating(product.getTotalRating());
        productDto.setIsAvailable(product.getIsAvailable());
        productDto.setImageUrls(imageUrls);
        return productDto;
    }

    public List<ProductDto> getAllProductsNoPage() {
        List<Product> products = productRepository.findAll();

        return products
                .stream()
                .filter(Product::getIsAvailable)
                .map(product -> {
                    List<String> imageUrls = productImageRepository.findByProductId(product.getId())
                            .stream()
                            .map(ProductImage::getImageUrl)
                            .collect(Collectors.toList());
                    return ProductMapper.toDto(product, imageUrls);
                }).collect(Collectors.toList());
    }
}

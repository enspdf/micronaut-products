package me.enspdf.service.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Singleton;
import javax.validation.constraints.NotNull;

import me.enspdf.domain.Product;
import me.enspdf.domain.dto.CreateProductDto;
import me.enspdf.domain.dto.UpdateProductDto;
import me.enspdf.repository.ProductRepository;
import me.enspdf.service.ProductService;

@Singleton
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> findById(@NotNull Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(@NotNull CreateProductDto createProductDto) {
        return productRepository.save(createProductDto);
    }

    @Override
    public void deleteById(@NotNull Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public int update(@NotNull Long id, @NotNull UpdateProductDto updateProductDto) {
        updateProductDto.setId(id);
        return productRepository.update(updateProductDto);
    }
}
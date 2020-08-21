package me.enspdf.repository;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import me.enspdf.domain.Product;
import me.enspdf.domain.dto.CreateProductDto;
import me.enspdf.domain.dto.UpdateProductDto;

public interface ProductRepository {
    /**
     * Method used to find a product by id
     * 
     * @param id
     * @return
     */
    Optional<Product> findById(@NotNull Long id);

    /**
     * Method used to save a product entity
     * 
     * @param createProductDto
     * @return
     */
    Product save(@NotNull CreateProductDto createProductDto);

    /**
     * Method used to delete a given product by id
     * 
     * @param id
     */
    void deleteById(@NotNull Long id);

    /**
     * Method used to get all the products
     * 
     * @return
     */
    List<Product> getAll();

    /**
     * Method used to update a given product by id
     * 
     * @param updateProductDto
     * @return
     */
    int update(@NotNull UpdateProductDto updateProductDto);
}
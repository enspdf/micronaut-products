package me.enspdf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import me.enspdf.domain.Product;
import me.enspdf.domain.dto.CreateProductDto;
import me.enspdf.domain.dto.UpdateProductDto;
import me.enspdf.service.ProductService;

@Controller("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Get("/{id}")
    public HttpResponse<Product> getById(Long id) {
        Product product = new Product();

        product = productService.findById(id).orElse(new Product());

        return HttpResponse.ok().body(product);
    }

    @Get
    public HttpResponse<List<Product>> getAll() {
        List<Product> products = new ArrayList<>();

        products = productService.getAll();
        return HttpResponse.ok().body(products);
    }

    @Post
    public HttpResponse<Product> create(@Body @Valid CreateProductDto createProductDto) {
        Product product = productService.save(createProductDto);

        return HttpResponse.created(product);
    }

    @Put("/{id}")
    public HttpResponse<Void> update(Long id, @Body @Valid UpdateProductDto updateProductDto) {
        productService.update(id, updateProductDto);

        return HttpResponse.ok();
    }

    @Delete("/{id}")
    public HttpResponse<Void> delete(Long id) {
        productService.deleteById(id);

        return HttpResponse.noContent();
    }
}
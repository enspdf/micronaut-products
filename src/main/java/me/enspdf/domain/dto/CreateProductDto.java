package me.enspdf.domain.dto;

import javax.validation.constraints.NotBlank;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class CreateProductDto {
    @NotBlank
    private String name;

    @NotBlank
    private String description;

    private Double price;

    public CreateProductDto(@NotBlank String name, @NotBlank String description) {
        this.name = name;
        this.description = description;
    }

    public CreateProductDto(@NotBlank String name, @NotBlank String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return null != price ? price : 0D;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
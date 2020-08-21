package me.enspdf.domain.dto;

import javax.validation.constraints.NotBlank;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class UpdateProductDto {
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    private Double price;

    public UpdateProductDto(Long id, @NotBlank String name, @NotBlank String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public UpdateProductDto(Long id, @NotBlank String name, @NotBlank String description, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
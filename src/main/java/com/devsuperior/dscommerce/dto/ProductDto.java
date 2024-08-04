package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Product;
import jakarta.persistence.Column;

public class ProductDto {

    private Long id;
    private String name;

    private String description;
    private Double price;
    private String imgUrl;

    public ProductDto() {}

    public ProductDto(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();
    }

    public ProductDto(ProductDto productDto) {
        name = productDto.getName();
        description = productDto.getDescription();
        price = productDto.getPrice();
        imgUrl = productDto.getImgUrl();
    }

    public ProductDto(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }



    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}

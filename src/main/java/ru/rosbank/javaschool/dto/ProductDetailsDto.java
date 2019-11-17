package ru.rosbank.javaschool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.model.ProductModel;


@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ProductDetailsDto {
    private int id;
    private String name;
    private int price;
    private String description;

    public abstract ProductModel fromDto();
}
package ru.rosbank.javaschool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.dto.ProductDetailsDto;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
    private int id;
    private String name;
    private int price;

    public ProductModel withId(int id) {
        return new ProductModel(
                id,
                name,
                price
        );
    }

    public static ProductModel from(ProductModel model) {
        return new ProductModel(
                model.getId(),
                model.getName(),
                model.getPrice()
        );
    }

    public static ProductModel from(ProductDetailsDto dto) {
        return new ProductModel(
                dto.getId(),
                dto.getName(),
                dto.getPrice()
        );
    }
}

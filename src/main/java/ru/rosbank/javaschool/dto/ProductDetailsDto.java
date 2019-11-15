package ru.rosbank.javaschool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.model.ProductModel;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailsDto {
    private int id;
    private String name;
    private int price;

    public static ProductDetailsDto from(ProductModel model) {
        return new ProductDetailsDto(
                model.getId(),
                model.getName(),
                model.getPrice()
        );
    }
}
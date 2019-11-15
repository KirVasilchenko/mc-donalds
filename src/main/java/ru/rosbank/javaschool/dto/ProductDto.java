package ru.rosbank.javaschool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.model.ProductModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private int id;
    private String name;
    private int price;

    public static ProductDto from(ProductModel model) {
        return new ProductDto(
                model.getId(),
                model.getName(),
                model.getPrice()
        );
    }
}
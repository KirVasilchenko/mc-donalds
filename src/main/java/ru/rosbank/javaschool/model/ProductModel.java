package ru.rosbank.javaschool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.dto.BurgerDetailsDto;
import ru.rosbank.javaschool.dto.ProductDetailsDto;


@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class ProductModel {
    public int id;
    public String name;
    public int price;
    public String description;

//    public ProductModel withId(int id) {
//        return new ProductModel(
//                id,
//                name,
//                price,
//                description
//        );
//    }

//    public static ProductModel from(ProductModel model) {
//        return new ProductModel(
//                model.getId(),
//                model.getName(),
//                model.getPrice(),
//                model.getDescription()
//        );
//    }

//    public static ProductModel from(ProductDetailsDto dto) {
//        return new ProductModel(
//                dto.getId(),
//                dto.getName(),
//                dto.getPrice(),
//                dto.getDescription()
//        );

//    public static ProductModel from(ProductDetailsDto dto) {
//
//        return new ProductModel();
//    }

    public abstract ProductDetailsDto toDto();
}

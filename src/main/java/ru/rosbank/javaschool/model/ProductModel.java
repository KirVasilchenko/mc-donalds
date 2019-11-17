package ru.rosbank.javaschool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.dto.ProductDetailsDto;


@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class ProductModel {
    public int id;
    public String name;
    public int price;
    public String description;

    public abstract ProductDetailsDto toDto();
}

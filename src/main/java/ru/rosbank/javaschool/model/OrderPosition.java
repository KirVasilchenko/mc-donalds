package ru.rosbank.javaschool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPosition {
    private int id;
    private String name;
    private int price;
    private int count;

    public OrderPosition(ProductModel item, int count) {
        this.id = item.getId();
        this.name = item.getName();
        this.price = item.getPrice();
        this.count = count;
    }
}

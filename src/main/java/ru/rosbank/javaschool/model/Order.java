package ru.rosbank.javaschool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private List<OrderPosition> positions;
    private int id;

    public Order(int id, List<OrderPosition> positions) {
        this.id = id;
        this.positions = positions;
    }

    public static Order copy(Order item) {
        return new Order(item.getId(), item.getPositions());
    }

    public void add(OrderPosition item) {
        positions.add(item);
    }
}

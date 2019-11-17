package ru.rosbank.javaschool;

import ru.rosbank.javaschool.dto.BurgerDetailsDto;
import ru.rosbank.javaschool.model.Order;
import ru.rosbank.javaschool.model.OrderPosition;
import ru.rosbank.javaschool.repository.OrderRepositoryImpl;
import ru.rosbank.javaschool.repository.ProductRepositoryImpl;
import ru.rosbank.javaschool.service.ProductServiceImpl;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());
        service.saveProduct(new BurgerDetailsDto(
                0,
                "Cheeseburger",
                52,
                "Juicy meat",
                "Beef",
                1
        ));

        Order order = new Order(0, new LinkedList<OrderPosition>());
        OrderPosition position = new OrderPosition(service.getProductById(1), 1);
        order.add(position);
        service.saveOrder(order);

        System.out.println(service.getOrderById(1).toString());

    }
}

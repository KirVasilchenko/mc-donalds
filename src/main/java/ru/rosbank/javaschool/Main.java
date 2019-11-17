package ru.rosbank.javaschool;

import ru.rosbank.javaschool.dto.BurgerDetailsDto;
import ru.rosbank.javaschool.repository.OrderRepositoryImpl;
import ru.rosbank.javaschool.repository.ProductRepositoryImpl;
import ru.rosbank.javaschool.service.ProductServiceImpl;

public class Main {
    public static void main(String[] args) {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());
        service.saveProduct(new BurgerDetailsDto(
                0,
                "Cheeseburger",
                52,
                "Juicy meat",
                "Beef",
                1
        ));

        String text = service.getAllProducts().toString();
        System.out.println(text);

        boolean result = service.removeProductById(1);
        System.out.println(result);

    }
}

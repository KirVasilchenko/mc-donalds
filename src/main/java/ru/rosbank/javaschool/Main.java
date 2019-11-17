package ru.rosbank.javaschool;

import ru.rosbank.javaschool.dto.BurgerDetailsDto;
import ru.rosbank.javaschool.dto.ProductDetailsDto;
import ru.rosbank.javaschool.model.ProductModel;
import ru.rosbank.javaschool.repository.ProductRepositoryImpl;
import ru.rosbank.javaschool.service.ProductServiceImpl;

public class Main {
    public static void main(String[] args) {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl());
        service.save(new BurgerDetailsDto(
                0,
                "Cheeseburger",
                52,
                "Juicy meat",
                "Beef",
                1
        ));

        System.out.println(service.getAll());

    }
}

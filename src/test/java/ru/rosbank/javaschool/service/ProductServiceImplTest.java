package ru.rosbank.javaschool.service;

import org.junit.jupiter.api.Test;
import ru.rosbank.javaschool.dto.BurgerDetailsDto;
import ru.rosbank.javaschool.repository.OrderRepositoryImpl;
import ru.rosbank.javaschool.repository.ProductRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {

    @Test
    void getAllProducts() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());
        service.saveProduct(new BurgerDetailsDto(
                0,
                "Cheeseburger",
                52,
                "Juicy meat",
                "Beef",
                1
        ));

        String result = service.getAllProducts().toString();

        assertEquals("[ProductDto(id=1, name=Cheeseburger, price=52)]", result);
    }

    @Test
    void getProductById() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());
        service.saveProduct(new BurgerDetailsDto(
                0,
                "Cheeseburger",
                52,
                "Juicy meat",
                "Beef",
                1
        ));

        String result = service.getProductById(1).toString();

        assertEquals("BurgerDetailsDto(cutletMeat=Beef, cutletCount=1)", result);
    }

//    @Test
//    void saveProduct() {
//    }

    @Test
    void removeProductById() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());
        service.saveProduct(new BurgerDetailsDto(
                0,
                "Cheeseburger",
                52,
                "Juicy meat",
                "Beef",
                1
        ));

        boolean result = service.removeProductById(1);

        assertEquals(true, result);
    }

    @Test
    void getProductBySearch() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());
        service.saveProduct(new BurgerDetailsDto(
                0,
                "Cheeseburger",
                52,
                "Juicy meat",
                "Beef",
                1
        ));

        String result = service.getProductBySearch("Cheeseburger").toString();

        assertEquals("[ProductDto(id=1, name=Cheeseburger, price=52)]", result);
    }

    @Test
    void getCategoryListingSuccess() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());
        service.saveProduct(new BurgerDetailsDto(
                0,
                "Cheeseburger",
                52,
                "Juicy meat",
                "Beef",
                1
        ));

        String result = service.getCategoryListing("Burger").toString();

        assertEquals("[ProductDto(id=1, name=Cheeseburger, price=52)]", result);
    }

    @Test
    void getCategoryListingNothing() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());
        service.saveProduct(new BurgerDetailsDto(
                0,
                "Cheeseburger",
                52,
                "Juicy meat",
                "Beef",
                1
        ));

        String result = service.getCategoryListing("Drink").toString();

        assertEquals("[]", result);
    }

}
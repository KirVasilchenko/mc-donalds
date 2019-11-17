package ru.rosbank.javaschool.service;

import org.junit.jupiter.api.Test;
import ru.rosbank.javaschool.dto.BurgerDetailsDto;
import ru.rosbank.javaschool.dto.DessertDetailsDto;
import ru.rosbank.javaschool.dto.DrinkDetailsDto;
import ru.rosbank.javaschool.dto.PotatoDetailsDto;
import ru.rosbank.javaschool.exception.DataNotFoundException;
import ru.rosbank.javaschool.exception.DataSaveException;
import ru.rosbank.javaschool.exception.InvalidDataException;
import ru.rosbank.javaschool.model.Order;
import ru.rosbank.javaschool.model.OrderPosition;
import ru.rosbank.javaschool.repository.OrderRepositoryImpl;
import ru.rosbank.javaschool.repository.ProductRepositoryImpl;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {

    @Test
    void getProductByIdShouldThrowExceptionWhenNoItemsInRepo() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());

        assertThrows(DataNotFoundException.class, () -> service.getProductById(1));
    }

    @Test
    void getProductByIdShouldThrowExceptionWhenNoSuchItemInRepo() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());
        service.saveProduct(new BurgerDetailsDto(
                0,
                "Cheeseburger",
                52,
                "Juicy meat",
                "Beef",
                1
        ));

        assertThrows(DataNotFoundException.class, () -> service.getProductById(2));
    }

    @Test
    void getProductByIdShouldReturnDtoWhenItemPresentInRepo() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());
        service.saveProduct(new BurgerDetailsDto(
                0,
                "Cheeseburger",
                52,
                "Juicy meat",
                "Beef",
                1
        ));
        assertNotNull(service.getProductById(1));
    }

    @Test
    void getOrderByIdShouldThrowExceptionWhenNoItemsInRepo() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());

        assertThrows(DataNotFoundException.class, () -> service.getOrderById(1));
    }

    @Test
    void getOrderByIdShouldThrowExceptionWhenNoSuchItemInRepo() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());
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

        assertThrows(DataNotFoundException.class, () -> service.getOrderById(2));
    }

    @Test
    void getOrderByIdShouldReturnDtoWhenItemPresentInRepo() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());
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

        assertNotNull(service.getOrderById(1));
    }

    @Test
    void removeProductByIdShouldThrowExceptionWhenNoItemsInRepo() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());
        assertThrows(DataNotFoundException.class, () -> service.removeProductById(1));
    }

    @Test
    void removeProductByIdShouldThrowExceptionWhenNoSuchItemInRepo() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());
        service.saveProduct(new BurgerDetailsDto(
                0,
                "Cheeseburger",
                52,
                "Juicy meat",
                "Beef",
                1
        ));

        assertThrows(DataNotFoundException.class, () -> service.removeProductById(2));
    }

    @Test
    void removeProductByIdShouldReturnTrueWhenItemPresentInRepo() {
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
        assertTrue(result);
    }

    @Test
    void removeOrderByIdShouldThrowExceptionWhenNoItemsInRepo() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());

        assertThrows(DataNotFoundException.class, () -> service.removeOrderById(1));
    }

    @Test
    void removeOrderByIdShouldThrowExceptionWhenNoSuchItemInRepo() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());
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

        assertThrows(DataNotFoundException.class, () -> service.removeOrderById(2));
    }

    @Test
    void removeOrderByIdShouldReturnTrueWhenItemPresentInRepo() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());
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

        boolean result = service.removeOrderById(1);
        assertTrue(result);
    }

    @Test
    void getAllProductsCanGetSavedProducts() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());
        service.saveProduct(new BurgerDetailsDto(
                0,
                "Cheeseburger",
                52,
                "Juicy meat",
                "Beef",
                1
        ));
        assertNotNull(service.getAllProducts());
    }

    @Test
    void saveProductFailsWithNegativeId() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());

        assertThrows(InvalidDataException.class, () -> service.saveProduct(new BurgerDetailsDto(
                -1,
                "Cheeseburger",
                52,
                "Juicy meat",
                "Beef",
                1
        )));
    }

    @Test
    void saveProductFailsWithEmptyName() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());

        assertThrows(InvalidDataException.class, () -> service.saveProduct(new BurgerDetailsDto(
                0,
                null,
                52,
                "Juicy meat",
                "Beef",
                1
        )));
    }

    @Test
    void saveProductFailsWithNegativePrice() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());

        assertThrows(InvalidDataException.class, () -> service.saveProduct(new BurgerDetailsDto(
                0,
                "Cheeseburger",
                -52,
                "Juicy meat",
                "Beef",
                1
        )));
    }

    @Test
    void saveProductUpdatesExistingProductAsBurger() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());
        service.saveProduct(new BurgerDetailsDto(
                0,
                "Cheeseburger",
                52,
                "Juicy meat",
                "Beef",
                1
        ));
        service.saveProduct(new BurgerDetailsDto(
                1,
                "Hamburger",
                50,
                "Juicy meat",
                "Beef",
                1
        ));

        assertEquals(service.getProductById(1).getName(), "Hamburger");
    }

    @Test
    void saveProductUpdatesExistingProductAsPotato() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());
        service.saveProduct(new PotatoDetailsDto(
                0,
                "FryS",
                49,
                "Small french fries",
                50
        ));
        service.saveProduct(new PotatoDetailsDto(
                1,
                "FryM",
                56,
                "Medium french fries",
                75
        ));

        assertEquals(service.getProductById(1).getName(), "FryM");
    }

    @Test
    void saveProductUpdatesExistingProductAsDrink() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());
        service.saveProduct(new DrinkDetailsDto(
                0,
                "FantaS",
                49,
                "Small drink of Fanta",
                250
        ));
        service.saveProduct(new DrinkDetailsDto(
                1,
                "SpriteS",
                49,
                "Small drink of Sprite",
                250
        ));

        assertEquals(service.getProductById(1).getName(), "SpriteS");
    }

    @Test
    void saveProductUpdatesExistingProductAsDessert() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());
        service.saveProduct(new DessertDetailsDto(
                0,
                "Cheesecake",
                149,
                "Tasty cheesecake with strawberry syrup",
                "Strawberry"
        ));
        service.saveProduct(new DessertDetailsDto(
                1,
                "Cheesecake",
                149,
                "Tasty cheesecake with caramel syrup",
                "Caramel"
        ));

        assertEquals(((DessertDetailsDto) service.getProductById(1)).getSyrup(), "Caramel");
    }

    @Test
    void saveProductFailsUpdateNonExistingProduct() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());
        service.saveProduct(new BurgerDetailsDto(
                0,
                "Cheeseburger",
                52,
                "Juicy meat",
                "Beef",
                1
        ));


        assertThrows(DataSaveException.class, () -> service.saveProduct(new BurgerDetailsDto(
                2,
                "Hamburger",
                50,
                "Juicy meat",
                "Beef",
                1
        )));
    }

    @Test
    void getAllOrdersCanGetSavedOrders() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());
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

        assertNotNull(service.getAllOrders());
    }

    @Test
    void saveOrderUpdatesExistingOrder() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());
        service.saveProduct(new BurgerDetailsDto(
                0,
                "Cheeseburger",
                52,
                "Juicy meat",
                "Beef",
                1
        ));
        service.saveProduct(new BurgerDetailsDto(
                0,
                "Hamburger",
                50,
                "Juicy meat",
                "Beef",
                1
        ));

        Order order = new Order(0, new LinkedList<OrderPosition>());
        OrderPosition position = new OrderPosition(service.getProductById(1), 1);
        order.add(position);
        service.saveOrder(order);

        order = new Order(1, new LinkedList<OrderPosition>());
        position = new OrderPosition(service.getProductById(2), 1);
        order.add(position);
        service.saveOrder(order);

        assertNotNull(service.getOrderById(1));
    }

    @Test
    void saveOrderFailsWithNegativeId() {
        final ProductServiceImpl service = new ProductServiceImpl(new ProductRepositoryImpl(), new OrderRepositoryImpl());
        service.saveProduct(new BurgerDetailsDto(
                0,
                "Cheeseburger",
                52,
                "Juicy meat",
                "Beef",
                1
        ));

        Order order = new Order(-1, new LinkedList<OrderPosition>());
        OrderPosition position = new OrderPosition(service.getProductById(1), 1);
        order.add(position);

        assertThrows(InvalidDataException.class, () -> service.saveOrder(order));
    }
}
package ru.rosbank.javaschool.service;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.rosbank.javaschool.dto.BurgerDetailsDto;
import ru.rosbank.javaschool.exception.DataNotFoundException;
import ru.rosbank.javaschool.model.BurgerModel;
import ru.rosbank.javaschool.model.Order;
import ru.rosbank.javaschool.model.OrderPosition;
import ru.rosbank.javaschool.repository.OrderRepositoryImpl;
import ru.rosbank.javaschool.repository.ProductRepositoryImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @Test
    void getProductByIdShouldThrowExceptionWhenNoItemsInRepo() {
        val pRepository = mock(ProductRepositoryImpl.class);
        val oRepository = mock(OrderRepositoryImpl.class);
        doReturn(Optional.empty()).when(pRepository).getById(1);
        val service = new ProductServiceImpl(pRepository, oRepository);

        assertThrows(DataNotFoundException.class, () -> service.getProductById(1));
    }

    @Test
    void getProductByIdShouldThrowExceptionWhenNoSuchItemInRepo() {
        val pRepository = mock(ProductRepositoryImpl.class);
        val oRepository = mock(OrderRepositoryImpl.class);
        doReturn(Optional.of(new BurgerModel())).when(pRepository).getById(1);
        doReturn(Optional.empty()).when(pRepository).getById(anyInt());
        val service = new ProductServiceImpl(pRepository, oRepository);

        assertThrows(DataNotFoundException.class, () -> service.getProductById(2));
    }

    @Test
    void getProductByIdShouldReturnDtoWhenItemPresentInRepo() {
        val pRepository = mock(ProductRepositoryImpl.class);
        val oRepository = mock(OrderRepositoryImpl.class);
        doReturn(Optional.of(new BurgerModel())).when(pRepository).getById(1);
        val service = new ProductServiceImpl(pRepository, oRepository);

        assertNotNull(service.getProductById(1));
    }

    @Test
    void getOrderByIdShouldThrowExceptionWhenNoItemsInRepo() {
        val pRepository = mock(ProductRepositoryImpl.class);
        val oRepository = mock(OrderRepositoryImpl.class);
        doReturn(Optional.empty()).when(oRepository).getById(1);
        val service = new ProductServiceImpl(pRepository, oRepository);

        assertThrows(DataNotFoundException.class, () -> service.getOrderById(1));
    }

    @Test
    void getOrderByIdShouldThrowExceptionWhenNoSuchItemInRepo() {
        val pRepository = mock(ProductRepositoryImpl.class);
        val oRepository = mock(OrderRepositoryImpl.class);
        doReturn(Optional.of(new Order())).when(oRepository).getById(1);
        doReturn(Optional.empty()).when(oRepository).getById(anyInt());
        val service = new ProductServiceImpl(pRepository, oRepository);

        assertThrows(DataNotFoundException.class, () -> service.getOrderById(2));
    }

    @Test
    void getOrderByIdShouldReturnDtoWhenItemPresentInRepo() {
        val pRepository = mock(ProductRepositoryImpl.class);
        val oRepository = mock(OrderRepositoryImpl.class);
        doReturn(Optional.of(new Order())).when(oRepository).getById(1);
        val service = new ProductServiceImpl(pRepository, oRepository);

        assertNotNull(service.getOrderById(1));
    }

    @Test
    void removeProductByIdShouldThrowExceptionWhenNoItemsInRepo() {
        val pRepository = mock(ProductRepositoryImpl.class);
        val oRepository = mock(OrderRepositoryImpl.class);
        doReturn(Optional.empty()).when(pRepository).getById(1);
        val service = new ProductServiceImpl(pRepository, oRepository);

        assertThrows(DataNotFoundException.class, () -> service.removeProductById(1));
    }

    @Test
    void removeProductByIdShouldThrowExceptionWhenNoSuchItemInRepo() {
        val pRepository = mock(ProductRepositoryImpl.class);
        val oRepository = mock(OrderRepositoryImpl.class);
        doReturn(Optional.of(new BurgerModel())).when(pRepository).getById(1);
        doReturn(Optional.empty()).when(pRepository).getById(anyInt());
        val service = new ProductServiceImpl(pRepository, oRepository);

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
        assertEquals(true, result);
    }

    @Test
    void removeOrderByIdShouldThrowExceptionWhenNoItemsInRepo() {
        val pRepository = mock(ProductRepositoryImpl.class);
        val oRepository = mock(OrderRepositoryImpl.class);
        doReturn(Optional.empty()).when(oRepository).getById(1);
        val service = new ProductServiceImpl(pRepository, oRepository);

        assertThrows(DataNotFoundException.class, () -> service.removeOrderById(1));
    }

    @Test
    void removeOrderByIdShouldThrowExceptionWhenNoSuchItemInRepo() {
        val pRepository = mock(ProductRepositoryImpl.class);
        val oRepository = mock(OrderRepositoryImpl.class);
        doReturn(Optional.of(new Order())).when(oRepository).getById(1);
        doReturn(Optional.empty()).when(oRepository).getById(anyInt());
        val service = new ProductServiceImpl(pRepository, oRepository);

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

        boolean result = service.removeProductById(1);
        assertEquals(true, result);
    }
}
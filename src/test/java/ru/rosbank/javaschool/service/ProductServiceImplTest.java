package ru.rosbank.javaschool.service;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.rosbank.javaschool.exception.DataNotFoundException;
import ru.rosbank.javaschool.model.BurgerModel;
import ru.rosbank.javaschool.model.Order;
import ru.rosbank.javaschool.repository.OrderRepositoryImpl;
import ru.rosbank.javaschool.repository.ProductRepositoryImpl;

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
}
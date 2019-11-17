package ru.rosbank.javaschool.service;

import ru.rosbank.javaschool.dto.ProductDetailsDto;
import ru.rosbank.javaschool.dto.ProductDto;
import ru.rosbank.javaschool.model.Order;
import ru.rosbank.javaschool.model.ProductModel;

import java.util.Collection;

public interface ProductService {
    Collection<ProductDto> getAllProducts();

    Collection<Order> getAllOrders();

    ProductDetailsDto getProductById(int id);

    Order getOrderById(int id);

    ProductModel saveProduct(ProductDetailsDto dto);

    Order saveOrder(Order item);

    boolean removeProductById(int id);

    boolean removeOrderById(int id);

    Collection<ProductDto> getProductBySearch(String query);

    Collection<ProductDto> getCategoryListing(String category);
}

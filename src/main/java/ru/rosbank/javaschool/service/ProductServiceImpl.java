package ru.rosbank.javaschool.service;

import lombok.AllArgsConstructor;
import ru.rosbank.javaschool.dto.ProductDetailsDto;
import ru.rosbank.javaschool.dto.ProductDto;
import ru.rosbank.javaschool.exception.DataNotFoundException;
import ru.rosbank.javaschool.exception.InvalidDataException;
import ru.rosbank.javaschool.model.Order;
import ru.rosbank.javaschool.model.ProductModel;
import ru.rosbank.javaschool.repository.OrderRepository;
import ru.rosbank.javaschool.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository products;
    private OrderRepository orders;

    @Override
    public Collection<ProductDto> getAllProducts() {
        return products.getAll().stream()
                .map(ProductDto::from)
                .collect(Collectors.toList())
                ;
    }

    @Override
    public ProductDetailsDto getProductById(int id) {
        return products.getById(id)
                .map(ProductModel::toDto)
                .orElseThrow(DataNotFoundException::new)
                ;
    }

    @Override
    public ProductModel saveProduct(ProductDetailsDto dto) {
        if (dto.getId() < 0) {
            throw new InvalidDataException("Id can't be negative");
        }

        if (dto.getName() == null) {
            throw new InvalidDataException("Name can't be empty");
        }

        if (dto.getPrice() < 0) {
            throw new InvalidDataException("Price can't be negative");
        }

        if (dto.getId() == 0) {
            return products.create(dto.fromDto());
        }

        return products.update(dto.fromDto());
    }

    @Override
    public boolean removeProductById(int id) {
        boolean removed = products.removeById(id);
        if (!removed) {
            throw new DataNotFoundException();
        }
        return true;
    }

    @Override
    //TODO: cover!
    public Collection<Order> getAllOrders() {
        return new ArrayList<>(orders.getAll())
                ;
    }

    @Override
    public Order getOrderById(int id) {
        return orders.getById(id)
                .orElseThrow(DataNotFoundException::new)
                ;
    }

    @Override
    //TODO: cover!
    public Order saveOrder(Order item) {
        if (item.getId() < 0) {
            throw new InvalidDataException("Id can't be negative");
        }

        if (item.getId() == 0) {
            return orders.create(item);
        }

        return orders.update(item);
    }

    @Override
    public boolean removeOrderById(int id) {
        boolean removed = orders.removeById(id);
        if (!removed) {
            throw new DataNotFoundException();
        }
        return true;
    }

    @Override
    //TODO: cover!
    public Collection<ProductDto> getProductBySearch(String query) {
        return products.getAll().stream()
                .filter(o -> o.getName().toLowerCase().contains(query.toLowerCase()))
                .map(ProductDto::from)
                .collect(Collectors.toList())
                ;
    }

    @Override
    //TODO: cover!
    public Collection<ProductDto> getCategoryListing(String category) {
        return products.getAll().stream()
                .filter(o -> o.getClass().getSimpleName().toLowerCase().contains(category.toLowerCase()))
                .map(ProductDto::from)
                .collect(Collectors.toList())
                ;
    }

}
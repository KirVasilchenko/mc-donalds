package ru.rosbank.javaschool.repository;

import ru.rosbank.javaschool.model.ProductModel;

import java.util.Collection;
import java.util.Optional;

public interface ProductRepository {
    Collection<? extends ProductModel> getAll();

    Optional<ProductModel> getById(int id);

    ProductModel create(ProductModel item);

    ProductModel update(ProductModel item);

    boolean removeById(int id);
}

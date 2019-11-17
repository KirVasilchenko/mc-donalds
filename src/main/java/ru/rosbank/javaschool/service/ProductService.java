package ru.rosbank.javaschool.service;

import ru.rosbank.javaschool.dto.ProductDetailsDto;
import ru.rosbank.javaschool.dto.ProductDto;
import ru.rosbank.javaschool.model.ProductModel;

import java.util.Collection;
import java.util.List;

public interface ProductService {
    Collection<ProductDto> getAll();

    ProductDetailsDto getById(int id);

    ProductModel save(ProductDetailsDto dto);

    boolean removeById(int id);
}

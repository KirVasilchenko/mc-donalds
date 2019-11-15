package ru.rosbank.javaschool.service;

import ru.rosbank.javaschool.dto.ProductDetailsDto;
import ru.rosbank.javaschool.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAll();

    ProductDetailsDto getById(int id);

    void save(ProductDetailsDto dto);

    void removeById(int id);
}

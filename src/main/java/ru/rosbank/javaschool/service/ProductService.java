package ru.rosbank.javaschool.service;

import ru.rosbank.javaschool.dto.ProductDetailsDto;
import ru.rosbank.javaschool.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<? extends ProductDto> getAll();

    ProductDetailsDto getById(int id);

    //    void save(ProductDetailsDto dto);
    <T extends ProductDetailsDto> void save(T dto);

    void removeById(int id);
}

package ru.rosbank.javaschool.service;

import lombok.RequiredArgsConstructor;
import ru.rosbank.javaschool.dto.ProductDetailsDto;
import ru.rosbank.javaschool.dto.ProductDto;
import ru.rosbank.javaschool.exception.DataNotFoundException;
import ru.rosbank.javaschool.exception.InvalidDataException;
import ru.rosbank.javaschool.model.ProductModel;
import ru.rosbank.javaschool.repository.ProductRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    @Override
    public Collection<ProductDto> getAll() {
        return repository.getAll().stream()
                .map(ProductDto::from)
                .collect(Collectors.toList())
                ;
    }

    @Override
    public ProductDetailsDto getById(int id) {
        return repository.getById(id)
                .map(ProductModel::toDto)
                .orElseThrow(DataNotFoundException::new)
                ;
    }

    @Override
    public ProductModel save(ProductDetailsDto dto) {
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
            return repository.create(dto.fromDto());
        }

        return repository.update(dto.fromDto());
    }

    @Override
    public boolean removeById(int id) {
        boolean removed = repository.removeById(id);
        if (!removed) {
            throw new DataNotFoundException();
        }
        return true;
    }
}
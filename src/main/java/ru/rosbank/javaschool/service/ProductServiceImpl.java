package ru.rosbank.javaschool.service;

import lombok.RequiredArgsConstructor;
import ru.rosbank.javaschool.dto.BurgerDetailsDto;
import ru.rosbank.javaschool.dto.ProductDetailsDto;
import ru.rosbank.javaschool.dto.ProductDto;
import ru.rosbank.javaschool.model.BurgerModel;
import ru.rosbank.javaschool.model.ProductModel;
import ru.rosbank.javaschool.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    @Override
    public List<? extends ProductDto> getAll() {
        return repository.getAll().stream()
                .map(ProductDto::from)
                .collect(Collectors.toList())
                ;
    }

    @Override
    public ProductDetailsDto getById(int id) {
        return repository.getById(id)
                .map(ProductDetailsDto::from)
                .orElseThrow(RuntimeException::new)
                ;
    }

    //TODO: test save of burger, then extend features
    @Override
    public <T extends ProductDetailsDto> void save(T dto) {
        if (dto.getId() < 0) {
            throw new RuntimeException("Id can't be negative");
        }

        if (dto.getPrice() < 0) {
            throw new RuntimeException("Price can't be negative");
        }

        if (dto.getId() == 0) {
            if (dto instanceof BurgerDetailsDto) {
                repository.create(BurgerModel.from(dto));
            }
//                repository.create(ProductModel.from(dto));
            return;
        }

        if (dto instanceof BurgerDetailsDto) {
            repository.update(BurgerModel.from(dto));
        }
//        repository.update(ProductModel.from(dto));
    }

    @Override
    public void removeById(int id) {
        boolean removed = repository.removeById(id);
        if (!removed) {
            throw new RuntimeException();
        }
    }
}
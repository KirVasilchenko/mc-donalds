package ru.rosbank.javaschool.repository;

import ru.rosbank.javaschool.exception.DataSaveException;
import ru.rosbank.javaschool.model.ProductModel;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductRepositoryImpl implements ProductRepository {
    private Collection<ProductModel> items = new LinkedList<>();
    private int nextId = 1;

    @Override
    public Collection<ProductModel> getAll() {
        return Collections.unmodifiableCollection(items);
    }

    @Override
    public Optional<ProductModel> getById(int id) {
        return items.stream()
                .filter(o -> o.getId() == id)
                .findFirst()
                ;
    }

    @Override
    public ProductModel create(ProductModel item) {
        item.setId(nextId++);
        items.add(item);
        return item;
    }

    @Override
    public ProductModel update(ProductModel item) {
        for (ProductModel keep : items) {
            if (keep.getId() == item.getId()) {
                keep.setName(item.getName());
                keep.setPrice(item.getPrice());
                keep.setDescription(item.getDescription());
                return item;
            }
        }
        throw new DataSaveException("Item id = " + item.getId() + " was not found.");
    }

    @Override
    public boolean removeById(int id) {
        Collection<? extends ProductModel> original = items;
        Collection<ProductModel> copy = items.stream()
                .filter(o -> o.getId() != id)
                .collect(Collectors.toList());
        items = copy;
        return original.size() == copy.size();
    }
}

package ru.rosbank.javaschool.repository;

import ru.rosbank.javaschool.model.ProductModel;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductRepositoryImpl implements ProductRepository {
    private Collection<? extends ProductModel> items = Collections.emptyList();
    private int nextId = 1;

    @Override
    public Collection<ProductModel> getAll() {
        return Collections.unmodifiableCollection(items);
    }

    @Override
    public Optional<? extends ProductModel> getById(int id) {
        return items.stream()
                .filter(o -> o.getId() == id)
                .findFirst()
                ;
    }

    @Override
    public ProductModel create(ProductModel item) {
        ProductModel copy = item.withId(nextId++);
        items = Stream.concat(items.stream(), Stream.of(copy))
                .collect(Collectors.toList())
        ;
        return copy;
    }

    @Override
    public ProductModel update(ProductModel item) {
        ProductModel copy = ProductModel.from(item);

        items.stream()
                .filter(o -> o.getId() == copy.getId())
                .findAny()
                .orElseThrow(RuntimeException::new)
        ;

        items = items.stream()
                .map(o -> o.getId() == copy.getId() ? copy : o)
                .collect(Collectors.toList())
        ;
        return copy;
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

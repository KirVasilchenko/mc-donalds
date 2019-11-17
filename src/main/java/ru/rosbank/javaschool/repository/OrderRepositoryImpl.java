package ru.rosbank.javaschool.repository;

import ru.rosbank.javaschool.exception.DataSaveException;
import ru.rosbank.javaschool.model.Order;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderRepositoryImpl implements OrderRepository {
    private Collection<Order> items = new LinkedList<>();
    private int nextId = 1;


    @Override
    //TODO: cover!
    public Collection<Order> getAll() {
        return Collections.unmodifiableCollection(items);
    }

    @Override
    //TODO: cover!
    public Optional<Order> getById(int id) {
        return items.stream()
                .filter(o -> o.getId() == id)
                .findFirst()
                ;
    }

    @Override
    public Order create(Order item) {
        item.setId(nextId++);
        items.add(item);
        return item;
    }

    @Override
    //TODO: cover!
    public Order update(Order item) {
        for (Order keep : items) {
            if (keep.getId() == item.getId()) {
                keep.setPositions(item.getPositions());
                return item;
            }
        }
        throw new DataSaveException("Order id = " + item.getId() + " was not found.");
    }

    @Override
    //TODO: cover!
    public boolean removeById(int id) {
        Collection<Order> original = items;
        Collection<Order> copy = items.stream()
                .filter(o -> o.getId() != id)
                .collect(Collectors.toList());
        items = copy;
        return original.size() == copy.size();
    }
}

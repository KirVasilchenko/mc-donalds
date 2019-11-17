package ru.rosbank.javaschool.repository;

import ru.rosbank.javaschool.model.Order;

import java.util.Collection;
import java.util.Optional;

public interface OrderRepository {

    Collection<Order> getAll();

    Optional<Order> getById(int id);

    Order create(Order item);

    Order update(Order item);

    boolean removeById(int id);
}

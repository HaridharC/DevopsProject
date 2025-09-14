
package com.restaurant.service;

import com.restaurant.model.Order;
import com.restaurant.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repo;
    public OrderService(OrderRepository repo) { this.repo = repo; }
    public Order save(Order o) { return repo.save(o); }
    public List<Order> pending() { return repo.findByDeliveredFalse(); }
    public List<Order> all() { return repo.findAll(); }
    public java.util.Optional<Order> find(Long id) { return repo.findById(id); }
}

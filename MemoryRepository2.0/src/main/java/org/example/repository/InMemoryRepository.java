package org.example.repository;

import java.util.*;
import org.example.entities.Product;

public class InMemoryRepository<T extends Product> {
    private final Map<String, T> storage = new HashMap<>();

    public void save(T entity) {
        if (!storage.containsKey(entity.getId())) {
            storage.put(entity.getId(), entity);
        } else {
            System.out.println("Erro: Já existe um produto com esse ID.");
        }
    }

    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<T> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }
}

package org.example.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EntityRepository<T> {
    void save(T entity);  // Salvar um registro
    Optional<T> findById(UUID uuid);  // Buscar por ID
    List<T> findAll();  // Listar todos os registros
    void deleteById(UUID uuid);  // Remover por ID
}

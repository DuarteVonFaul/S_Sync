package com.dvf.project.S_Sync.domain.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BasicService<T> {
    private final JpaRepository<T, Integer> repository;

    public BasicService(@Qualifier("taskRepository") JpaRepository<T, Integer> repository) {
        this.repository = repository;
    }

    public T create(T entity) {
        return repository.save(entity);
    }

    public List<T> get_all() {
        return repository.findAll();
    }

    public Optional<T> find_by_id(Integer id) {
        return repository.findById(id);
    }

    public void delete_by_id(Integer id) {
        repository.deleteById(id);
    }

    public T update_by_id(T entity, Integer id) {
        Optional<T> optionalEntityDoBanco = repository.findById(id);
        if (optionalEntityDoBanco.isPresent()) {
            T entityDoBanco = optionalEntityDoBanco.get();
            BeanUtils.copyProperties(entity, entityDoBanco, "id");
            return repository.save(entityDoBanco);
        } else {
            throw new IllegalArgumentException("Registro não encontrado.");
        }
    }



}

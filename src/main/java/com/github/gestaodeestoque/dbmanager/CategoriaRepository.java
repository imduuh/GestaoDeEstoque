package com.github.gestaodeestoque.dbmanager;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CategoriaRepository implements PanacheRepository<CategoriaEntity> {
}

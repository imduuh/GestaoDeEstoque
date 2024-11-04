package com.github.gestaodeestoque.service;

import com.github.gestaodeestoque.dbmanager.CategoriaEntity;
import com.github.gestaodeestoque.dbmanager.CategoriaRepository;
import com.github.gestaodeestoque.model.dto.CategoriaDto;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class CategoriaService {

    @Inject
    CategoriaRepository categoriaRepository;

    @Transactional
    public void adicionarCategoria(CategoriaDto categoriaDto) {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setNome(categoriaDto.nome);
        categoriaRepository.persist(categoriaEntity);
    }

    public List<CategoriaDto> listarTodasCategorias() {
        List<CategoriaEntity> categoriasEntity = categoriaRepository.listAll();
        List<CategoriaDto> categoriasDto = new ArrayList<>();
        for (CategoriaEntity categoria : categoriasEntity) {
            categoriasDto.add(new CategoriaDto(categoria.getId(), categoria.getNome()));
        }
        return categoriasDto;
    }

    public CategoriaDto buscarCategoriaPorId(Long id) {
        CategoriaEntity categoriaEntity = categoriaRepository.findById(id);
        if (categoriaEntity != null) {
            return new CategoriaDto(categoriaEntity.getId(), categoriaEntity.getNome());
        }
        return null;
    }

    @Transactional
    public void atualizarCategoria(Long id, CategoriaDto categoriaDto) {
        CategoriaEntity categoriaEntity = categoriaRepository.findById(id);
        if (categoriaEntity != null) {
            categoriaEntity.setNome(categoriaDto.nome);
            categoriaRepository.persist(categoriaEntity);
        }
    }

    @Transactional
    public void excluirCategoria(Long id) {
        CategoriaEntity categoriaEntity = categoriaRepository.findById(id);
        if (categoriaEntity != null) {
            categoriaRepository.delete(categoriaEntity);
        }
    }
}

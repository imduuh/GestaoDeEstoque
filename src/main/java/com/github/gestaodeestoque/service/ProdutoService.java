package com.github.gestaodeestoque.service;

import com.github.gestaodeestoque.dbmanager.ProdutoEntity;
import com.github.gestaodeestoque.dbmanager.ProdutoRepository;
import com.github.gestaodeestoque.model.dto.ProdutoDto;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class ProdutoService {

    @Inject
    ProdutoRepository produtoRepository;

    @Transactional
    public void adicionarProduto(ProdutoDto produtoDTO) {
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setNome(produtoDTO.nome);
        produtoEntity.setPreco(produtoDTO.preco);
        produtoEntity.setQuantidade(produtoDTO.quantidade);
        produtoRepository.persist(produtoEntity);
    }

    public List<ProdutoDto> listarTodosProdutos() {
        List<ProdutoEntity> produtosEntity = produtoRepository.listAll();
        List<ProdutoDto> produtosDto = new ArrayList<>();
        for (ProdutoEntity produto : produtosEntity) {
            produtosDto.add(new ProdutoDto(produto.getId(), produto.getNome(), produto.getQuantidade(), produto.getPreco()));
        }
        return produtosDto;
    }

    public ProdutoDto buscarProdutoPorId(Long id) {
        ProdutoEntity produtoEntity = produtoRepository.findById(id);
        if (produtoEntity != null) {
            return new ProdutoDto(produtoEntity.getId(), produtoEntity.getNome(), produtoEntity.getQuantidade(), produtoEntity.getPreco());
        }
        return null;
    }

    @Transactional
    public void atualizarProduto(Long id, ProdutoDto produtoDto) {
        ProdutoEntity produtoEntity = produtoRepository.findById(id);
        if (produtoEntity != null) {
            produtoEntity.setNome(produtoDto.nome);
            produtoEntity.setQuantidade(produtoDto.quantidade);
            produtoEntity.setPreco(produtoDto.preco);
            produtoRepository.persist(produtoEntity);
        }
    }

    @Transactional
    public void excluirProduto(Long id) {
        ProdutoEntity produtoEntity = produtoRepository.findById(id);
        if (produtoEntity != null) {
            produtoRepository.delete(produtoEntity);
        }
    }
}

package com.github.gestaodeestoque.model.dto;

public class ProdutoDto {
    public Long id;
    public String nome;
    public int quantidade;
    public double preco;
    public Long categoriaId;

    public ProdutoDto(Long id, String nome, int quantidade, double preco) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }
}

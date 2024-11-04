package com.github.gestaodeestoque.controller;

import com.github.gestaodeestoque.model.dto.ProdutoDto;
import com.github.gestaodeestoque.service.ProdutoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/produtos")
public class ProdutoController {

    @Inject
    ProdutoService produtoService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarProduto(ProdutoDto produto) {
        produtoService.adicionarProduto(produto);
        return Response.status(Response.Status.CREATED)
                .entity("{\"resposta\": \"Produto criado com sucesso!\"}")
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProdutoDto> listarProdutos() {
        return produtoService.listarTodosProdutos();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProdutoDto buscarProdutoPorId(@PathParam("id") Long id) {
        return produtoService.buscarProdutoPorId(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarProduto(@PathParam("id") Long id, ProdutoDto produtoDto) {
        produtoService.atualizarProduto(id, produtoDto);
        return Response.ok("{\"resposta\": \"Produto atualizado com sucesso!\"}").build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response excluirProduto(@PathParam("id") Long id) {
        produtoService.excluirProduto(id);
        return Response.ok("{\"resposta\": \"Produto excluído com sucesso!\"}").build();
    }
}

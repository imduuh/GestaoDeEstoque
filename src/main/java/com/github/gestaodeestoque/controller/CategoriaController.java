package com.github.gestaodeestoque.controller;

import com.github.gestaodeestoque.model.dto.CategoriaDto;
import com.github.gestaodeestoque.service.CategoriaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/categorias")
public class CategoriaController {

    @Inject
    CategoriaService categoriaService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarCategoria(CategoriaDto categoriaDto) {
        categoriaService.adicionarCategoria(categoriaDto);
        return Response.status(Response.Status.CREATED)
                .entity("{\"resposta\": \"Categoria criada com sucesso!\"}")
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoriaDto> listarCategorias() {
        return categoriaService.listarTodasCategorias();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CategoriaDto buscarCategoriaPorId(@PathParam("id") Long id) {
        return categoriaService.buscarCategoriaPorId(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarCategoria(@PathParam("id") Long id, CategoriaDto categoriaDto) {
        categoriaService.atualizarCategoria(id, categoriaDto);
        return Response.ok("{\"resposta\": \"Categoria atualizada com sucesso!\"}").build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response excluirCategoria(@PathParam("id") Long id) {
        categoriaService.excluirCategoria(id);
        return Response.ok("{\"resposta\": \"Categoria excluída com sucesso!\"}").build();
    }
}

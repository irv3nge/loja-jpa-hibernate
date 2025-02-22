package br.com.pedro.loja.dao;

import br.com.pedro.loja.modelo.Categoria;
import br.com.pedro.loja.modelo.Produto;

import javax.persistence.EntityManager;

public class CategoriaDao {

    private EntityManager em ;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public void Cadastrar(Categoria categoria){
        this.em.persist(categoria);
    }


    public void atualizar(Categoria categoria){
       this.em.merge(categoria);
    }

    public void remover(Categoria categoria){
        categoria = em.merge(categoria);
        this.em.remove(categoria);
    }



}

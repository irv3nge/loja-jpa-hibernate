package br.com.pedro.loja.testes;

import br.com.pedro.loja.dao.CategoriaDao;
import br.com.pedro.loja.dao.ProdutoDao;
import br.com.pedro.loja.modelo.Categoria;
import br.com.pedro.loja.modelo.Produto;
import br.com.pedro.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {
    public static void main(String[] args) {
        cadastrarProduto();
        Long id = 1l;
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto p = produtoDao.buscarPorId(1l);
        System.out.println(p.getPreco());

        List<Produto> todos =  produtoDao.buscarPorNomedaCategoria("CELULARES");
        todos.forEach(p2 -> System.out.println(p.getNome()));


        BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("Xiaomi");
        System.out.println("Precooo " + precoDoProduto);


    }

    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi" , "Very Cool", new BigDecimal(5000),celulares);


        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        categoriaDao.Cadastrar(celulares);
        produtoDao.Cadastrar(celular);

        em.getTransaction().commit();
        em.close();
    }
}

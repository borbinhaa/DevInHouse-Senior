package dao;

import lombok.AllArgsConstructor;
import models.Produto;

import javax.persistence.EntityManager;
import java.util.List;


@AllArgsConstructor
public class ProdutoDAO {

    private EntityManager entityManager;

    public void cadastra(Produto produto) {
        entityManager.persist(produto);
    }

    public void atualizar(Produto produto) {
        this.entityManager.merge(produto);
    }

    public void excluir(Produto produto) {
        produto = this.entityManager.merge(produto);
        this.entityManager.remove(produto);
    }

    public List<Produto> burscarTodos() {
        String jpql = "SELECT p FROM Produto p";
        return entityManager.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> burscarTodosPorNome(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
        return entityManager.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }
}

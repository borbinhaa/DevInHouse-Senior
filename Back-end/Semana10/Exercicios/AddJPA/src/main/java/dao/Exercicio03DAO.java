package dao;

import models.Nome;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;

@AllArgsConstructor
public class Exercicio03DAO {
    private EntityManager entityManager;

    public void cadastra(Nome nome) {
        entityManager.persist(nome);
    }

}

package dao;

import lombok.AllArgsConstructor;
import models.Categoria;

import javax.persistence.EntityManager;

@AllArgsConstructor
public class CategoriaDAO {
    private EntityManager entityManager;

    public void cadastra(Categoria categoria) {
        entityManager.persist(categoria);
    }

}

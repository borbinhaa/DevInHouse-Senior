package teste;

import dao.Exercicio03DAO;
import models.Nome;
import utils.JPAUtil;

import javax.persistence.EntityManager;

public class Teste {

    public static void main(String[] args) {

        EntityManager entityManager = JPAUtil.getEntityManager();
        Exercicio03DAO dao = new Exercicio03DAO(entityManager);
        Nome nome1 = new Nome("Fagundes");
        Nome nome2 = new Nome();
        nome2.setNome("Magnus");

        entityManager.getTransaction().begin();

        dao.cadastra(nome1);
        dao.cadastra(nome2);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

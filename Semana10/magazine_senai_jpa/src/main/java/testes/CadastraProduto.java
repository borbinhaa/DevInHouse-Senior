package testes;

import dao.CategoriaDAO;
import dao.ProdutoDAO;
import models.Categoria;
import models.Produto;
import models.StatusProduto;
import utils.JPAUtil;

import javax.persistence.EntityManager;

public class CadastraProduto {
    public static void main(String[] args) {
        Produto produto = new Produto();
        produto.setNome("Livro X2");
        produto.setDescricao("Livro sobre X2");
        produto.setPreco(150);
        produto.setQtdEstoque(10);
        produto.setStatus(StatusProduto.PRATELEIRA);

        /*// nome dado no persistence-unit do arquivo persstence.xml
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("magazine_senai_jpa");

        EntityManager em2 = factory.createEntityManager(); // nesse momento criamos a conexao com o banco de dados*/

        Categoria categoria = new Categoria("LIVRO");

        EntityManager em = JPAUtil.getEntityManager();

        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);
        produto.setCategoria(categoria);

//        System.out.println(produtoDAO.burscarTodos());
//        System.out.println(produtoDAO.burscarTodosPorNome("Livro X"));

        em.getTransaction().begin();

/*        // atualizando produto
        Produto produto2 = em.find(Produto.class, 2L); // pegando um objeto do banco de dados
        produto2.setNome("Livro SQL atualizado");*/

        /*// removendo produto
        Produto produto2 = em.find(Produto.class, 17L);
        em.remove(produto2);
*/
/*        categoriaDAO.cadastra(categoria);
        categoria.setNome("APOSTILA");
        em.flush();

        produto.setCategoria(categoria);
        produtoDAO.cadastra(produto);
        em.clear(); // manda pra detached

        produto.setPreco(10); // como produto está em detached não adianta nada
        produtoDAO.atualizar(produto); // volta o produto pra managed*/

        // desse jeito funciona também
        /*produto = produtoDAO.atualizar(produto);
        produto.setPreco(10);
        */


        em.flush();
        em.getTransaction().commit();
        em.close();
    }
}

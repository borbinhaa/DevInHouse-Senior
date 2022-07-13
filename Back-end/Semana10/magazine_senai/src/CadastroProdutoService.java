public class CadastroProdutoService {

    private ProdutoDAO dao;

    public CadastroProdutoService(ProdutoDAO dao) {
        this.dao = dao;
    }

    public void cadastraProduto(Produto produto) {
        this.dao.cadastrar(produto);
    }
}

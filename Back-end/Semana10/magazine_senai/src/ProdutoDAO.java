import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

    public void cadastrar(Produto produto) {
        try {
            String sql = "INSERT INTO produtos(nome, descricao, preco) VALUES (?,?,?);";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getDescricao());
            ps.setDouble(3, produto.getPreco());

            ps.execute();
            ps.close();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar produto", e);
        }

    }
}

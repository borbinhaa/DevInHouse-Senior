import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MagazineSenaiRepository {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.getConexao();

        Statement statement = con.createStatement();
        /*boolean execute = statement.execute("INSERT INTO produtos(nome, descricao, preco, qtd_estoque) " +
                "VALUES ('Curso Java', 'Curso Introdutorio de Java', 1000, 50), ('Curso Java2', 'Curso Introdutorio de Java2', 1002, 52);",
                Statement.RETURN_GENERATED_KEYS);*/

        /*boolean execute = statement.execute("DELETE FROM produtos WHERE id BETWEEN 7 and 10;",
                Statement.RETURN_GENERATED_KEYS);*/

        boolean execute = statement.execute("UPDATE produtos SET nome='z' WHERE id=6;",
                Statement.RETURN_GENERATED_KEYS);

        ResultSet result = statement.getGeneratedKeys();
        long linhasModificadas = statement.getUpdateCount();
        System.out.println(linhasModificadas);

        while (result.next()) {
            int id = result.getInt(1);
            String nome = result.getString(2);
            String descricao = result.getString(3);
            int preco = result.getInt(4);
            int qtd_estoque = result.getInt(5);

            System.out.println(id + " | " + nome + " | " + descricao + " | Preco: " + preco + " | Qtd: " + qtd_estoque);
        }
    }
}

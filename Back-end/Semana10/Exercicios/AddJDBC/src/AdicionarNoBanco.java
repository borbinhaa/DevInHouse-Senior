import java.sql.*;

public class AdicionarNoBanco {
    private String url = "jdbc:postgresql://localhost:5432/teste_exercicio" ;
    private String user = "postgres" ;
    private String password = "root";

    public void adiciona(String nome) throws SQLException {
        Connection connection = DriverManager.getConnection(this.url, this.user, this.password);

        Statement statement = connection.createStatement();

        statement.execute("INSERT INTO exercicio2(nome) VALUES ('" + nome + "');", Statement.RETURN_GENERATED_KEYS);

        ResultSet result = statement.getGeneratedKeys();

        while (result.next()) {
            String resultNome = result.getString("nome");
            System.out.println(resultNome + " adicionado.");
        }
    }

    public static void main(String[] args) throws SQLException{
        AdicionarNoBanco add = new AdicionarNoBanco();

        add.adiciona("Anthony");
    }
}

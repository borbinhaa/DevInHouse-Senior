import java.sql.*;

public class TestaConexao {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/magazine_senai";
        String url2  = "jdbc:postgresql:magazine_senai";
        String user = "postgres";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, user, password)){
            Statement statement = connection.createStatement();
            statement.execute("SELECT id, nome, descricao FROM produtos");
            ResultSet result = statement.getResultSet();

            while (result.next()) {
                long id = result.getInt("ID");
                String nome = result.getString("nome");
                String descricao = result.getString("descricao");
                System.out.println(id + " | " + nome + " | " + descricao);
                System.out.println("-------------------------------------");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}

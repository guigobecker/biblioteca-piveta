import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao {
    public static void main (String[] args) {
        Connection c = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/biblioteca";
            String user = "root";
            String password = "0102";

            c = DriverManager.getConnection(url, user, password);

            System.out.println("Conectado ao banco de dados");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado");
        } finally {
            try {
                if(c != null)
                    c.close();
            } catch (SQLException e) {
                System.out.println("Erro ao encerrar a conexão com o banco de dados: " + e.getMessage());
            }
        }
    }
}

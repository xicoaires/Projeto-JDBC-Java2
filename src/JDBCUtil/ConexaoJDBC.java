package JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJDBC {
	public static Connection getConexao() throws SQLException, ClassNotFoundException {
		Connection conexao = null;
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "PROJETOJAVA2";
		String password = "12345";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexao = DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace(); //mostrar o erro que deu na conexão	
		}
		
		return conexao;
	}
	
}

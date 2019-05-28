package jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionFactory;

public class TestaConexao {
	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conexão aberta, you know nothing!");
		connection.close();
	}
}

package jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import jdbc.ConnectionFactory;
import jdbc.modelo.Contato;

public class ContatoDao {
	
	private Connection connection;
	
	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) {
		String sql = "insert into contatos " + "(nome, email, endereco, dataNascimento)" + "values(?,?,?,?)";
	
	try {
			//prepared statment para insercao
		PreparedStatement stmt = connection.prepareStatement(sql);
			//seta os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(
				contato.getDataNascimento().getTimeInMillis()));
			//executa
			stmt.execute();
			stmt.close();
	} catch(SQLException e) {
		throw new RuntimeException(e);
		}
			}
	
	public List<Contato> getList(){
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				//cria objeto contato
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				//montar data com calendar
		
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				//adiciona o objeto a lista
				contatos.add(contato);
			}
			
			rs.close();
			stmt.close();
			return contatos;
			
		}// fecha try
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}// fecha list
}//fecha maind

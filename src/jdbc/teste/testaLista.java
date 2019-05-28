package jdbc.teste;

import java.util.List;

import jdbc.dao.ContatoDao;
import jdbc.modelo.Contato;

public class testaLista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.getList();
		for (Contato contato : contatos) {
			System.out.println("Nome: "+ contato.getNome());
			System.out.println(" Email: "+ contato.getEmail());
			System.out.println(" Endereco: "+ contato.getEndereco());
			 System.out.println("Data de Nascimento: " + contato.getDataNascimento().getTime() + "\n");
		}
	}

}

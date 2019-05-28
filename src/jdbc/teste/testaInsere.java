package jdbc.teste;

import java.util.Calendar;

import jdbc.dao.ContatoDao;
import jdbc.modelo.Contato;

public class testaInsere {

	public static void main(String[] args) {
		//pronto para gravar
		// TODO Auto-generated method stub
		Contato contato = new Contato();
		contato.setNome("estudo1");
		contato.setEmail("guilherme@hotmail.com");
		contato.setEndereco("R Bahia 313");
		contato.setDataNascimento(Calendar.getInstance());
		
	//grave nessa conexao!
		ContatoDao dao = new ContatoDao();
	// metodo elegante
		dao.adiciona(contato);
		System.out.println("gravado");
	}

}

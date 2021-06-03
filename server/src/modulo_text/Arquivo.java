package modulo_text;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Arquivo {
	
	
	public static void main(String[] args) throws IOException  {
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("Alex egidio");
		pessoa1.setEmail("email@gmail.com");
		pessoa1.setIdade(33);
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setNome("Marcus Vinicius");
		pessoa2.setEmail("vinicius@gmail.com");
		pessoa2.setIdade(21);
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setNome("Maria ana");
		pessoa3.setEmail("Marna@gmail.com");
		pessoa3.setIdade(23);
		
		/*Pode vir do banco de dados ou qualquer fonte de dados */
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
		File arquivo = new File("C:\\eclipse-workspace\\server\\src\\modulo_text\\arquivo.csv");

		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);
		
		
		for (Pessoa p : pessoas) {
			escrever_no_arquivo.write(p.getNome() + ";" + p.getEmail() + ";" + p.getIdade() + "\n");
		}
		
		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();
}
}
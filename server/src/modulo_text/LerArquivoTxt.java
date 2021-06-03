package modulo_text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivoTxt {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		FileInputStream entradaArquivo =
				new FileInputStream(new File("C:\\eclipse-workspace\\server\\src\\modulo_text\\arquivo.csv"));
		
		Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while(lerArquivo.hasNext()) {
			String linha = lerArquivo.nextLine();
			
			if(linha != null && !linha.isEmpty()) { //Faz com que não leia a linha em branco
				String[] dados = linha.split("\\;");
				Pessoa pessoa = new Pessoa();				
				pessoa.setNome(dados[0]);
				pessoa.setEmail(dados[1]);
				pessoa.setIdade(Integer.parseInt(dados[2]));
				
				pessoas.add(pessoa);
			}
		}
	
		for (Pessoa pessoa : pessoas) { // Poderia gravar no banco dedados, enviar no email e etc.
			System.out.println(pessoas);
		}
	}
}

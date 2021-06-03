package modulo_text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\eclipse-workspace\\server\\src\\modulo_text\\arquivo.xls");
		
		if (!file.exists()) {
			file.createNewFile();
		}
		
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
		
		HSSFWorkbook hssfworkbook = new HSSFWorkbook(); /*Vai ser usado para criar a planilha */
		HSSFSheet linhaPessoa = hssfworkbook.createSheet("Planilha de pessoa Jdev Treinamento"); /*Criar planilha */
		
		int numeroLinha = 0;
		for (Pessoa p : pessoas) {
			Row linha = linhaPessoa.createRow(numeroLinha ++); /* Criando a linha em planilha */
			
			int celula = 0;
			
			Cell celNome = linha.createCell(celula ++); /* Célula1 */
			celNome.setCellValue(p.getNome());
			
			Cell celIdade = linha.createCell(celula ++); /* Célula2 */
			celIdade.setCellValue(p.getIdade());
			
			Cell celEmail = linha.createCell(celula ++); /* Célula3 */
			celEmail.setCellValue(p.getEmail());
			
		}/*Termino de montar a planilha */
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfworkbook.write(saida);/*Escreve a planilha em arquivo */
		saida.flush();
		saida.close();
		
		System.out.println("A planilha foi criada");
	}

}

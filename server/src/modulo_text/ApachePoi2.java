package modulo_text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi2 {

	public static void main(String[] args) throws IOException {

		FileInputStream entrada = new FileInputStream(
		new File("C:\\eclipse-workspace\\server\\src\\modulo_text\\arquivo.xls"));

		HSSFWorkbook hssfworkbook = new HSSFWorkbook(entrada); /* Prepara a entrada do arquivo excel para ler */
		HSSFSheet planilha = hssfworkbook.getSheetAt(0); /* Pega a primeira planilha do excel */

		Iterator<Row> linhaIterator = planilha.iterator();

		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		while (linhaIterator.hasNext()) { /* Enquanto tiver linha no arquivo do excel */

			Row linha = linhaIterator.next(); /* Dados da pessoa na linha */

			Iterator<Cell> celulas = linha.iterator();

			Pessoa pessoa = new Pessoa();

			while (celulas.hasNext())/* Percorrer as celulas */ {

				Cell cell = celulas.next();

				switch (cell.getColumnIndex()) {
				case 0: 
					pessoa.setNome(cell.getStringCellValue());
					break;
				case 1:
					pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
					break;
				case 2:	
					pessoa.setEmail(cell.getStringCellValue());
					break;
				}

			}/*Fim das células da linha */
			
			pessoas.add(pessoa);
			
		}
		entrada.close(); /* Terminou de ler o arquivo excel */
		 
		 for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		 }
	}
	
	}



package modulo_text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiEditando {

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\eclipse-workspace\\server\\src\\modulo_text\\arquivo.xls");
		
		FileInputStream entrada = new FileInputStream(file);
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);/* Prapara a entrada do arquivo xls excel */
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0); /* Pegando a planilha */
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		while(linhaIterator.hasNext()) { /* Enquanto tiver linha*/
			Row linha = linhaIterator.next(); /* Dados da pessoa na linha */
			
			int numeroCedulas = linha.getPhysicalNumberOfCells(); /* Quantidade de cedulas */
			Cell cell = linha.createCell(numeroCedulas);/*Cria nova cédula na linha */
			cell.setCellValue("5.497,20");
			
		}
		
		entrada.close();
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida);
		saida.flush();
		saida.close();
		
		System.out.println("Planilha atualizada");
	}
	
}

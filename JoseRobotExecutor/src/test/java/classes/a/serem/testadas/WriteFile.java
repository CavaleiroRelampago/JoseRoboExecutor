package classes.a.serem.testadas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings("unused")
public class WriteFile {

	private String fileName;
	private String plan;

	public WriteFile(String fileName , String plan ){
		this.fileName  = fileName;
		this.plan=plan;
	}

	public void write() {
		XSSFCell celula = null;
		XSSFRow linha = null;
		try {
			FileInputStream arquivo = new FileInputStream(this.fileName);
			
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
			XSSFSheet sheetabas = workbook.getSheet(this.plan);	
			
			for (int i=0 ; i<10 ; i++){
				linha = sheetabas.getRow(i);
				if(linha == null){
					linha = sheetabas.createRow(i);
					System.out.println("criou linha : "  +(i+1));
				}
				for (int j=0 ; j<10 ; j++){
					celula = linha.getCell(j);
					if(celula == null){
						celula = linha.createCell(j);
						System.out.println("criou celula : " +(j+1));
					}
					celula.setCellValue(new XSSFRichTextString("teste").toString());
				}
			}
			
			FileOutputStream GravaDados = new FileOutputStream(this.fileName);
			workbook.write(GravaDados);
			GravaDados.close();
			
			workbook.close();
			arquivo.close();
		
			System.out.println("Arquivo escrito!");
		
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}

		}
	}
	



package classes.a.serem.testadas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings("unused")
public class ReadFile {

	private String fileName;
	private String plan;
	private List <Regra> regraList = new ArrayList<Regra> ();

	public ReadFile(String fileName , String plan ){
		this.fileName  = fileName;
		this.plan=plan;
	}

	public void read() {


		try{

			FileInputStream arquivo = new FileInputStream(fileName);

			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
			XSSFSheet sheetabas = workbook.getSheet(plan);

			Iterator<Row> rowIterator = sheetabas.iterator();
			while (rowIterator.hasNext()) {
				Regra regra = new Regra();
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					switch (cell.getColumnIndex()) {
					case 1 :
						regra.setDescricao(cell.getStringCellValue());
						break;
					case 2 :
						regra.setIniciofim(cell.getStringCellValue());
						break;
					case 3 :
						regra.setFormato(cell.getStringCellValue());
						break;
					case 4 :
						regra.setObrigatorio(cell.getStringCellValue());
						break;
					case 5 :
						regra.setBloco(cell.getStringCellValue());
						break;
					case 6 :

						break;
					case 7 :

						break;
					case 8 :

						break;
					case 9 :

						break;

					}
				}

				regraList.add(regra);
			}

		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	private void print(Cell cell) {
		System.out.println("" +cell.getStringCellValue());
	}

	private String getFileName() {
		return fileName;
	}

	private void setFileName(String fileName) {
		this.fileName = fileName;
	}

	private String getPlan() {
		return plan;
	}

	private void setPlan(String plan) {
		this.plan = plan;
	}

	public List<Regra> getRegraList() {
		return regraList;
	}

	public void setRegraList(List<Regra> regraList) {
		this.regraList = regraList;
	}

}

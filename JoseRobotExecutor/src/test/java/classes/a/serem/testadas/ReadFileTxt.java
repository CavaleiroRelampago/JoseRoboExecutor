package classes.a.serem.testadas;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;



public class ReadFileTxt {

	private List<Txt> linhaList = new ArrayList<Txt>(); 
	private String arquivo;
	private boolean op=false;

	public ReadFileTxt (String arquivo){
		this.arquivo = arquivo;
	}

	public void readTxt() {

		try {

			FileReader arq = new FileReader(arquivo);
			@SuppressWarnings("resource")
			BufferedReader lerArq = new BufferedReader(arq);

			do{
				Txt linha = new Txt();
				linha.setLinha(lerArq.readLine());

				if (linha.getLinha() != null){
					linhaList.add(linha);
					op = true;	
				}else{
					op = false;
				}

			}while(op);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public List<Txt> getLinhaList() {
		return linhaList;
	}

	public void setLinhaList(List<Txt> linhaList) {
		this.linhaList = linhaList;
	}
}





package classes.a.serem.testadas;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @autor: José R. vieira*/

/** esta classe serve para testes de codigos */

public class WorkingOfiice {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String [] args){

//		boolean continuar = false;
//		
//		do{
//		
//		TesteRenameFiles();
//
//		String NextorExit = null;
//								
//		System.out.print("Next teste ?");
//		
//		try {
//		
//			NextorExit = in.readLine();
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
//		
//		
//		
//		if(NextorExit.contains("Next")){
//			continuar = true;
//		}else{
//			continuar = false;
//		}
//		
//		}while(continuar);
//		
//		System.exit(0);
		
	}


	/*Original code 
	 * agora que entendo como o codigo original funiciona irei realizar algumas melhorias
	 * 
	 * public static void TesteRenameFiles(){

		//	Código foi tirado da rede ele serve para manipulação de ficheiros e para pastas. 

		//trabalhando com o buffer abrindo uma nova leitura de buffer
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		//print de iteração /*"Digite o arquivo ou o diretório nome que deve ser renomeado:"*//*
		System.out.print("Please enter the file or directory name which has to be Renamed : ");

		//declaração de uma string para antigo nome                   
		String old_name = null;
		
		
		//tratamento de erro
		try {
			//salva o antigo nome em uma string  
			old_name = in.readLine();
		} catch (IOException e) {
			// print do erro
			e.printStackTrace();
		} 

		
		//abre um file e o salva em um old file  
		//File Name = new File("pathname");
		File oldfile = new File(old_name);

		//este condicional verifica se o arquivo existe ou não 
		if(!oldfile.exists()){

			//caso não exista ele avisa o usuario
			System.out.println("File or directory does not exist.");

			//da um system exite para fechar o buffer   
			System.exit(0);
		}

		//aqui outro sysout de iteração "digite o novo nome do arquivo ou diretório:"
		System.out.print("please enter the new file or directory name : ");

		//declaração de uma string para novo nome
		String new_name = null;
		
		//tratamento de erro 
		try {
			//salva o novo nome em uma string de leitura
			new_name = in.readLine();
		} catch (IOException e) {
			// print do erro 
			e.printStackTrace();
		}

		//abre um novo file
		File newfile = new File(new_name);

		//printa o antigo nome
		System.out.println("Old File or directory name : "+ oldfile);

		// printa o novo nome 
		System.out.println("New File or directory name : "+ newfile);

		//trecho de cogido para a renomeação seu retoorno e um boolean 
		boolean Rename = oldfile.renameTo(newfile);

		//esta condicional diz sobre o sucesso ou a derrota
		if(!Rename){

			//sysout de iteração para notificar o usuario da falha
			System.out.println("File or directory does not rename successfully.");
			System.exit(0);

		} else {

			//sysout para sucesso
			System.out.println("File or directory rename is successfully.");
			System.exit(0);
		}
	}*/

	public static void TesteRenameFiles(){
		
		System.out.print("Entre com o diretorio raiz do arquivo ou pasta que deseja renomear");
		
		//guarda o endereço do diretorio
		String DirectoryAdress = null;
		
		//captura exeção do tipo io
		try {
			DirectoryAdress = in.readLine();
		} catch (IOException e) {

			e.printStackTrace();
		} 

		System.out.print("Qual arquivo deste diretorio deseja renomear ? ");
		
		//guarda o nome do arquivo ou pasta que se deseja alterar dentro do diretorio
		/*OBS: para arquivos se deve colocar .extensão do arquivo apos o nome*/
		String ArchiveName = null;
		
		//captura exeçoes do tipo io
		try {	
			ArchiveName = in.readLine();
		} catch (IOException e) {

			e.printStackTrace();
		} 
		
		//instancia um novo file para o antigo arquivo
		File OldNameArchive = new File(DirectoryAdress + "\\" + ArchiveName);
 
		//trata a existencia ou nao do arquivo no diretorio
		if(!OldNameArchive.exists()){
			System.out.println("Arquivo ou diretorio não encontrado");
			return;
		}

		System.out.print("entre com o novo nome para o arquivo ou diretorio");

		//novo nome para o arquivo ou diretorio 
		/*OBS: aqui voce nao precisa preencher com a extensão apos o nome */
		String NewName = null;

		try {
			
			NewName = in.readLine();
		
		} catch (IOException e) {
			
			e.printStackTrace();
		
		}

		//instancia um novo file para o arquivo novo
		File NewNameArchive = new File(DirectoryAdress + "\\" + NewName);

		System.out.println("nome antigo do arquivo ou pasta : "+ ArchiveName);

		System.out.println("Nova nome do arquivo : "+ NewName);

		//trecho de cogido para a renomeação seu retoorno e um boolean 
		boolean Rename = OldNameArchive.renameTo(NewNameArchive);

		//esta condicional diz sobre o sucesso ou a derrota
		if(!Rename){

			System.out.println("Arquivo ou diretorio não foi renomeado com sucesso");
		
			return;

		} else {
			
			System.out.println("arquivo ou diretorio renomado com sucesso");
			return; 
		}
	}
}

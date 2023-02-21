package com.desafio.vendas.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ToolFiles {
	
	public static List<String> readTxt(MultipartFile file) throws Exception {

		File fileTmp = getFileTmp(file, "txt");

		List<String> linhas = new ArrayList<String>();
		if (fileTmp != null) {
			try (BufferedReader br = new BufferedReader(new FileReader(fileTmp.getAbsolutePath()))) {
				String lineTxt = br.readLine();
				Integer nLinha = 0;
				boolean firstline = true;
				while (lineTxt != null) {
					if (firstline) {
						firstline = false;
					}else {
						nLinha++;
						linhas.add(lineTxt);
					}
					lineTxt = br.readLine();
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			fileTmp.delete();
		}
		if (linhas.isEmpty()) {
			throw new Exception("Arquivo em branco!");
		}
		return linhas;
	}
	
	public static File getFileTmp(MultipartFile file, String extensao) throws Exception {
		File fileTmp = null;
		extensao = extensao.replace(".", "");
		try {
			fileTmp = new File("tmp." + extensao);
			FileOutputStream in = new FileOutputStream(fileTmp);
			byte[] bFile = file.getBytes();
			in.write(bFile);
			in.close();
		} catch (IOException e1) {
			throw new Exception("Erro em Leitura/Gravação do arquivo.");
		}
		return fileTmp;
	}

}





/*public class LerArquivo {
	public static String Read(String Caminho) throws ParseException {
		
		String dados = "";
		try {
			FileReader arq = new FileReader(Caminho);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = "";
			try {
				linha = lerArq.readLine();
				while (linha != null) {
					String[] field = linha.split(" ");
					String descricao = field[0];
					double preco = Double.parseDouble(field[1]);
					Integer qtd = Integer.parseInt(field[2]);
					String cliente_nome = field[3];
					String cliente_cpf_cnpj = field[4];
					String cliente_endereco = field[5];
					
					dados += linha;
					linha = lerArq.readLine();
					return dados;
				}
				
				
			} catch (IOException ex){
				dados = "Erro: Não foi possível ler o arquivo.";
			}
		} catch (FileNotFoundException ex) {
			dados = "Erro: Arquivo não encontrado.";
		}
		if(dados.contains("Erro"))
			return "";
		else {
			return dados;
		}
		
		
	}

}*/

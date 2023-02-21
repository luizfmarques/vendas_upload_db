package com.desafio.vendas.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.desafio.vendas.entities.Venda;
import com.desafio.vendas.repositories.VendaRepository;
import com.desafio.vendas.tools.ToolFiles;

@Service
public class VendaService {

	@Autowired
	private VendaRepository repository;

	private List<Venda> toVenda(MultipartFile file) throws Exception {

		List<Venda> vendas = new ArrayList<>();
		List<String> lines = ToolFiles.readTxt(file);
		for (String line : lines) {
			String lineTemp = line.replaceAll("   ", "  ");
			int x = lineTemp.indexOf("   ");
			while (x > 0) {
				lineTemp = lineTemp.replaceAll("   ", "  ");
				x = lineTemp.indexOf("   ");
			}
			String[] field = lineTemp.split("  ");

			String descricao = field[0];

			double preco = 0d;
			try {
				preco = Double.parseDouble(field[1]);
			} catch (Exception e) {
				throw new Exception("Erro ao ler dado da coluna Valor");
			}

			Integer qtd = 0;
			try {
				qtd = Integer.parseInt(field[2]);
			} catch (Exception e) {
				throw new Exception("Erro ao ler dado da coluna Quantidade");
			}

			String clienteNome = field[3];
			String clienteCpfCnpj = field[4];
			String clienteEndereco = field[5];
			Venda v = new Venda(descricao, preco, qtd, clienteNome, clienteCpfCnpj, clienteEndereco);
			vendas.add(v);
		}
		return vendas;

	}

	public double processo(MultipartFile file) throws Exception {
		List<Venda> vendas = toVenda(file);
		repository.saveAll(vendas);
		double valorCalculado = vendas.stream().mapToDouble(m -> m.getPreco() * m.getQtd()).sum();
		return valorCalculado;
	}

}

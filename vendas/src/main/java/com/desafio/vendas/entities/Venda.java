package com.desafio.vendas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Venda {
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private Double preco;
	private Integer qtd;
	private String clienteNome;
	private String clienteCpfCnpj;
	private String clienteEndereco;

	public Venda(String descricao, Double preco, Integer qtd, String clienteNome, String clienteCpfCnpj,
			String clienteEndereco) {
		this.descricao = descricao;
		this.preco = preco;
		this.qtd = qtd;
		this.clienteNome = clienteNome;
		this.clienteCpfCnpj = clienteCpfCnpj;
		this.clienteEndereco = clienteEndereco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public String getClienteNome() {
		return clienteNome;
	}

	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}

	public String getClienteCpfCnpj() {
		return clienteCpfCnpj;
	}

	public void setClienteCpfCnpj(String clienteCpfCnpj) {
		this.clienteCpfCnpj = clienteCpfCnpj;
	}

	public String getClienteEndereco() {
		return clienteEndereco;
	}

	public void setClienteEndereco(String clienteEndereco) {
		this.clienteEndereco = clienteEndereco;
	}

	@Override
	public String toString() {
		return "Vendas [descricao=" + descricao + ", preco=" + preco + ", qtd=" + qtd + ", cliente_nome=" + clienteNome
				+ ", cliente_cpf_cnpj=" + clienteCpfCnpj + ", cliente_endereco=" + clienteEndereco + "]";
	}

}

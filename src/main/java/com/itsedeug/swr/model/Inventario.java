package com.itsedeug.swr.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entidade inventario, complementar a entidade Rebelde.
 * Dados sao informados no registro de um novo rebelde.
 * @author italo
 *
 */
@Entity
public class Inventario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;

	private long qtdArmas;
	private long qtdMunicao;
	private long qtdComida;
	private long qtdAgua;
	
	public Inventario(long qtdArmas, long qtdMunicao, long qtdComida, long qtdAgua) {
		this.setQtdArmas(qtdArmas);
		this.setQtdMunicao(qtdMunicao);
		this.setQtdComida(qtdComida);
		this.setQtdAgua(qtdAgua);
	}

	//metodos de acesso
	public long getQtdArmas() { return qtdArmas; }
	public void setQtdArmas(long qtdArmas) { this.qtdArmas = qtdArmas; }

	public long getQtdMunicao() { return qtdMunicao; }
	public void setQtdMunicao(long qtdMunicao) { this.qtdMunicao = qtdMunicao; }

	public long getQtdComida() { return qtdComida; }
	public void setQtdComida(long qtdComida) { this.qtdComida = qtdComida; }

	public long getQtdAgua() { return qtdAgua; }
	public void setQtdAgua(long qtdAgua) { this.qtdAgua = qtdAgua; }

}

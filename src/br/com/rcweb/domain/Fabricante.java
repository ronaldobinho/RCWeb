package br.com.rcweb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;

@Entity
@Table(name = "tb_fabricante")
@NamedQueries({
	@NamedQuery(name = "Fabricante.listar", query = "select fabricante FROM Fabricante fabricante"),
	@NamedQuery(name = "Fabricante.buscarPorCodigo", query = "SELECT fabricante from Fabricante fabricante where fabricante.codigo = :codigo")
})
	public class Fabricante {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fab_codigo")
	private Long codigo;
	
	@NotEmpty(message = "O campo descrição é obrigatório")
	@Size(min = 5, max = 50, message = "Tamanho inválido para o campo descrição	")
	@Column(name = "fab_descricao", length = 50, nullable = false)
	private String descricao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Fabricante [codigo=" + codigo + ", descricao=" + descricao + "]";
	}

}

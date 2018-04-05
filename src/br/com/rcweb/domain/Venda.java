package br.com.rcweb.domain;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "tb_venda")
@NamedQueries({
	@NamedQuery(name = "Venda.listar", query = "SELECT venda FROM Venda venda"),
	@NamedQuery (name = "Venda.buscarPorCodigo", query = "SELECT venda FROM Venda venda where codigo = :codigo")
})
public class Venda {
	
	@Override
	public String toString() {
		return "Venda [codigo=" + codigo + ", horario=" + horario + ", valor=" + valor + ", funcionario=" + funcionario
				+ "]";
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "ven_codigo")
	private Long codigo;

	//TIMESSTAMP Guarda a DATA E HORAS
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "ven_horario", nullable = false)
	private Date horario;
	
	@Column(name = "ven_valor",precision = 7, scale = 2, nullable = false)
	private BigDecimal valor;
	

	// EAGER Quando eu carregar os produtos os fabricantes vem juntos
	// LAZE apenas lista os produtos e depois os fabricantes
	@ManyToOne(fetch = FetchType.EAGER)
	                        // Nome na tabela filha                                // nome na tabela pai   
	@JoinColumn(name = "ven_tb_funcionarios_func_codigo", referencedColumnName = "fun_codigo", nullable = false)
	private Funcionario funcionario;


	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public Date getHorario() {
		return horario;
	}


	public void setHorario(Date horario) {
		this.horario = horario;
	}


	public BigDecimal getValor() {
		return valor;
	}


	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
} 

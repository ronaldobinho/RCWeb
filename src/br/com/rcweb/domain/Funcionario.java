package br.com.rcweb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "tb_funcionarios")
@NamedQueries({ 
	    @NamedQuery(name = "Funcionario.listar", query = "SELECT funcionario from Funcionario funcionario"),
	    @NamedQuery(name = "Funcionario.buscarPorCodigo", query = "SELECT funcionario from Funcionario funcionario where funcionario.codigo = :codigo")
	    })
public class Funcionario {

	@Id
	@GeneratedValue
	@Column(name = "fun_codigo")
	private Long codigo;
    
	@NotEmpty(message = "Nome é obrigatório")
	@Size(min = 5, max = 50, message = "tamanho inválido para o campo nome")
	@Column(name = "fun_nome", nullable = false, length = 50)
	private String nome;
    
	@CPF(message = "CPF informado é inválido")
	@Column(name = "fun_cpf", nullable = false, length = 14)
	private String cpf;
    

	@NotEmpty(message = "Senha é obrigatório")
	@Size(min = 4, max = 8, message = "tamanho inválido para o campo senha")
	@Column(name = "fun_senha", nullable = false, length = 32)
	private String senha;
    

	@NotEmpty(message = "Função é obrigatório")
	@Column(name = "fun_funcao", nullable = false, length = 50)
	private String funcao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	@Override
	public String toString() {
		return "Funcionario [codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", funcao="
				+ funcao + "]";
	}

}

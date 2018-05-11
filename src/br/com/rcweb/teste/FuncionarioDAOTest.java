package br.com.rcweb.teste;

import org.junit.Ignore;
import org.junit.Test;

import br.com.rcweb.dao.FuncionarioDAO;
import br.com.rcweb.domain.Funcionario;

public class FuncionarioDAOTest {

	@Test
	@Ignore
		public void salvar() {
		Funcionario f1 = new Funcionario();

		f1.setNome("Ronaldo");
		f1.setCpf("459.445.115.09");
		f1.setFuncao("Administrador");
		f1.setSenha("rsilva");

		FuncionarioDAO fdao = new FuncionarioDAO();
		fdao.salvar(f1);
	}

	@Test
	@Ignore
	public void listar() {

		FuncionarioDAO fdao = new FuncionarioDAO();

		List<Funcionario> ListFunc = fdao.Listar();

		for (Funcionario funcionarios : ListFunc) {

			System.out.println(ListFunc);
		}

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		Funcionario f1 = new Funcionario();

		f1.setCodigo(9L);

		FuncionarioDAO fdao = new FuncionarioDAO();

		f1 = fdao.buscarPorCodigo(f1.getCodigo());

		System.out.println(f1);

	}

	@Test
	@Ignore
	public void excluir() {
		Funcionario f1 = new Funcionario();

		FuncionarioDAO fdao = new FuncionarioDAO();

		f1 = fdao.buscarPorCodigo(9L);
		if (f1 != null) {
			fdao.excluir(f1);
		}
	}
	
	@Test
	public void editar(){
		Funcionario f1 = new Funcionario();

		FuncionarioDAO fdao = new FuncionarioDAO();
		
         f1 = fdao.buscarPorCodigo(10L);
         
         f1.setNome("Ronaldo Carvalho");
         f1.setSenha("123xxx456xxx");
         f1.setFuncao("Admin");
	    
		fdao.editar(f1);
		

		
	}
	
	

}

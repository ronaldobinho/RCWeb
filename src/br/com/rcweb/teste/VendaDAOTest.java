package br.com.rcweb.teste;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.rcweb.dao.FuncionarioDAO;
import br.com.rcweb.dao.VendaDAO;
import br.com.rcweb.domain.Funcionario;
import br.com.rcweb.domain.Venda;

public class VendaDAOTest {

	@Test
	public void salvar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscarPorCodigo(10L);

		Venda venda = new Venda();
		venda.setFuncionario(funcionario);
		venda.setHorario(new Date());
		venda.setValor(new BigDecimal(236.24D));

		VendaDAO vendaDAO = new VendaDAO();

		vendaDAO.salvar(venda);
	}

	@Test
	@Ignore
	public void listar() {

		VendaDAO vendaDAO = new VendaDAO();

		List<Venda> vendas = vendaDAO.listar();

		System.out.println(vendas);

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		VendaDAO vendaDAO = new VendaDAO();

		Venda vendas = vendaDAO.buscarPorCodigo(18L);

		System.out.println(vendas);

	}

	@Test
	@Ignore
	public void excluir() {
		VendaDAO vendaDAO = new VendaDAO();

		Venda vendas = vendaDAO.buscarPorCodigo(18L);
		vendaDAO.excluir(vendas);

		System.out.println(vendas);

	}
	
	
	@Test
	@Ignore
	public void editar(){
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscarPorCodigo(2L);
		
	    Venda venda = new Venda();
	    
	    venda.setHorario(Calendar.getInstance().getTime());
		venda.setValor(new BigDecimal(452.22D));
		venda.setFuncionario(funcionario);

		
		VendaDAO vendadao = new VendaDAO();
		vendadao.editar(venda);
	}

}

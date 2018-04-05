package br.com.rcweb.teste;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.rcweb.dao.FabricanteDAO;
import br.com.rcweb.dao.ProdutoDAO;
import br.com.rcweb.domain.Fabricante;
import br.com.rcweb.domain.Produto;

public class ProdutoDAOTest {

	@Test
	@Ignore
	public void inserir() {
		FabricanteDAO fdao = new FabricanteDAO();
		Fabricante fabricante = fdao.buscarPorCodigo(1L);

		Produto produto = new Produto();
		produto.setDescricao("Mostarda");
		produto.setPreco(new BigDecimal(7.55D));
		produto.setQuantidade(25);
		produto.setFabricante(fabricante);

		ProdutoDAO pdao = new ProdutoDAO();
		pdao.salvar(produto);

	}
	
	
	@Test
	@Ignore
	public void buscarPorCordio(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(13L);
		
		
		System.out.println(produto);
		
	}
	
	
	@Test
	@Ignore
	public void listar(){
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> produtos = produtoDAO.Listar();
		
		System.out.println(produtos);
		
	}

	
	@Test
	@Ignore
	public void excluir(){
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		Produto produto = produtoDAO.buscarPorCodigo(13L);
		
		produtoDAO.excluir(produto);
		
	}
	
	
	@Test
	public void editar(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		Produto produto = produtoDAO.buscarPorCodigo(14L);
		
		produto.setDescricao("MaioneSse Best");
		produto.setPreco(new BigDecimal(25.44D));
		produto.setQuantidade(10);
		
		FabricanteDAO dao = new FabricanteDAO();
		
		Fabricante fabricante = dao.buscarPorCodigo(3L);
		
		produto.setFabricante(fabricante);
		
		produtoDAO.editar(produto);
		
		
				
	}
	
}

package br.com.rcweb.teste;

import org.junit.Ignore;
import org.junit.Test;

import br.com.rcweb.dao.ItemDAO;
import br.com.rcweb.dao.ProdutoDAO;
import br.com.rcweb.dao.VendaDAO;
import br.com.rcweb.domain.Item;
import br.com.rcweb.domain.Produto;
import br.com.rcweb.domain.Venda;

public class ItemDAOTest {
	@Test
	@Ignore
	public void salvar() {
		ProdutoDAO proDAO = new ProdutoDAO();
		Produto produto = proDAO.buscarPorCodigo(14L);

		VendaDAO venDAO = new VendaDAO();
		Venda venda = venDAO.buscarPorCodigo(19L);

		Item item = new Item();
		item.setProduto(produto);
		item.setVenda(venda);
		item.setQuantidade(16);
		item.setValor(new BigDecimal(321.65D));

		ItemDAO itemDAO = new ItemDAO();
		itemDAO.salvar(item);

	}

	@Test
	@Ignore
	public void listar() {

		ItemDAO itemDAO = new ItemDAO();

		List<Item> itens = itemDAO.listar();

		System.out.println(itens);

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		ItemDAO itemDAO = new ItemDAO();

		Item itens = itemDAO.buscarPorCodigo(23L);

		System.out.println(itens);

	}

	@Test
	@Ignore
	public void excluir() {
		ItemDAO itemDAO = new ItemDAO();

		Item itens = itemDAO.buscarPorCodigo(23L);
		itemDAO.excluir(itens);

	}

	@Test
	public void editar() {
		ProdutoDAO produtoDao = new ProdutoDAO();
		Produto produto = produtoDao.buscarPorCodigo(2L);

		VendaDAO vendaDao = new VendaDAO();
		Venda venda = vendaDao.buscarPorCodigo(22L);

		Item itens = new Item();
		itens.setProduto(produto);
		itens.setVenda(venda);
		itens.setValor(new BigDecimal(456.56D));
		itens.setQuantidade(10);

		ItemDAO itensDAO = new ItemDAO();

		itensDAO.salvar(itens);
	}
}

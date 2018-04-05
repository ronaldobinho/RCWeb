package br.com.rcweb.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.rcweb.domain.Produto;
import br.com.rcweb.util.HibernateUtil;

public class ProdutoDAO {

	public void salvar(Produto produto) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(produto);
			transacao.commit();

		} catch (RuntimeException e) {
			// TODO: handle exception
			if (transacao != null) {
				transacao.rollback();
			}
			throw e;
		} finally {
			sessao.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Produto> Listar() {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Produto> produtos = null;

		try {
			Query consulta = sessao.getNamedQuery("Produto.listar");
			produtos = consulta.list();

		} catch (RuntimeException e) {
			// TODO: handle exception
			throw e;

		} finally {
			sessao.close();
		}

		return produtos;

	}
	
	
	public Produto buscarPorCodigo(Long codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
        Produto produto = null;

		try {
			Query consulta = sessao.getNamedQuery("Produto.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			
			produto = (Produto) consulta.uniqueResult();
		} catch (RuntimeException e) {
			// TODO: handle exception
			throw e;

		} finally {
			sessao.close();
		}

		return produto;

	}

	
	public void excluir(Produto produto) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(produto);
			transacao.commit();

		} catch (RuntimeException e) {
			// TODO: handle exception
			if (transacao != null) {
				transacao.rollback();
			}
			throw e;
		} finally {
			sessao.close();
		}

	}
	
	public void editar(Produto produto) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(produto);
			transacao.commit();

		} catch (RuntimeException e) {
			// TODO: handle exception
			if (transacao != null) {
				transacao.rollback();
			}
			throw e;
		} finally {
			sessao.close();
		}

	}
}

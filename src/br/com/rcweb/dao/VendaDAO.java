package br.com.rcweb.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.rcweb.domain.Venda;
import br.com.rcweb.util.HibernateUtil;

public class VendaDAO {

	public void salvar(Venda venda) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();

			sessao.save(venda);

			transacao.commit();

		} catch (Exception e) {

			if (transacao != null) {
				transacao.rollback();

			}
			throw e;
			// TODO: handle exception
		} finally {
			sessao.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Venda> listar() {
		// Abre a sess�o
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Venda> vendas = null;

		try {

			Query consulta = sessao.getNamedQuery("Venda.listar");

			vendas = consulta.list();

		} catch (RuntimeException e) {
			// TODO: handle exception
			throw e;
		} finally {

			sessao.close();
		}
		return vendas;

	}

	public Venda buscarPorCodigo(Long codigo) {
		// Abre a sess�o
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Venda venda = null;

		try {

			Query consulta = sessao.getNamedQuery("Venda.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			venda = (Venda) consulta.uniqueResult();

		} catch (RuntimeException e) {
			// TODO: handle exception
			throw e;
		} finally {

			sessao.close();
		}
		return venda;

	}

	public void excluir(Venda venda) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();

			sessao.delete(venda);

			transacao.commit();

		} catch (Exception e) {

			if (transacao != null) {
				transacao.rollback();

			}
			throw e;
			// TODO: handle exception
		} finally {
			sessao.close();
		}

	}

	public void editar(Venda venda) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();

			sessao.update(venda);

			transacao.commit();

		} catch (Exception e) {

			if (transacao != null) {
				transacao.rollback();

			}
			throw e;
			// TODO: handle exception
		} finally {
			sessao.close();
		}

	}

}

package br.com.rcweb.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.rcweb.domain.Item;
import br.com.rcweb.util.HibernateUtil;

public class ItemDAO {
	
	public void salvar(Item item) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();

			sessao.save(item);

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
	public List<Item> listar() {
		// Abre a sessão
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Item> Items = null;

		try {

			Query consulta = sessao.getNamedQuery("item.listar");

			Items = consulta.list();

		} catch (RuntimeException e) {
			// TODO: handle exception
			throw e;
		} finally {

			sessao.close();
		}
		return Items;

	}

	public Item buscarPorCodigo(Long codigo) {
		// Abre a sessão
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Item Item = null;

		try {

			Query consulta = sessao.getNamedQuery("item.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			Item = (Item) consulta.uniqueResult();

		} catch (RuntimeException e) {
			// TODO: handle exception
			throw e;
		} finally {

			sessao.close();
		}
		return Item;

	}

	public void excluir(Item Item) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();

			sessao.delete(Item);

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

	public void editar(Item Item) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();

			sessao.update(Item);

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

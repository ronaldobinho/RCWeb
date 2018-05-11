package br.com.rcweb.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.rcweb.domain.Fabricante;
import br.com.rcweb.util.HibernateUtil;

public class FabricanteDAO {

	public void salvar(Fabricante fabricante) {

		// Cria uma sessão
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			// Inicia uma transao
			transacao = sessao.beginTransaction();

			sessao.save(fabricante);

			// Comita os dados
			transacao.commit();

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			// TODO: handle exception
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Fabricante> Listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		    List<Fabricante> fabricantes = null;
		    		Query consulta = null;
		    		
		try {
	 consulta = sessao.getNamedQuery("Fabricante.listar");
					fabricantes = consulta.list();
		} catch (Exception e) {
			throw e;
		}finally {
			sessao.close();
		}
		
		return fabricantes;
		
		
		
	}
	
	
	
	public Fabricante buscarPorCodigo(Long codigoFab){
		//Cria a sessão
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Fabricante fabricantes = null;
		    		Query consulta = null;
		    		
		try {
	 consulta = sessao.getNamedQuery("Fabricante.buscarPorCodigo");
	 consulta.setLong("codigo", codigoFab);
	 
	 fabricantes = (Fabricante) consulta.uniqueResult();
		} catch (Exception e) {
			throw e;
		}finally {
			sessao.close();
		}
		
		return fabricantes;
		
		
		
	}
	
	public void excluir(Fabricante fabricante) {

		// Cria uma sessão
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			// Inicia uma transao
			transacao = sessao.beginTransaction();

			sessao.delete(fabricante);

			// Comita os dados
			transacao.commit();

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			// TODO: handle exception
		} finally {
			sessao.close();
		}
	}
	
	
	public void editar(Fabricante fabricante) {

		// Cria uma sessão
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			Fabricante FabricanteEditar = buscarPorCodigo(fabricante.getCodigo());
			FabricanteEditar.setDescricao(fabricante.getDescricao());
			// Inicia uma transao
			transacao = sessao.beginTransaction();

			sessao.update(FabricanteEditar);

			// Comita os dados
			transacao.commit();

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			// TODO: handle exception
		} finally {
			sessao.close();
		}
	}

}

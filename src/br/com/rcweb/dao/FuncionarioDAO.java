package br.com.rcweb.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.rcweb.domain.Funcionario;
import br.com.rcweb.util.HibernateUtil;

public class FuncionarioDAO {

	public void salvar(Funcionario funcionario) {

		// Cria uma sessão
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			// Inicia uma transao
			transacao = sessao.beginTransaction();

			sessao.save(funcionario);

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
	public List<Funcionario> Listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		    List<Funcionario> funcionario = null;
		    		Query consulta = null;
		    		
		try {
	 consulta = sessao.getNamedQuery("Funcionario.listar");
					funcionario = consulta.list();
		} catch (Exception e) {
			throw e;
		}finally {
			sessao.close();
		}
		
		return funcionario;
		
		
		
	}
	
	
	
	public Funcionario buscarPorCodigo(Long codigoFab){
		//Cria a sessão
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Funcionario funcionario = null;
		    		Query consulta = null;
		    		
		try {
	 consulta = sessao.getNamedQuery("Funcionario.buscarPorCodigo");
	 consulta.setLong("codigo", codigoFab);
	 
	 funcionario = (Funcionario) consulta.uniqueResult();
		} catch (Exception e) {
			throw e;
		}finally {
			sessao.close();
		}
		
		return funcionario;
		
		
		
	}
	
	public void excluir(Funcionario funcionario) {

		// Cria uma sessão
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			// Inicia uma transao
			transacao = sessao.beginTransaction();

			sessao.delete(funcionario);

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
	
	
	public void editar(Funcionario funcionario) {

		// Cria uma sessão
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
				// Inicia uma transao
			transacao = sessao.beginTransaction();

			sessao.update(funcionario);

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

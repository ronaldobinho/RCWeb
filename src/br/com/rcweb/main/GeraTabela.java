package br.com.rcweb.main;

import br.com.rcweb.util.HibernateUtil;

public class GeraTabela {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();

	}

}

package br.com.rcweb.teste;

import org.junit.Test;

import br.com.rcweb.util.HibernateUtil;

public class GeraTabelaTest {
	
   @Test
	public void gerar(){
		
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}
}

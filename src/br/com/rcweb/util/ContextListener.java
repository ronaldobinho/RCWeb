package br.com.rcweb.util;

  // Classe ouvinte, esse classe tem como fun��o inciar junto com o servidor Tomcat
public class ContextListener implements ServletContextListener{
    
	//Fun��o realizada ao destruir a sessao do tomcat
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//Finalizada a sessao do Hibernate
		HibernateUtil.getSessionFactory().close();
	}
    // Fun��o realizada ao iniciar a sessao do tomcat
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		// Inicia a sess�o do Hibernate
		HibernateUtil.getSessionFactory().openSession();
		
	}
	

}

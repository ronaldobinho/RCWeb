package br.com.rcweb.util;

  // Classe ouvinte, esse classe tem como função inciar junto com o servidor Tomcat
public class ContextListener implements ServletContextListener{
    
	//Função realizada ao destruir a sessao do tomcat
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//Finalizada a sessao do Hibernate
		HibernateUtil.getSessionFactory().close();
	}
    // Função realizada ao iniciar a sessao do tomcat
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		// Inicia a sessão do Hibernate
		HibernateUtil.getSessionFactory().openSession();
		
	}
	

}

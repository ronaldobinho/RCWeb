package br.com.rcweb.teste;

import org.junit.Ignore;
import org.junit.Test;

import br.com.rcweb.dao.FabricanteDAO;
import br.com.rcweb.domain.Fabricante;

public class FabricanteDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
	  Fabricante f1 = new Fabricante();
	  
	  FabricanteDAO fabricanteDAO = new FabricanteDAO();
	  
	  
	  f1.setDescricao("DESCRICAOA");
	  
	  fabricanteDAO.salvar(f1);
	}
	
	@Test
	@Ignore
	public void listar (){
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		
		List<Fabricante> fabricantes = fabricanteDAO.Listar();		
		
		for(Fabricante fabricante : fabricantes) {
		 System.out.println(fabricante);			
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		
		Fabricante fabricante = new Fabricante();
		
		fabricante = fabricanteDAO.buscarPorCodigo(5L);
		
		System.out.println(fabricante);
	}
	
	@Test
	@Ignore
	public void excluir(){
		
		FabricanteDAO dao = new FabricanteDAO();
		
		Fabricante fabricante = dao.buscarPorCodigo(2L);
		if (fabricante != null) {
		dao.excluir(fabricante);
		}
		
	}
	
	@Test
	@Ignore
	public void editar() {
		
		Fabricante f1 = new Fabricante();
		f1.setCodigo(1L);
		f1.setDescricao("Hellmans");
		
      FabricanteDAO dao = new FabricanteDAO();
      dao.editar(f1);
	    
	}

}

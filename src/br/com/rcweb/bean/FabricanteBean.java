package br.com.rcweb.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.rcweb.dao.FabricanteDAO;
import br.com.rcweb.domain.Fabricante;
import br.com.rcweb.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FabricanteBean {

	private Fabricante fabricanteCadastro;

	private List<Fabricante> listaFabricantes;
	private List<Fabricante> listaFabricantesFiltrados;
	
	private String acao;
	private Long codigo;

	public void salvar() {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.salvar(fabricanteCadastro);

			fabricanteCadastro = new Fabricante();

			FacesUtil.addMsgInfo("Fabricante Salvo com Sucesso");

		} catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			FacesUtil.addMsgErro("Erro ao tentar incluir o fabricante : " + e.getMessage());
		}

	}
	
	
	public void excluir() {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.excluir(fabricanteCadastro);

			FacesUtil.addMsgInfo("Fabricante removido com Sucesso");

		} catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			FacesUtil.addMsgErro("Erro ao tentar remover o fabricante : " + e.getMessage());
		}
	}
		
		public void editar() {
			try {
				FabricanteDAO fabricanteDAO = new FabricanteDAO();
				fabricanteDAO.editar(fabricanteCadastro);

				FacesUtil.addMsgInfo("Fabricante alterado com Sucesso");

			} catch (RuntimeException e) {
				// TODO: handle exception
				e.printStackTrace();
				FacesUtil.addMsgErro("Erro ao tentar remover o fabricante : " + e.getMessage());
			}

	}
	
	public void carregarPesquisa(){
		
		
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			
			listaFabricantes = fabricanteDAO.Listar();

		} catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			FacesUtil.addMsgErro("Erro ao carregar pesquisa: " + e.getMessage());
		}
	}
	
	
	public void carregarCadastro(){
		
		try {
					
			if( codigo != null) {
				
				FabricanteDAO fabricanteDAO = new FabricanteDAO();
				
				fabricanteCadastro = fabricanteDAO.buscarPorCodigo(codigo);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			FacesUtil.addMsgErro("Falha ao carregar Fabricante.");
		}
		
	}

	public Fabricante getFabricanteCadastro() {
		if (fabricanteCadastro == null)
			fabricanteCadastro = new Fabricante();
		return fabricanteCadastro;
	}

	public void setFabricanteCadastro(Fabricante fabricanteCadastro) {
		this.fabricanteCadastro = fabricanteCadastro;
	}

	public List<Fabricante> getListaFabricantes() {
		return listaFabricantes;
	}

	public void setListaFabricantes(List<Fabricante> listaFabricantes) {
		this.listaFabricantes = listaFabricantes;
	}

	public List<Fabricante> getListaFabricantesFiltrados() {
		return listaFabricantesFiltrados;
	}

	public void setListaFabricantesFiltrados(List<Fabricante> listaFabricantesFiltrados) {
		this.listaFabricantesFiltrados = listaFabricantesFiltrados;
	}


	public String getAcao() {
		return acao;
	}


	public void setAcao(String acao) {
		this.acao = acao;
	}


	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	

}

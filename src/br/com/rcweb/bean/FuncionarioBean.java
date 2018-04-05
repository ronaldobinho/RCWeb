package br.com.rcweb.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.rcweb.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FuncionarioBean {
	
	public void salvar(){
   	 
   	 FacesUtil.addMsgInfo("Funcionário Salvo com Sucesso");
   	 
    }

}

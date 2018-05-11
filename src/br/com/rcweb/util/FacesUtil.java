package br.com.rcweb.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.hibernate.mapping.Map;

public class FacesUtil {
	public static void addMsgInfo(String mensagem) {
		FacesMessage facemessage = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);

		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, facemessage);
	}

	public static void addMsgErro(String mensagem) {
		FacesMessage facemessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);

		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, facemessage);

	}

	public static String getParam(String nome) {
		// Pega o contexto da aplicação
		FacesContext facesContext = FacesContext.getCurrentInstance();

		// Contexto do navegador
		ExternalContext externalContext = facesContext.getExternalContext();

		// Pega um mapa de parametros e cria um mapa com os parametros que
		// vieram do navegador

		Map<String, String> parametros = externalContext.getRequestParameterMap();

		// Armazena o parametro

		String valor = parametros.get(nome);

 		return valor;

	}

}

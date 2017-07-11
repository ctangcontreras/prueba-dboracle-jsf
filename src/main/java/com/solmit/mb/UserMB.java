package com.solmit.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.solmit.entidad.Dbuser;
import com.solmit.service.UsuarioService;
 
@ManagedBean(name="userMB")
@SessionScoped
public class UserMB {

	@ManagedProperty(value="#{usuarioService}")
	UsuarioService usuarioService;
	
	private List<Dbuser> listaUsuario;
	
 

	public List<Dbuser> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Dbuser> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	
	@PostConstruct
	public void init() {

		System.out.println(">> init");
 		listaUsuario=usuarioService.listarUsuarios();
 
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

 

 
}

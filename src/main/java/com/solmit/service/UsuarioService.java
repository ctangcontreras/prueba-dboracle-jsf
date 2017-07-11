package com.solmit.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.solmit.dao.UsuarioDao;
import com.solmit.entidad.Dbuser;
 

@ManagedBean(name = "usuarioService")
@SessionScoped
public class UsuarioService {

	@ManagedProperty(value = "#{usuarioDao}")
	private UsuarioDao usuarioDao;

	public Dbuser obtenerUsuario(int idUsuario) {
		return this.usuarioDao.obtenerUsuario(idUsuario);
	}

	public List<Dbuser> listarUsuarios() {
		return this.usuarioDao.listarUsuarios();
	}

	public void eliminar(int id) {
		this.usuarioDao.eliminar(id);
	}

	public void persistir(Dbuser usuario) {
 		this.usuarioDao.insertar(usuario);
	}

	public void actualizar(Dbuser usuario) {
		this.usuarioDao.actualizar(usuario);
	}

 

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

}

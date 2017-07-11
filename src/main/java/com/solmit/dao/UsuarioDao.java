package com.solmit.dao;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.solmit.entidad.Dbuser;
import com.solmit.util.HibernateUtil;
 
@ManagedBean(name = "usuarioDao")
@SessionScoped
public class UsuarioDao {
	Session session = null;

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	@SuppressWarnings("unchecked")
	public List<Dbuser> listarUsuarios() {
		// 1
		 System.out.println(">ZD>X>ZX>Z");
		 session = HibernateUtil.getSessionFactory().openSession();
		 session.beginTransaction();
		 List<Dbuser> result = (List<Dbuser>) session.createQuery("from Dbuser").list();
		 session.getTransaction().commit();
		 for (Dbuser dbuser : result) {
			System.out.println(">"+dbuser);
		}
		 
		 return result;

		// 2
//		session = HibernateUtil.getSessionFactory().openSession();
//		org.hibernate.Query query = session.createQuery("from Dbuser");
//		return query.list();

	}

	public Dbuser insertar(Dbuser usuario) {

		session = HibernateUtil.getSessionFactory().openSession();

		// 1
		// session.beginTransaction();
		// session.persist(usuario);
		// session.getTransaction().commit();
		// return usuario;

		// 2
		session.beginTransaction();
		session.save(usuario);
		session.getTransaction().commit();
		return usuario;
	}

	public Dbuser actualizar(Dbuser usuario) {
		session = HibernateUtil.getSessionFactory().openSession();
		
		//1
//		session.beginTransaction();
//		session.merge(usuario);
//		session.getTransaction().commit();
		
		//2
		session.beginTransaction();
		session.update(usuario);
		session.getTransaction().commit();
		
		return usuario;
	}
	
	public void eliminar(int id){
		System.out.println("eliminar");
		//1
		Dbuser usuario=(Dbuser)session.get(Dbuser.class,id);
		session.beginTransaction();
		session.delete(usuario);
		session.getTransaction().commit();
 		
	}
	
    public Dbuser obtenerUsuario(int id) {
    	session = HibernateUtil.getSessionFactory().openSession();
        return (Dbuser) session.get(Dbuser.class, id);  
    }
    
	public Long contador() {
		org.hibernate.Query query = session.createQuery("SELECT COUNT(*) FROM Dbuser");
		Long cont = (Long) query.uniqueResult();
		return cont;

	}
    
}

package HibernateTest;

import java.util.Objects;

import org.hibernate.Session;

import com.solmit.dao.UsuarioDao;
import com.solmit.util.HibernateUtil;

public class Test {
 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSessionFactory().openSession();

		if (Objects.nonNull(session)) {
			System.out.println("Conexion Exitosa");
		} else {
			System.out.println("Conexion Fallida");
		}

 	
		// listar
		UsuarioDao dao = new UsuarioDao();
		dao.listarUsuarios();// ok
		
		//insertar
//		Dbuser user = new Dbuser();
//		user.setUserId(104);
//		user.setUsername("BATMAN3");
//		user.setCreatedBy("samir");
//		user.setCreatedDate(new Date());
//		dao.insertar(user);
		
		//editar
//		Dbuser user = new Dbuser();
//		user.setUserId(104);
//		user.setUsername("ironman2");
//		user.setCreatedBy("samir t");
//		user.setCreatedDate(new Date());
//		dao.actualizar(user);
		
		//eliminar  
//		dao.obtenerUsuario(103);
		
		//contador
//		 Long a =dao.contador();
//		 System.out.println(">"+a);
	}

}

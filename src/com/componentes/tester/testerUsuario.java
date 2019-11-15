package com.componentes.tester;

import java.util.List;

import com.componentes.dao.*;
import com.componentes.entidades.*;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

public class testerUsuario {


	private static EntityManagerFactory entityManagerFactory = null;
	private static EntityManager em = null;

	public static void main(String[] args) {
		try {
			
			startEntityManagerFactory();
		/*	
			Usuario u = new Usuario();
			u.setNombre("Anthony");
			u.setConstrania("qwop123!");
			u.setCorreo("cotoandres2018@gmail.com");
			
			
			em.getTransaction().begin();
			
			em.persist(u);
			
			em.getTransaction().commit();
		
			
			System.out.println("Yay");
			
			Usuario u = new Usuario();
			
			System.out.println(" " + findPK().getNombre());

			System.out.println(" " + findPK().getConstrania());
			
			UsuarioDAO<Usuario> ud = new UsuarioDAO<Usuario>();
			
			System.out.println(ud.getUsuario(1, u).getNombre());
			

			System.out.println(ud.getUsuario(1, u).getConstrania());
			
			
			*/
			
			stopEntityManagerFactory();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static Usuario findPK() throws Exception {
		Usuario usuario = (Usuario)em.createNamedQuery("Usuario.findPK").
											setParameter("idParam", new Integer("1")).
											getSingleResult();
		return usuario;
	}
	
	
	public static void startEntityManagerFactory() {
		if (entityManagerFactory == null) {
			try {
				entityManagerFactory = Persistence
						.createEntityManagerFactory("Componentes");
				em = entityManagerFactory.createEntityManager();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void stopEntityManagerFactory() {
		if (entityManagerFactory != null) {
			if (entityManagerFactory.isOpen()) {
				try {
					entityManagerFactory.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			em.close();
			entityManagerFactory = null;
		}
	}
   
   
}


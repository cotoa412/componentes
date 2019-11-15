package com.componentes.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import com.componentes.entidades.Formulario;
import com.componentes.entidades.Usuario;

public class FormularioDAO extends Servicio implements IDao {

	@Override
	public void Insert(Object t) {
		
		Formulario fr = new Formulario();
		

		
		this.startEntityManagerFactory();
		
		this.em.getTransaction().begin();
		
		this.em.persist(fr);
		
		this.em.getTransaction().commit();
		
		this.stopEntityManagerFactory();
		
	}

	@Override
	public void Update(Object t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(Object t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Formulario Get(int id) {
		
		this.startEntityManagerFactory();
		Formulario formLeido = em.find(Formulario.class, new Integer("1"));
		this.stopEntityManagerFactory();
		return formLeido; 
	}

	@Override
	public List<Formulario> GetList() {
		
		
		this.startEntityManagerFactory();
		
		this.em.getTransaction().begin();
		

		TypedQuery<Formulario> query = em.createNamedQuery("Formulario.findPK", Formulario.class);
		this.stopEntityManagerFactory();

		
		return query.getResultList();

		
		
	}
	
	
//	TypedQuery<DemoPersona> query = em.createNamedQuery("DemoPersona.findAllSQLWithParam", DemoPersona.class);
//	query.setParameter("nombreParam", "%Fde%");
//	return query.getResultList();
	
	public List<Formulario> GetList(Usuario usuario) {

		List<Formulario> retorno = new ArrayList<>(); 
		
		this.startEntityManagerFactory();
	    this.em.getTransaction().begin();
		
		try {
			retorno = this.findAllSQLWithParam(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	    
		this.stopEntityManagerFactory();

		return retorno; 
	}
	
	public  List<Formulario> findAllSQLWithParam(Usuario usuario) throws Exception {
		
		TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findAllSQLWithParam", Usuario.class);
		
		query.setParameter("idParam", usuario.getId());
		if(query.getResultList().size() > 0) {
			
			List<Formulario> lst = query.getResultList().get(0).GetFomurlarios(); 
			return lst;
		}
		else
			return new ArrayList<Formulario>(); 
	}
	
}





















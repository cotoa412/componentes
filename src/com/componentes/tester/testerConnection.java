package com.componentes.tester;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class testerConnection {

	public  EntityManagerFactory entityManagerFactory = null;
	public  EntityManager em = null;
	
	public testerConnection() {
		
//		try {
//	            startEntityManagerFactory();
//	            
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	     stopEntityManagerFactory();
//			

	}
	
   public  void startEntityManagerFactory() throws Exception {
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
   
   public  void stopEntityManagerFactory() {
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

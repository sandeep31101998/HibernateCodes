package com.technoelevate.HibernateBasics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.technoelevate.hibernatejpa.bean.Movies;

public class DeleteMovie {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction EntityTransaction =null;

		try {
			
			emf=Persistence.createEntityManagerFactory("Moviedata");
			entityManager = emf.createEntityManager();
			EntityTransaction = entityManager.getTransaction();
			
			EntityTransaction.begin();
			
			Movies movie = entityManager.find(Movies.class, 10);
			
			entityManager.remove(movie);
			
			EntityTransaction.commit();
		} catch (Exception e) {
			if(EntityTransaction!=null) {
				EntityTransaction.rollback();
			}
			e.printStackTrace();
		}
	}

}

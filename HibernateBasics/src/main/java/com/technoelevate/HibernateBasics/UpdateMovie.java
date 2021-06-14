package com.technoelevate.HibernateBasics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.technoelevate.hibernatejpa.bean.Movies;

public class UpdateMovie {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction =null;
		
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("Moviedata");
			entityManager = entityManagerFactory.createEntityManager();
			transaction=entityManager.getTransaction();
			
			transaction.begin();
			
			Movies movie = entityManager.find(Movies.class, 30);
			if(movie!=null) {
				movie.setName("power");
			}
			transaction.commit();
		}catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}

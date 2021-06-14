package com.technoelevate.HibernateBasics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.technoelevate.hibernatejpa.bean.Movies;

public class InsertMovie {

	public static void main(String[] args) {
		
		Movies movie = new Movies();
		movie.setId(30);
		movie.setHero("punith");
		movie.setName("yuvaratna");
		movie.setRating(8.0);

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction =null;
		
		try {
			
			entityManagerFactory = Persistence.createEntityManagerFactory("Moviedata");
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction();
			transaction = entityManager.getTransaction();
			
			transaction.begin();
			
			entityManager.persist(movie);
			System.out.println("inserted data into table");
			
			transaction.commit();
			
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

}

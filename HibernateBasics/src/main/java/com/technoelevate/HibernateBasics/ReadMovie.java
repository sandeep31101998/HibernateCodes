package com.technoelevate.HibernateBasics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.technoelevate.hibernatejpa.bean.Movies;

public class ReadMovie {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction EntityTransaction =null;
		
		try {
			emf=Persistence.createEntityManagerFactory("Moviedata");
			entityManager = emf.createEntityManager();
			
			
			Movies movie = entityManager.getReference(Movies.class, 20);
			
			System.out.println(movie.getId()+" "+movie.getHero()+" "+movie.getName()+" "+movie.getRating());
			
		}  catch (Exception e) {
			if(EntityTransaction!=null) {
				EntityTransaction.rollback();
			}
			e.printStackTrace();
		}

	}

}

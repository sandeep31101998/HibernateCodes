package com.technoelevate.HibernateBasics;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.technoelevate.hibernatejpa.bean.Movies;
public class DetachAndMerge {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("Moviedata");
			entityManager = emf.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			
			entityTransaction.begin();
			
			Movies movie = entityManager.find(Movies.class,20);
			System.out.println("before detach");
			
			System.out.println(entityManager.contains(movie));//true
			
			entityManager.detach(movie);
			
			System.out.println("after detach");
			
			System.out.println(entityManager.contains(movie));//false
			
			Movies mov = entityManager.merge(movie);
			System.out.println(entityManager.contains(mov));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

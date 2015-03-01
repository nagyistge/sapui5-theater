package com.arnaudbertrand.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sap.hana.cloud.sample.Theme;

public class Main {
	public static final String PERSISTENCE_UNIT_NAME = "sapui5-theater-model-jpa";
	private static EntityManagerFactory factory;
	
	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Theme theme = new Theme();
		theme.setTheme("Youuuu");
		em.persist(theme);
		em.getTransaction().commit();
		em.close();
		System.out.println("***");
	}

}

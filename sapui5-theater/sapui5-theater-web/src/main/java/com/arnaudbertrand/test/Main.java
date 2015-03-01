package com.arnaudbertrand.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sap.hana.cloud.odata.service.JpaEntityManagerFactory;
import com.sap.hana.cloud.sample.Theme;

public class Main {
	public static final String PERSISTENCE_UNIT_NAME = "sapui5-theater-model-jpa";
	private static EntityManagerFactory factory;
	
	public static void main(String[] args) {
		try {
			EntityManagerFactory emf = JpaEntityManagerFactory.getEntityManagerFactory();
			System.out.println("***");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}

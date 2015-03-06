package com.sapui5theater.model.data;

import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataLoader {
	
	private static Logger logger = LoggerFactory.getLogger(DataLoader.class);
	
	private EntityManagerFactory emf;

	public DataLoader(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public void loadArtists() {
		logger.info("Yop yop");
	}
	
	public void loadData() {
		System.out.println("--> DataLoader");
		loadArtists();
		logger.info("Yop");
	}

}

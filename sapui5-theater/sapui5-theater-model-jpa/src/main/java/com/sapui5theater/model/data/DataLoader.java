package com.sapui5theater.model.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sapui5theater.model.data.XMLParser;
import com.sapui5theater.model.Artist;

public class DataLoader {
	
	private static Logger logger = LoggerFactory.getLogger(DataLoader.class);
	
	private EntityManagerFactory emf;

	public DataLoader(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public void loadArtists() {
		System.out.println("--> Loading artists");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Artist> queryA;
		List<Artist> resA;
		//TODO: check if there is already data in the table
		new XMLParser().readArtists(em,
				"com/sapui5theater/model/data/musicdb-test.xml");
	}
	
	public void loadData() {
		System.out.println("--> DataLoader");
		loadArtists();
	}

}

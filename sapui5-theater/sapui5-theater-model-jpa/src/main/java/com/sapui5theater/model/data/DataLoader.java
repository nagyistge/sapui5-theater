package com.sapui5theater.model.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

//TODO: implement logging and where to read the logs?
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sapui5theater.model.Genre;
import com.sapui5theater.model.Artist;
import com.sapui5theater.model.Album;

public class DataLoader {
	
	private static Logger logger = LoggerFactory.getLogger(DataLoader.class);
	
	private EntityManagerFactory emf;

	public DataLoader(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public void loadGenres() {
		System.out.println("--> Loading genres");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Genre> queryG;
		List<Genre> resG = null; 
		//TODO: check if there is already data in the table
		try {
			em.getTransaction().begin();
			new XMLParser().readGenres(em,
					"com/sapui5theater/model/data/musicdb-test.xml");
			em.getTransaction().commit();
			queryG = em.createQuery("SELECT g FROM Genre g", 
					Genre.class);
			resG = queryG.getResultList();
			System.out.println("Number of albums: " + resG.size());
			
		} catch (Exception e) {
			System.out.println("Exception occuredLAl" + e);
			logger.error("Exception occured", e);
		} finally {
			em.close();
		}
	}
	
	public void loadArtists() {
		System.out.println("--> Loading artists");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Artist> queryAr;
		List<Artist> resAr = null; 
		//TODO: check if there is already data in the table
		try {
			em.getTransaction().begin();
			new XMLParser().readArtists(em,
					"com/sapui5theater/model/data/musicdb-test.xml");
			em.getTransaction().commit();
			queryAr = em.createQuery("SELECT ar FROM Artist ar", 
					Artist.class);
			resAr = queryAr.getResultList();
			System.out.println("Number of artists: " + resAr.size());
			
		} catch (Exception e) {
			System.out.println("Exception occuredLAr" + e);
			logger.error("Exception occured", e);
		} finally {
			em.close();
		}
	}
	
	public void loadAlbums() {
		System.out.println("--> Loading albums");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Album> queryAl;
		List<Album> resAl = null; 
		//TODO: check if there is already data in the table
		try {
			em.getTransaction().begin();
			new XMLParser().readAlbums(em,
					"com/sapui5theater/model/data/musicdb-test.xml");
			em.getTransaction().commit();
			queryAl = em.createQuery("SELECT al FROM Album al", 
					Album.class);
			resAl = queryAl.getResultList();
			System.out.println("Number of albums: " + resAl.size());
			
		} catch (Exception e) {
			System.out.println("Exception occuredLAl" + e);
			logger.error("Exception occured", e);
		} finally {
			em.close();
		}
	}
	
	public void loadData() {
		System.out.println("--> DataLoader");
		loadGenres();
		loadArtists();
		loadAlbums();
	}

}

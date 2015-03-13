package com.sapui5theater.model.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

//TODO: implement logging and where to read the logs? // Complex, use jul-2-slf4j
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sapui5theater.model.Genre;
import com.sapui5theater.model.Style;
import com.sapui5theater.model.Mood;
import com.sapui5theater.model.Theme;
import com.sapui5theater.model.Artist;
import com.sapui5theater.model.Album;
import com.sapui5theater.model.Track;

public class DataLoader {
	
	private static Logger logger = LoggerFactory.getLogger(DataLoader.class);
	
	private EntityManagerFactory emf;

	public DataLoader(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public void loadGenres() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Genre> queryG;
		List<Genre> resG = null; 
		//TODO: check if there is already data in the table
		try {
			em.getTransaction().begin();
			new XMLParser().readGenres(em,
					"com/sapui5theater/model/data/musicdb.xml");
			em.getTransaction().commit();
			queryG = em.createQuery("SELECT g FROM Genre g", 
					Genre.class);
			resG = queryG.getResultList();
			System.out.println("Number of genres: " + resG.size());	
		} catch (Exception e) {
			System.out.println("Exception occured" + e);
			logger.error("Exception occured", e);
		} finally {
			em.close();
		}
	}
	
	public void loadStyles() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Style> queryS;
		List<Style> resS = null; 
		//TODO: check if there is already data in the table
		try {
			em.getTransaction().begin();
			new XMLParser().readStyles(em,
					"com/sapui5theater/model/data/musicdb.xml");
			em.getTransaction().commit();
			queryS = em.createQuery("SELECT s FROM Style s", 
					Style.class);
			resS = queryS.getResultList();
			System.out.println("Number of styles: " + resS.size());
		} catch (Exception e) {
			System.out.println("Exception occured" + e);
			logger.error("Exception occured", e);
		} finally {
			em.close();
		}
	}
	
	public void loadMoods() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Mood> queryM;
		List<Mood> resM = null; 
		//TODO: check if there is already data in the table
		try {
			em.getTransaction().begin();
			new XMLParser().readMoods(em,
					"com/sapui5theater/model/data/musicdb.xml");
			em.getTransaction().commit();
			queryM = em.createQuery("SELECT m FROM Mood m", 
					Mood.class);
			resM = queryM.getResultList();
			System.out.println("Number of moods: " + resM.size());
		} catch (Exception e) {
			System.out.println("Exception occured" + e);
			logger.error("Exception occured", e);
		} finally {
			em.close();
		}
	}
	
	public void loadThemes() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Theme> queryT;
		List<Theme> resT = null; 
		//TODO: check if there is already data in the table
		try {
			em.getTransaction().begin();
			new XMLParser().readThemes(em,
					"com/sapui5theater/model/data/musicdb.xml");
			em.getTransaction().commit();
			queryT = em.createQuery("SELECT th FROM Theme th", 
					Theme.class);
			resT = queryT.getResultList();
			System.out.println("Number of themes: " + resT.size());
		} catch (Exception e) {
			System.out.println("Exception occured" + e);
			logger.error("Exception occured", e);
		} finally {
			em.close();
		}
	}
	
	public void loadArtists() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Artist> queryAr;
		List<Artist> resAr = null; 
		//TODO: check if there is already data in the table
		try {
			em.getTransaction().begin();
			new XMLParser().readArtists(em,
					"com/sapui5theater/model/data/musicdb.xml");
			em.getTransaction().commit();
			queryAr = em.createQuery("SELECT ar FROM Artist ar", 
					Artist.class);
			resAr = queryAr.getResultList();
			System.out.println("Number of artists: " + resAr.size());
			
		} catch (Exception e) {
			System.out.println("Exception occured" + e);
			logger.error("Exception occured", e);
		} finally {
			em.close();
		}
	}
	
	public void loadAlbums() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Album> queryAl;
		List<Album> resAl = null; 
		//TODO: check if there is already data in the table
		try {
			em.getTransaction().begin();
			new XMLParser().readAlbums(em,
					"com/sapui5theater/model/data/musicdb.xml");
			em.getTransaction().commit();
			queryAl = em.createQuery("SELECT al FROM Album al", 
					Album.class);
			resAl = queryAl.getResultList();
			System.out.println("Number of albums: " + resAl.size());
			
		} catch (Exception e) {
			System.out.println("Exception occured" + e);
			logger.error("Exception occured", e);
		} finally {
			em.close();
		}
	}
	
	public void loadTracks() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Track> queryTr;
		List<Track> resTr = null; 
		//TODO: check if there is already data in the table
		try {
			em.getTransaction().begin();
			new XMLParser().readTracks(em,
					"com/sapui5theater/model/data/musicdb.xml");
			em.getTransaction().commit();
			queryTr = em.createQuery("SELECT tr FROM Track tr", 
					Track.class);
			resTr = queryTr.getResultList();
			System.out.println("--> Number of tracks: " + resTr.size());
			
		} catch (Exception e) {
			System.out.println("Exception occured" + e);
			logger.error("Exception occured", e);
		} finally {
			em.close();
		}
	}
	
	public void loadData() {
		System.out.println("--> DataLoader");
		loadGenres();
		loadStyles();
		loadMoods();
		loadThemes();
		loadArtists();
		//loadAlbums();
		//loadTracks();
	}

}

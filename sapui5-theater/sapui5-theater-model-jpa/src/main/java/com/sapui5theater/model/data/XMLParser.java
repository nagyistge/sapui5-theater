package com.sapui5theater.model.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sapui5theater.model.Genre;
import com.sapui5theater.model.Style;
import com.sapui5theater.model.Mood;
import com.sapui5theater.model.Theme;
import com.sapui5theater.model.Artist;
import com.sapui5theater.model.Album;

//TODO: remove list arrays ... they are not used
//TODO: Manage Boolean, mandatory field

public class XMLParser {
	static final String GENRE = "genre";
	static final String STYLE = "style";
	static final String MOOD = "mood";
	static final String THEME = "theme";
	static final String ARTIST = "artist";
	static final String NAME = "name";
	static final String MUSICBRAINZARTISTID = "musicBrainzArtistID";
	static final String YEARSACTIVE = "yearsactive";
	static final String BIOGRAPHY = "biography";	
	static final String BORN = "born";
	static final String DIED = "died";
	static final String FORMED = "formed";
	static final String DISBANDED = "disbanded";
	static final String THUMB = "thumb";
	static final String ALBUM = "album";
	static final String TITLE = "title";
	static final String MUSICBRAINZALBUMID = "musicBrainzAlbumID";	
	static final String COMPILATION = "compilation";
	static final String REVIEW = "review";
	static final String LABEL = "label";
	static final String RATING = "rating";
	static final String YEAR = "year";
	
	static Logger logger = LoggerFactory.getLogger(XMLParser.class);
	
	private InputStream in = null;
	private XMLEventReader eventReader = null;
	protected Boolean status;

	/**
	 * Parse Genres and fill List
	 * 
	 * @param gXml
	 * @return Parsed List of Genres
	 */
	public void readGenres(EntityManager em, String aXml) {
		System.out.println("--> Reading genres ...");
		ArrayList<String> genres = new ArrayList<String>();
		try {
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			in = getResourceAsInputStream(aXml);
			eventReader = inputFactory.createXMLEventReader(in);
			Genre gen = null;
			//TODO: check is the level cannot be given by the lib
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					if (startElement.getName().getLocalPart() == (GENRE)) {
						event = eventReader.nextEvent();
						if (!event.isEndElement()) {
							System.out.println(getEvent(event));
							if (!genres.contains(getEvent(event))) {
								gen = new Genre();
								gen.setGenre(getEvent(event));
								em.persist(gen);
								//System.out.println("Persisted!!!");
								genres.add(getEvent(event));
							} else {
								//System.out.println("Already in the list!");
							}							
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occuredRG" + e.toString());
			logger.error("Exception occured", e);
			status = false;
		} finally {
			try {
				in.close();
				eventReader.close();
			} catch (IOException e) {
				System.out.println("IO Exception occured" + e.toString());
				logger.error("IO Exception occured", e);
				status = false;
			} catch (XMLStreamException e) {
				System.out.println("XMLStream exception occured" + e.toString());
				logger.error("XMLStream exception occured", e);
				status = false;
			}
		}
	}
	
	/**
	 * Parse Styles and fill List
	 * 
	 * @param sXml
	 * @return Parsed List of Styles
	 */
	//TODO: change param name XML file to a single file name
	public void readStyles(EntityManager em, String sXml) {
		System.out.println("--> Reading styles ...");
		ArrayList<String> styles = new ArrayList<String>();
		try {
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			in = getResourceAsInputStream(sXml);
			eventReader = inputFactory.createXMLEventReader(in);
			Style sty = null;
			//TODO: check is the level cannot be given by the lib
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					if (startElement.getName().getLocalPart() == (STYLE)) {
						event = eventReader.nextEvent();
						if (!event.isEndElement()) {
							System.out.println(getEvent(event));
							if (!styles.contains(getEvent(event))) {
								sty = new Style();
								sty.setStyle(getEvent(event));
								em.persist(sty);
								//System.out.println("Persisted!!!");
								styles.add(getEvent(event));
							} else {
								//System.out.println("Already in the list!");
							}							
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occuredRS" + e.toString());
			logger.error("Exception occured", e);
			status = false;
		} finally {
			try {
				in.close();
				eventReader.close();
			} catch (IOException e) {
				System.out.println("IO Exception occured" + e.toString());
				logger.error("IO Exception occured", e);
				status = false;
			} catch (XMLStreamException e) {
				System.out.println("XMLStream exception occured" + e.toString());
				logger.error("XMLStream exception occured", e);
				status = false;
			}
		}
	}
	
	
	/**
	 * Parse Moods and fill List
	 * 
	 * @param mXml
	 * @return Parsed List of Moods
	 */
	//TODO: change param name XML file to a single file name
	public void readMoods(EntityManager em, String mXml) {
		System.out.println("--> Reading moods ...");
		ArrayList<String> moods = new ArrayList<String>();
		try {
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			in = getResourceAsInputStream(mXml);
			eventReader = inputFactory.createXMLEventReader(in);
			Mood moo = null;
			//TODO: check is the level cannot be given by the lib
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					if (startElement.getName().getLocalPart() == (MOOD)) {
						event = eventReader.nextEvent();
						if (!event.isEndElement()) {
							//System.out.println(getEvent(event));
							if (!moods.contains(getEvent(event))) {
								moo = new Mood();
								moo.setMood(getEvent(event));
								em.persist(moo);
								//System.out.println("Persisted!!!");
								moods.add(getEvent(event));
							} else {
								//System.out.println("Already in the list!");
							}							
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occuredRM" + e.toString());
			logger.error("Exception occured", e);
			status = false;
		} finally {
			try {
				in.close();
				eventReader.close();
			} catch (IOException e) {
				System.out.println("IO Exception occured" + e.toString());
				logger.error("IO Exception occured", e);
				status = false;
			} catch (XMLStreamException e) {
				System.out.println("XMLStream exception occured" + e.toString());
				logger.error("XMLStream exception occured", e);
				status = false;
			}
		}
	}
	
	/**
	 * Parse Themes and fill List
	 * 
	 * @param tXml
	 * @return Parsed List of Themes
	 */
	//TODO: change param name XML file to a single file name
	public void readThemes(EntityManager em, String tXml) {
		System.out.println("--> Reading themes ...");
		ArrayList<String> themes = new ArrayList<String>();
		try {
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			in = getResourceAsInputStream(tXml);
			eventReader = inputFactory.createXMLEventReader(in);
			Theme the = null;
			//TODO: check is the level cannot be given by the lib
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					if (startElement.getName().getLocalPart() == (THEME)) {
						event = eventReader.nextEvent();
						if (!event.isEndElement()) {
							//System.out.println(getEvent(event));
							if (!themes.contains(getEvent(event))) {
								the = new Theme();
								the.setTheme(getEvent(event));
								em.persist(the);
								//System.out.println("Persisted!!!");
								themes.add(getEvent(event));
							} else {
								//System.out.println("Already in the list!");
							}							
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occuredRT" + e.toString());
			logger.error("Exception occured", e);
			status = false;
		} finally {
			try {
				in.close();
				eventReader.close();
			} catch (IOException e) {
				System.out.println("IO Exception occured" + e.toString());
				logger.error("IO Exception occured", e);
				status = false;
			} catch (XMLStreamException e) {
				System.out.println("XMLStream exception occured" + e.toString());
				logger.error("XMLStream exception occured", e);
				status = false;
			}
		}
	}
	
	/**
	 * Parse Artists and fill List
	 * 
	 * @param aXml
	 * @return Parsed List of Artists
	 */
	public List<Artist> readArtists(EntityManager em, String aXml) {
		System.out.println("--> Reading artists ...");
		ArrayList<Artist> artists = new ArrayList<Artist>();
		try {
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			in = getResourceAsInputStream(aXml);
			eventReader = inputFactory.createXMLEventReader(in);
			Artist art = null;
			//TODO: check is the level cannot be given by the lib
			int level = 0;
			Boolean artFlg = false;
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				if (event.isStartElement()) {
					level++;
					StartElement startElement = event.asStartElement();
					if (startElement.getName().getLocalPart() == (ARTIST) && level == 2) {
						artFlg = true;
						art = new Artist();
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(NAME)) {
						event = eventReader.nextEvent();
						art.setName(getEvent(event));
						System.out.println(getEvent(event));
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(GENRE) && artFlg) {
						event = eventReader.nextEvent();
						if (!event.isEndElement()) {
							System.out.println(getEvent(event));
							Genre gen = em.createQuery("SELECT g FROM Genre g WHERE g.genre = :genre", Genre.class)
									.setParameter("genre", getEvent(event)).getSingleResult();
							//System.out.println("ID of genre: " + gen.getGenreId());
							art.setGenre(gen);
						} else {
							level--;
						}
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(STYLE) && artFlg) {
						event = eventReader.nextEvent();
						if (!event.isEndElement()) {
							//System.out.println(getEvent(event));
							Style sty = em.createQuery("SELECT s FROM Style s WHERE s.style = :style", Style.class)
									.setParameter("style", getEvent(event)).getSingleResult();
							//System.out.println("ID of style: " + sty.getStyleId());
							art.addStyle(sty);
						} else {
							level--;
						}
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(MOOD) && artFlg) {
						event = eventReader.nextEvent();
						if (!event.isEndElement()) {
							//System.out.println(getEvent(event));
							Mood moo = em.createQuery("SELECT m FROM Mood m WHERE m.mood = :mood", Mood.class)
									.setParameter("mood", getEvent(event)).getSingleResult();
							//System.out.println("ID of mood: " + moo.getMoodId());
							art.addMood(moo);
						} else {
							level--;
						}
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(MUSICBRAINZARTISTID) && artFlg) {
						event = eventReader.nextEvent();
						art.setMusicBrainzArtistID(getEvent(event));
						//System.out.println(getEvent(event));
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(YEARSACTIVE) && artFlg) {
						event = eventReader.nextEvent();
						art.setYearsActive(getEvent(event));
						System.out.println(getEvent(event));
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(BIOGRAPHY) && artFlg) {
						event = eventReader.nextEvent();
						if (!event.isEndElement()) {
							art.setBiography(getEvent(event).substring(0, Math.min(getEvent(event).length(), 255)));
							System.out.println(getEvent(event));
						} else {
							level--;
						}
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(BORN) && artFlg) {
						event = eventReader.nextEvent();
						if (!event.isEndElement()) {
							art.setBornInfo(getEvent(event));
							System.out.println(getEvent(event));
						} else {
							level--;
						}
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(DIED) && artFlg) {
						event = eventReader.nextEvent();
						if (!event.isEndElement()) {
							art.setDied(Boolean.valueOf(getEvent(event)));
							System.out.println(getEvent(event));
						} else {
							level--;
						}
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(FORMED) && artFlg) {
						event = eventReader.nextEvent();
						if (!event.isEndElement()) {
							art.setBandFormed(getEvent(event));
							System.out.println(getEvent(event));							
						} else {
							level--;
						}
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(DISBANDED) && artFlg) {
						event = eventReader.nextEvent();
						if (!event.isEndElement()) {
							art.setBandDisbanded(Boolean.valueOf(getEvent(event)));
							System.out.println(getEvent(event));
						} else {
							level--;
						}
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(THUMB) && level == 4) {
						event = eventReader.nextEvent();
						if (!event.isEndElement()) {
							art.setThumbURL(getEvent(event));
							System.out.println(getEvent(event));
						} else {
							level--;
						}
						continue;
					}
				}
				
				// If we reach the end of an item element we add it to the list
				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart() == (ARTIST) && level == 2) {
						em.persist(art);
						artists.add(art);
						System.out.println("Persisted!!!");
						artFlg = false;
					}
					level--;
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occuredRAr" + e.toString());
			logger.error("Exception occured", e);
			status = false;
		} finally {
			try {
				in.close();
				eventReader.close();
			} catch (IOException e) {
				System.out.println("IO Exception occured" + e.toString());
				logger.error("IO Exception occured", e);
				status = false;
			} catch (XMLStreamException e) {
				System.out.println("XMLStream exception occured" + e.toString());
				logger.error("XMLStream exception occured", e);
				status = false;
			}
		}
		
		return artists;
	}
	
	/**
	 * Parse Albums and fill List
	 * 
	 * @param aXml
	 * @return Parsed List of Albums
	 */
	//TODO: rename aXml to alXml (for artist and album)
	public List<Album> readAlbums(EntityManager em, String aXml) {
		System.out.println("--> Reading albums ...");
		ArrayList<Album> albums = new ArrayList<Album>();
		try {
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			in = getResourceAsInputStream(aXml);
			eventReader = inputFactory.createXMLEventReader(in);
			Album alb = null;
			//TODO: check is the level cannot be given by the lib
			int level = 0;
			Boolean albFlg = false;
			Boolean thuFlg = false;
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				if (event.isStartElement()) {
					level++;				
					StartElement startElement = event.asStartElement();
					if (startElement.getName().getLocalPart() == (ALBUM) && level == 2) {
						albFlg = true;
						alb = new Album();
						System.out.println(level);
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(TITLE) && level == 3) {
						event = eventReader.nextEvent();
						alb.setTitle(getEvent(event));
						System.out.println(getEvent(event));
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(ARTIST) && level == 3) {
						event = eventReader.nextEvent();
						System.out.println(getEvent(event));
						Artist art = em.createQuery("SELECT ar FROM Artist ar WHERE ar.name = :artist", Artist.class)
								.setParameter("artist", getEvent(event)).getSingleResult();
						alb.setArtist(art);
						System.out.println("Index of artist: " + art.getArtistId());
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(GENRE) && albFlg) {
						event = eventReader.nextEvent();
						if (!event.isEndElement()) {
							//System.out.println(getEvent(event));
							Genre gen = em.createQuery("SELECT g FROM Genre g WHERE g.genre = :genre", Genre.class)
									.setParameter("genre", getEvent(event)).getSingleResult();
							//System.out.println("ID of genre: " + gen.getGenreId());
							alb.setGenre(gen);
						} else {
							level--;
						}
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(STYLE) && albFlg) {
						event = eventReader.nextEvent();
						if (!event.isEndElement()) {
							//System.out.println(getEvent(event));
							Style sty = em.createQuery("SELECT s FROM Style s WHERE s.style = :style", Style.class)
									.setParameter("style", getEvent(event)).getSingleResult();
							//System.out.println("ID of style: " + sty.getStyleId());
							alb.addStyle(sty);
						} else {
							level--;
						}
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(MOOD) && albFlg) {
						event = eventReader.nextEvent();
						if (!event.isEndElement()) {
							System.out.println(getEvent(event));
							Mood moo = em.createQuery("SELECT m FROM Mood m WHERE m.mood = :mood", Mood.class)
									.setParameter("mood", getEvent(event)).getSingleResult();
							//System.out.println("ID of mood: " + moo.getMoodId());
							alb.addMood(moo);
						} else {
							level--;
						}
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(THEME) && albFlg) {
						event = eventReader.nextEvent();
						if (!event.isEndElement()) {
							System.out.println(getEvent(event));
							Theme the = em.createQuery("SELECT t FROM Theme t WHERE t.theme = :theme", Theme.class)
									.setParameter("theme", getEvent(event)).getSingleResult();
							System.out.println("ID of theme: " + the.getThemeId());
							alb.addTheme(the);
						} else {
							level--;
						}
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(MUSICBRAINZALBUMID) && albFlg) {
						event = eventReader.nextEvent();
						alb.setMusicBrainzAlbumID(getEvent(event));
						System.out.println(getEvent(event));
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(COMPILATION)) {
						event = eventReader.nextEvent();
						alb.setCompilation(Boolean.valueOf(getEvent(event)));;
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(REVIEW)) {
						event = eventReader.nextEvent();
						alb.setReview(getEvent(event).substring(0, Math.min(getEvent(event).length(), 255)));
						//TODO: manager longer review fields
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(YEAR)) {
						event = eventReader.nextEvent();
						alb.setYearRelease(Integer.parseInt(getEvent(event)));
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(LABEL)) {
						event = eventReader.nextEvent();
						if (!event.isEndElement()) {
							alb.setLabel(getEvent(event));
						} else {
							level--;
						}
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(RATING)) {
						event = eventReader.nextEvent();
						alb.setRating(Integer.parseInt(getEvent(event)));
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(THUMB)) {
						event = eventReader.nextEvent();
						System.out.println(getEvent(event));
						if (!event.isEndElement()) {
							if (!thuFlg) {
								thuFlg = true;
								alb.setThumbURL(getEvent(event));
							}
						} else {
							level--;
						}
						continue;
					}
				}
				
				// If we reach the end of an item element we add it to the list
				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart() == (ALBUM) && level == 2) {
						albFlg = false;
						thuFlg = false;
						//System.out.println(level);
						em.persist(alb);
						albums.add(alb);
						System.out.println("Persisted!!!");
					}
					level--;
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occuredRAr" + e.toString());
			logger.error("Exception occured", e);
			status = false;
		} finally {
			try {
				in.close();
				eventReader.close();
			} catch (IOException e) {
				System.out.println("IO Exception occured" + e.toString());
				logger.error("IO Exception occured", e);
				status = false;
			} catch (XMLStreamException e) {
				System.out.println("XMLStream exception occured" + e.toString());
				logger.error("XMLStream exception occured", e);
				status = false;
			}
		}

		return albums;
	}
	
	/**
	 * Check if node has text and return it else return null.
	 * 
	 * @param event
	 * @return text of the node
	 */
	public String getEvent(XMLEvent event) {
		if (event.isCharacters()) {
			return event.asCharacters().getData();
		} else {
			return null;
		}
	}

	/**
	 * Find a resource file and convert a Resource File as input stream
	 * 
	 * @param xmlFile
	 *            Resource file which needs to be converted to input stream
	 * @return resource as input stream
	 */
	InputStream getResourceAsInputStream(String xmlFile) {
		return XMLParser.class.getClassLoader().getResourceAsStream(xmlFile);
	}
	
}

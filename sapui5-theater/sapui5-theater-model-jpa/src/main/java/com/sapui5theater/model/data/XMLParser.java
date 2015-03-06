package com.sapui5theater.model.data;

import java.io.File;
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

import com.sapui5theater.model.Artist;

public class XMLParser {
	static final String ARTIST = "artist";
	static final String NAME = "name";
	static final String MUSICBRAINZARTISTID = "musicBrainzArtistID";
	
	static Logger logger = LoggerFactory.getLogger(XMLParser.class);
	
	private InputStream in = null;
	private XMLEventReader eventReader = null;
	protected Boolean status;
	
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
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				if (event.isStartElement()) {
					level += 1;
					StartElement startElement = event.asStartElement();
					if (startElement.getName().getLocalPart() == (ARTIST) && level == 2) {
						art = new Artist();
						System.out.println(level);
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(NAME)) {
						event = eventReader.nextEvent();
						art.setName(getEvent(event));
						System.out.println(getEvent(event));
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(MUSICBRAINZARTISTID) && level == 3) {
						event = eventReader.nextEvent();
						art.setMusicBrainzArtistID(getEvent(event));
						System.out.println(getEvent(event));
						continue;
					}
				}
				
				// If we reach the end of an item element we add it to the list
				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart() == (ARTIST) && level == 2) {
						System.out.println(level);
						em.persist(art);
						artists.add(art);
						System.out.println("Persisted!!!");
					}
					level -= 1;
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occured2" + e.toString());
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

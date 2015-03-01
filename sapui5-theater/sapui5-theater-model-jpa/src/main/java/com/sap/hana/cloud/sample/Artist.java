package com.sap.hana.cloud.sample;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
@NamedQuery(name = "AllArtists", query = "select a from Artist a")
//public class Artist implements Serializable {
public class Artist {

	private static final long serialVersionUID = 1L;

	public Artist() {
	}

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String musicBrainzArtistID;
	@OneToMany(mappedBy="artist")
	private Collection<Album> albums;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String param) {
		this.name = param;
	}

	public String getMusicBrainzArtistID() {
		return musicBrainzArtistID;
	}

	public void setMusicBrainzArtistID(String param) {
		this.musicBrainzArtistID = param;
	}
	
	public Collection<Album> getAlbums() {
		return albums;
	}

	public void addAlbum(Album param) {
		if (!this.albums.contains(param)) {
			this.albums.add(param);
		}
	}

}

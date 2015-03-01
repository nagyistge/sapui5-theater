package com.sap.hana.cloud.sample;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.*;

@Entity
@NamedQuery(name = "AllArtists", query = "select a from Artist a")
//public class Artist implements Serializable {
public class Artist {

	private static final long serialVersionUID = 1L;

	public Artist() {
		this.albums = new ArrayList<Album>();
	}

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String musicBrainzArtistID;
	@OneToMany(mappedBy="artist", fetch = FetchType.EAGER)
	private List<Album> albums;
	
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
	
	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbum(List<Album> param) {
		this.albums = param;
	}

}

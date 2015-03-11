package com.sapui5theater.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name = "AllStyles", query = "select m from Mood m")
public class Style {

	public Style() {
		this.artists = new ArrayList<Artist>();
		this.albums = new ArrayList<Album>();		
	}

	@Id
	@GeneratedValue
	@Column(name = "STYLE_ID")
	private long styleId;
	private String style;
	@ManyToMany(mappedBy="styles", fetch = FetchType.EAGER)
	private List<Artist> artists;
	@ManyToMany(mappedBy="styles", fetch = FetchType.EAGER)
	private List<Album> albums;

	public long getStyleId() {
		return styleId;
	}

	public void setStyleId(long styleId) {
		this.styleId = styleId;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String param) {
		this.style = param;
	}

	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> param) {
		this.artists = param;
	}
	
	public void addArtist(Artist param) {
		this.artists.add(param);
	}
	
	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> param) {
		this.albums = param;
	}
	
	public void addAlbum(Album param) {
		this.albums.add(param);
	}
	
}
package com.sapui5theater.model;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.*;

@Entity
@NamedQuery(name = "AllArtists", query = "select ar from Artist ar")
//public class Artist implements Serializable {
public class Artist {

	private static final long serialVersionUID = 1L;

	public Artist() {
		this.albums = new ArrayList<Album>();
		this.styles = new ArrayList<Style>();
	}

	//TODO: change the key numbering
	@Id
	@GeneratedValue
	@Column(name = "ARTIST_ID")
	private long artistId;
	private String name;
	private String musicBrainzArtistID;
	@OneToMany(mappedBy = "artist", fetch = FetchType.EAGER)
	private List<Album> albums;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GENRE", referencedColumnName = "GENRE_ID")
	private Genre genre;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		      name="ARTIST_STYLE",
		      joinColumns={@JoinColumn(name="ARTIST_ID", referencedColumnName="ARTIST_ID")},
		      inverseJoinColumns={@JoinColumn(name="STYLE_ID", referencedColumnName="STYLE_ID")})
	private List<Style> styles;
	
	public long getArtistId() {
		return artistId;
	}

	public void setArtistId(long artistId) {
		this.artistId = artistId;
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

	public void setAlbums(List<Album> param) {
		this.albums = param;
	}
	
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre param) {
		this.genre = param;
	}
	
	public List<Style> getStyles() {
		return styles;
	}

	public void setStyles(List<Style> param) {
		this.styles = param;
	}
	
	public void addStyle(Style param) {
		this.styles.add(param);
	}

}

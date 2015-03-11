package com.sapui5theater.model;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.*;

@Entity
@NamedQuery(name = "AllArtists", query = "select ar from Artist ar")
//public class Artist implements Serializable {
public class Artist {

	public Artist() {
		this.styles = new ArrayList<Style>();
		this.moods = new ArrayList<Mood>();
		this.albums = new ArrayList<Album>();
	}

	//TODO: change the key numbering
	@Id
	@GeneratedValue
	@Column(name = "ARTIST_ID")
	private long artistId;
	private String name;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GENRE", referencedColumnName = "GENRE_ID")
	private Genre genre;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		      name="ARTIST_STYLE",
		      joinColumns={@JoinColumn(name="ARTIST_ID", referencedColumnName="ARTIST_ID")},
		      inverseJoinColumns={@JoinColumn(name="STYLE_ID", referencedColumnName="STYLE_ID")})
	private List<Style> styles;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		      name="ARTIST_MOOD",
		      joinColumns={@JoinColumn(name="ARTIST_ID", referencedColumnName="ARTIST_ID")},
		      inverseJoinColumns={@JoinColumn(name="MOOD_ID", referencedColumnName="MOOD_ID")})
	private List<Mood> moods;
	private String musicBrainzArtistID;
	private String yearsActive;
	private String biography;
	private String bornInfo;
	private Boolean died;
	private String bandFormed;	
	private Boolean bandDisbanded;
	private String thumbURL;
	@OneToMany(mappedBy = "artist", fetch = FetchType.EAGER)
	private List<Album> albums;
	
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
	
	public List<Mood> getMoods() {
		return moods;
	}

	public void setMoods(List<Mood> param) {
		this.moods = param;
	}
	
	public void addMood(Mood param) {
		this.moods.add(param);
	}
	
	public String getMusicBrainzArtistID() {
		return musicBrainzArtistID;
	}

	public void setMusicBrainzArtistID(String param) {
		this.musicBrainzArtistID = param;
	}
	
	public String getYearsActive() {
		return yearsActive;
	}

	public void setYearsActive(String param) {
		this.yearsActive = param;
	}
	
	public String getBiography() {
		return biography;
	}

	public void setBiography(String param) {
		this.biography = param;
	}
	
	public String getBornInfo() {
		return bornInfo;
	}

	public void setBornInfo(String param) {
		this.bornInfo = param;
	}
	
	public Boolean getDied() {
		return died;
	}

	public void setDied(Boolean param) {
		this.died = param;
	}
	
	public String getBandFormed() {
		return bandFormed;
	}

	public void setBandFormed(String param) {
		this.bandFormed = param;
	}
	
	public Boolean getBandDisbanded() {
		return bandDisbanded;
	}

	public void setBandDisbanded(Boolean param) {
		this.bandDisbanded = param;
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
	
	public String getThumbURL() {
		return thumbURL;
	}

	public void setThumbURL(String param) {
		this.thumbURL = param;
	}

}

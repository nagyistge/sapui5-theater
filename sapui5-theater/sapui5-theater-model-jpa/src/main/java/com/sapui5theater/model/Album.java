package com.sapui5theater.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name = "AllAlbums", query = "select al from Album al")
//public class Album implements Serializable {
public class Album {

	public Album() {
		this.styles = new ArrayList<Style>();
		this.moods = new ArrayList<Mood>();
		this.themes = new ArrayList<Theme>();
		this.tracks = new ArrayList<Track>();
	}

	@Id
	@GeneratedValue
	@Column(name = "ALBUM_ID")
	private long albumId;
	private String title;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ARTIST", referencedColumnName = "ARTIST_ID")
	private Artist artist;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GENRE", referencedColumnName = "GENRE_ID")
	private Genre genre;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		      name="ALBUM_STYLE",
		      joinColumns={@JoinColumn(name="ALBUM_ID", referencedColumnName="ALBUM_ID")},
		      inverseJoinColumns={@JoinColumn(name="STYLE_ID", referencedColumnName="STYLE_ID")})
	private List<Style> styles;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		      name="ALBUM_MOOD",
		      joinColumns={@JoinColumn(name="ALBUM_ID", referencedColumnName="ALBUM_ID")},
		      inverseJoinColumns={@JoinColumn(name="MOOD_ID", referencedColumnName="MOOD_ID")})
	private List<Mood> moods;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		      name="ALBUM_THEME",
		      joinColumns={@JoinColumn(name="ALBUM_ID", referencedColumnName="ALBUM_ID")},
		      inverseJoinColumns={@JoinColumn(name="THEME_ID", referencedColumnName="THEME_ID")})
	private List<Theme> themes;
	private String musicBrainzAlbumID;
	private Boolean compilation;
	private String review;
	private int yearRelease;
	private String label;
	private int rating;
	private String thumbURL;
	@OneToMany(mappedBy = "album", fetch = FetchType.EAGER)
	private List<Track> tracks;

	public long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(long albumId) {
		this.albumId = albumId;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String param) {
		this.title = param;
	}
	
	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist param) {
		this.artist = param;
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
	
	public List<Theme> getThemes() {
		return themes;
	}

	public void setThemes(List<Theme> param) {
		this.themes = param;
	}
	
	public void addTheme(Theme param) {
		this.themes.add(param);
	}	
	
	public String getMusicBrainzAlbumID() {
		return musicBrainzAlbumID;
	}

	public void setMusicBrainzAlbumID(String param) {
		this.musicBrainzAlbumID = param;
	}

	public Boolean getCompilation() {
		return compilation;
	}

	public void setCompilation(Boolean param) {
		this.compilation = param;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String param) {
		this.review = param;
	}
	
	public int getYearRelease() {
		return yearRelease;
	}

	public void setYearRelease(int param) {
		this.yearRelease = param;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String param) {
		this.label = param;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int param) {
		this.rating = param;
	}
	
	public String getThumbURL() {
		return thumbURL;
	}

	public void setThumbURL(String param) {
		this.thumbURL = param;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> param) {
		this.tracks = param;
	}
	
	public void addTrack(Track param) {
		this.tracks.add(param);
	}
	
}
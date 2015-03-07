package com.sapui5theater.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@NamedQuery(name = "AllAlbums", query = "select al from Album al")
//public class Album implements Serializable {
public class Album {

	private static final long serialVersionUID = 1L;

	public Album() {
	}

	@Id
	@GeneratedValue
	@Column(name = "ALBUM_ID")
	private long albumId;
	private String title;
	private String musicBrainzAlbumID;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ARTIST", referencedColumnName = "ARTIST_ID")
	private Artist artist;
	private Boolean compilation;
	private String review;
	private String label;
	private int rating;
	private String yearRelease;

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

	public String getMusicBrainzAlbumID() {
		return musicBrainzAlbumID;
	}

	public void setMusicBrainzAlbumID(String param) {
		this.musicBrainzAlbumID = param;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist param) {
		this.artist = param;
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

	public String getYearRelease() {
		return yearRelease;
	}

	public void setYearRelease(String param) {
		this.yearRelease = param;
	}

}
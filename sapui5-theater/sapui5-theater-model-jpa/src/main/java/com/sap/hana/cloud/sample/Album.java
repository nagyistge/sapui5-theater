package com.sap.hana.cloud.sample;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQuery(name = "AllAlbums", query = "select a from Album a")
public class Album implements Serializable {

	private static final long serialVersionUID = 1L;

	public Album() {
	}

	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String musicBrainzAlbumID;
	private Artist artist;
	private String compilation;
	private String review;
	private String label;
	private String rating;
	private String yearRelease;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	@ManyToOne
	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist param) {
		this.artist = param;
	}

	public String getCompilation() {
		return compilation;
	}

	public void setCompilation(String param) {
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

	public String getRating() {
		return rating;
	}

	public void setRating(String param) {
		this.rating = param;
	}

	public String getYearRelease() {
		return yearRelease;
	}

	public void setYearRelease(String param) {
		this.yearRelease = param;
	}

}
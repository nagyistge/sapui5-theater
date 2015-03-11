package com.sapui5theater.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name = "AllMoods", query = "select m from Mood m")
public class Mood {

	public Mood() {
		this.artists = new ArrayList<Artist>();
		this.albums = new ArrayList<Album>();
	}

	@Id
	@GeneratedValue
	@Column(name = "MOOD_ID")
	private long moodId;
	private String mood;
	@ManyToMany(mappedBy="moods", fetch = FetchType.EAGER)
	private List<Artist> artists;
	@ManyToMany(mappedBy="moods", fetch = FetchType.EAGER)
	private List<Album> albums;

	public long getMoodId() {
		return moodId;
	}

	public void setMoodId(long moodId) {
		this.moodId = moodId;
	}

	public String getMood() {
		return mood;
	}

	public void setMood(String param) {
		this.mood = param;
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
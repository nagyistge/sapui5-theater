package com.sapui5theater.model;

import javax.persistence.*;

@Entity
@NamedQuery(name = "AllTracks", query = "select tr from Track tr")
public class Track {

	public Track() {
	}

	@Id
	@GeneratedValue
	@Column(name = "TRACK_ID")
	private long trackId;
	private String title;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ALBUM", referencedColumnName = "ALBUM_ID")
	private Album album;
	private int position;
	private int duration;

	public long getTrackId() {
		return trackId;
	}

	public void setTrackId(long trackId) {
		this.trackId = trackId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String param) {
		this.title = param;
	}
	
	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album param) {
		this.album = param;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int param) {
		this.position = param;
	}
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int param) {
		this.duration = param;
	}
	
}
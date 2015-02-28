package com.sap.hana.cloud.sample;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQuery(name = "AllAlbums", query = "select a from Album a")
public class Track implements Serializable {

	private static final long serialVersionUID = 1L;

	public Track() {
	}

	@Id
	@GeneratedValue
	private long id;
	private String title;
	private int position;
	private int duration;

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
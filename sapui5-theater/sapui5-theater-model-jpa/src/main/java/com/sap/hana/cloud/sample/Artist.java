package com.sap.hana.cloud.sample;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQuery(name = "AllArtists", query = "select a from Artist a")
public class Artist implements Serializable {

	private static final long serialVersionUID = 1L;

	public Artist() {
	}

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String musicBrainzArtistID;
	
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

}

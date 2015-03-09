package com.sapui5theater.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name = "AllStyles", query = "select m from Mood m")
public class Style {

	public Style() {
		this.artists = new ArrayList<Artist>();
	}

	@Id
	@GeneratedValue
	@Column(name = "STYLE_ID")
	private long styleId;
	private String style;
	@ManyToMany(mappedBy="styles", fetch = FetchType.EAGER)
	private List<Artist> artists;

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
	
}
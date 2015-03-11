package com.sapui5theater.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name = "AllThemes", query = "select t from Theme t")
public class Theme {

	public Theme() {
		this.albums = new ArrayList<Album>();
	}

	@Id
	@GeneratedValue
	@Column(name = "THEME_ID")
	private long themeId;
	private String theme;
	@ManyToMany(mappedBy="themes", fetch = FetchType.EAGER)
	private List<Album> albums;

	public long getThemeId() {
		return themeId;
	}

	public void setThemeId(long themeId) {
		this.themeId = themeId;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String param) {
		this.theme = param;
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
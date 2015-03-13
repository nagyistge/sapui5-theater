package com.sapui5theater.model;

import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name = "AllAppUsers", query = "select au from AppUser au")
public class AppUser {

	public AppUser() {
	}

	@Id
	@Column(name = "USER_ID")
	private String userId;
	
	private String kodiIP;
	
	private int kodiPort;
	
	private String kodiUser;
	
	private String kodiPassword;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		      name="USER_ALBUM",
		      joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="USER_ID")},
		      inverseJoinColumns={@JoinColumn(name="ALBUM_ID", referencedColumnName="ALBUM_ID")})
	private List<Album> albums;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getKodiIP() {
		return kodiIP;
	}

	public void setKodiIP(String kodiIP) {
		this.kodiIP = kodiIP;
	}
	
	public int getKodiPort() {
		return kodiPort;
	}

	public void setKodiPort(int kodiPort) {
		this.kodiPort = kodiPort;
	}
	
	public String getKodiUser() {
		return kodiUser;
	}

	public void setKodiUser(String kodiUser) {
		this.kodiUser = kodiUser;
	}
	
	public String getKodiPassword() {
		return kodiPassword;
	}

	public void setKodiPassword(String kodiPassword) {
		this.kodiPassword = kodiPassword;
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
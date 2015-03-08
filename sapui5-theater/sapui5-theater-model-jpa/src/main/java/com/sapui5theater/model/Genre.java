package com.sapui5theater.model;

import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name = "AllGenres", query = "select g from Genre g")
public class Genre {

	public Genre() {
	}

	@Id
	@GeneratedValue
	@Column(name = "GENRE_ID")
	private long genreId;
	
	private String genre;
	@OneToMany(mappedBy = "genre", fetch = FetchType.EAGER)
	private List<Artist> artists;
	@OneToMany(mappedBy = "genre", fetch = FetchType.EAGER)
	private List<Album> albums;

	public long getGenreId() {
		return genreId;
	}

	public void setGenreId(long genreId) {
		this.genreId = genreId;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String param) {
		this.genre = param;
	}
	
	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> param) {
		this.artists = param;
	}
	
	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> param) {
		this.albums = param;
	}

}
package com.sapui5theater.model;

import javax.persistence.*;

@Entity
@NamedQuery(name = "AllGenres", query = "select g from Genre g")
public class Genre {

	public Genre() {
	}

	@Id
	@GeneratedValue
	private long genreId;
	private String genre;

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

}
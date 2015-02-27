package com.sap.hana.cloud.sample;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQuery(name = "AllMoods", query = "select a from Mood a")
public class Mood implements Serializable {

	private static final long serialVersionUID = 1L;

	public Mood() {
	}

	@Id
	@GeneratedValue
	private long id;
	private String mood;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMood() {
		return mood;
	}

	public void setMood(String param) {
		this.mood = param;
	}

}
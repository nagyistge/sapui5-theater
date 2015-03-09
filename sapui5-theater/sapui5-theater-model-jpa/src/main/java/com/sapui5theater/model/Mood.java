package com.sapui5theater.model;

import javax.persistence.*;

@Entity
@NamedQuery(name = "AllMoods", query = "select m from Mood m")
public class Mood {

	public Mood() {
	}

	@Id
	@GeneratedValue
	private long moodId;
	private String mood;

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

}
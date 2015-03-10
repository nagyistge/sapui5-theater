package com.sapui5theater.model;

import javax.persistence.*;

@Entity
@NamedQuery(name = "AllThemes", query = "select t from Theme t")
public class Theme {

	public Theme() {
	}

	@Id
	@GeneratedValue
	@Column(name = "THEME_ID")
	private long themeId;
	private String theme;

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

}
package com.sap.hana.cloud.sample;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQuery(name = "AllThemes", query = "select a from Theme a")
public class Theme implements Serializable {

	private static final long serialVersionUID = 1L;

	public Theme() {
	}

	@Id
	@GeneratedValue
	private long id;
	private String theme;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String param) {
		this.theme = param;
	}

}
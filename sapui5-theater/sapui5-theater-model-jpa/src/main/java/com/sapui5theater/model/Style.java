package com.sapui5theater.model;

import javax.persistence.*;

@Entity
@NamedQuery(name = "AllStyles", query = "select m from Mood m")
public class Style {

	public Style() {
	}

	@Id
	@GeneratedValue
	private long styleId;
	private String style;

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

}
package com.sap.hana.cloud.sample.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataLoader {
	
	private static Logger logger = LoggerFactory.getLogger(DataLoader.class);
	
	public void loadArtists() {
		logger.info("Yop yop");
	}
	
	public void loadData() {
		loadArtists();
		logger.info("Yop");
	}

}

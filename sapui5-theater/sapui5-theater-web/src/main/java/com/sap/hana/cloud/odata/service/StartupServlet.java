package com.sap.hana.cloud.odata.service;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.sap.hana.cloud.sample.data.DataLoader;

public class StartupServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static EntityManagerFactory emf;
	
	@Override
	public void init() throws ServletException {
		try {
			emf = JpaEntityManagerFactory.getEntityManagerFactory();
			DataLoader loader = new DataLoader(emf);
			loader.loadData();
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/*
	 * Closes the JPA entity manager factory.
	 */
	@Override
	public void destroy() {
		emf.close();
	}

}

package org.oregami.data;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.oregami.entities.Website;

import javax.persistence.EntityManager;

public class WebsiteDao extends GenericDAOUUIDImpl<Website, String>{

	@Inject
	public WebsiteDao(Provider<EntityManager> emf) {
		super(emf);
		entityClass=Website.class;
	}


}

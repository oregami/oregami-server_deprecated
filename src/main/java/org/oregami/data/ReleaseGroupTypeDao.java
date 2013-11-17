package org.oregami.data;

import javax.persistence.EntityManager;

import org.oregami.entities.ReleaseGroupType;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class ReleaseGroupTypeDao extends GenericDAOImpl<ReleaseGroupType, Long>{

    @Inject
    public ReleaseGroupTypeDao(Provider<EntityManager> emf) {
        super(emf);
        entityClass=ReleaseGroupType.class;
    }
    
    
    @SuppressWarnings("unchecked")
    public ReleaseGroupType findByName(String name) {
        ReleaseGroupType type = (ReleaseGroupType)getEntityManager()
                .createQuery("SELECT t FROM ReleaseGroupType t where t.name = '" + name + "'").getSingleResult(); 
        return type;
    }


}
package org.oregami.data;

import org.oregami.entities.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GameDao extends GenericDAOUUIDImpl<Game, String> {

	@Autowired
	public GameDao(EntityManager em) {
		super(em);
		entityClass=Game.class;
	}
	
	
    @SuppressWarnings("unchecked")
	public List<Game> findByName(String name) {
        List<Game> games = getEntityManager()
        		.createNativeQuery("SELECT * FROM Game g, GameTitle t where g.id=t.GameId and lower(t.title) like '%" + name.toLowerCase() + "%'", Game.class).getResultList();
        return games;
    }


}
package ro.tif.persistence.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ro.tif.persistence.dao.impl.LeagueDAOImpl;
import ro.tif.persistence.db.League;
import ro.tif.persistence.db.Team;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-test.xml")
public class LeagueTest {

	@Autowired
	LeagueDAOImpl leagueDAO;
	
	@PersistenceContext
	EntityManager em;
	
	@Rollback(false)
	@Test
	public void dummyTest(){
		//League newLeague = new League.Builder("1").withName("Team1").withDType("tye").withSport("Sport").build();
//		leagueDAO.findWithQuery(League.class, "SELECT l FROM League l WHERE l.id=:id AND l.name=:name AND l.sport=:sport" , "2","t","yy");
//		System.out.println(leagueDAO.getById("2").getName());
		
		Query query = em.createQuery("Select t from Team t JOIN t.players p WHERE p.id=:playerId", Team.class);
    	query.setParameter("playerId", "1");
    	for(Team t : (List<Team>)query.getResultList()){
    		System.out.println("team -" + t.getLeague().getId());
    	}
//		League newLeague = new League.Builder("1").withName("Team1").withDType("tye").withSport("Sport").build();
//		em.persist(newLeague);
//		em.flush();
	}
}

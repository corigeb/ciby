package ro.tif.persistence.dao.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;

import ro.tif.persistence.dao.LeagueDAO;
import ro.tif.persistence.db.League;

public class LeagueDAOImpl extends GenericDAOImpl<League, String> implements LeagueDAO{

	public LeagueDAOImpl() {
		super(League.class);
	}
	
	public LeagueDAOImpl(EntityManager em) {
		super(em, League.class);
	}

	public void test(){
		List<String> colors = Arrays.asList("red", "green", "blue");
		Collections.sort(colors, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return /* -> */ o1.compareTo(o2);
			}
		});
		
		Collections.sort(colors, (p1,  p2) -> p2.compareTo(p1));
		Collections.sort(colors, (c1, c2) -> c1.compareTo(c2));
	}
}

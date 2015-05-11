/**
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package ro.tif.ejb.commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateful;

import ro.tif.persistence.db.Player;

/**
 * This is the bean class for the RequestBean enterprise bean.
 *
 * @author ian
 */
@Stateful
public class RequestBean implements Request, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger("roster.request.RequestBean");
//	@PersistenceContext
//	private EntityManager em;
	@Override
	public List<Player> getPlayers() {
		// TODO Auto-generated method stub
		List<Player> mock = new ArrayList<Player>();
		Player player1 = new Player("1", "Corina", "Tenismena", 78800.0);
		Player player2 = new Player("2", "Cristina", "Handbalista", 780.34);
		mock.add(player1);
		mock.add(player2);
		return mock;
	}

//	@Override
//	public void createPlayer(String id, String name, String position,
//			double salary) {
//		logger.info("createPlayer");
//		try {
//			Player player = new Player(id, name, position, salary);
//			em.persist(player);
//		} catch (Exception ex) {
//			throw new EJBException(ex);
//		}
//	}
//
//	@Override
//	public void addPlayer(String playerId, String teamId) {
//		logger.info("addPlayer");
//		try {
//			Player player = em.find(Player.class, playerId);
//			Team team = em.find(Team.class, teamId);
//
//			team.addPlayer(player);
//			player.addTeam(team);
//		} catch (Exception ex) {
//			throw new EJBException(ex);
//		}
//	}
//
//	@Override
//	public void removePlayer(String playerId) {
//		logger.info("removePlayer");
//		try {
//			Player player = em.find(Player.class, playerId);
//
//			Collection<Team> teams = player.getTeams();
//			Iterator<Team> i = teams.iterator();
//			while (i.hasNext()) {
//				Team team = i.next();
//				team.dropPlayer(player);
//			}
//
//			em.remove(player);
//		} catch (Exception ex) {
//			throw new EJBException(ex);
//		}
//	}
//
//	@Override
//	public void dropPlayer(String playerId, String teamId) {
//		logger.info("dropPlayer");
//		try {
//			Player player = em.find(Player.class, playerId);
//			Team team = em.find(Team.class, teamId);
//
//			team.dropPlayer(player);
//			player.dropTeam(team);
//		} catch (Exception ex) {
//			throw new EJBException(ex);
//		}
//	}
//
//	@Override
//	public Player getPlayer(String playerId) {
//		logger.info("getPlayerDetails");
//		try {
//			return em.find(Player.class, playerId);
//		} catch (Exception ex) {
//			throw new EJBException(ex);
//		}
//	}
//
//	@Override
//	public List<Player> getPlayersOfTeam(String teamId) {
//		logger.info("getPlayersOfTeam");
//		try {
//			Team team = em.find(Team.class, teamId);
//			return new ArrayList<Player>(team.getPlayers());
//		} catch (Exception ex) {
//			throw new EJBException(ex);
//		}
//	}
//
//	@Override
//	public List<Team> getTeamsOfLeague(String leagueId) {
//		logger.info("getTeamsOfLeague");
//
//		try {
//			Query query = em
//					.createQuery(
//							"Select t from Team t LEFT JOIN t.league l WHERE l.id=:leagueId",
//							Team.class);
//			query.setParameter("leagueId", leagueId);
//			return (List<Team>) query.getResultList();
//
//		} catch (Exception ex) {
//			throw new EJBException(ex);
//		}
//
//	}
//
//	@Override
//	public List<Player> getAllPlayers() {
//		logger.info("getAllPlayers");
//		List<Player> players = null;
//
//		try {
//			Query query = em.createQuery("Select p from Player p ",
//					Player.class);
//			return (List<Player>) query.getResultList();
//		} catch (Exception ex) {
//			throw new EJBException(ex);
//		}
//	}
//
//	@Override
//	public List<League> getLeaguesOfPlayer(String playerId) {
//		List<League> leagues = new ArrayList<League>();
//		Query query = em.createQuery(
//				"Select t from Team t JOIN t.players p WHERE p.id=:playerId",
//				Team.class);
//		query.setParameter("playerId", "1");
//		List<Team> teams = (List<Team>) query.getResultList();
//		for (Team team : teams) {
//			leagues.add(team.getLeague());
//		}
//		return leagues;
//
//	}
//
//	@Override
//	public List<String> getSportsOfPlayer(String playerId) {
//		List<String> sports = new ArrayList<String>();
//		List<League> leagues = getLeaguesOfPlayer(playerId);
//		if (leagues != null && !leagues.isEmpty()) {
//			for (League league : leagues) {
//				sports.add(league.getSport());
//			}
//		}
//		return sports;
//	}
//
//	@Override
//	public void removeTeam(String teamId) {
//		logger.info("removeTeam");
//		try {
//			Team team = em.find(Team.class, teamId);
//
//			Collection<Player> players = team.getPlayers();
//			Iterator<Player> i = players.iterator();
//			while (i.hasNext()) {
//				Player player = (Player) i.next();
//				player.dropTeam(team);
//			}
//
//			em.remove(team);
//		} catch (Exception ex) {
//			throw new EJBException(ex);
//		}
//	}
//
//	@Override
//	public Team getTeam(String teamId) {
//		logger.info("getTeam");
//
//		try {
//			return em.find(Team.class, teamId);
//		} catch (Exception ex) {
//			throw new EJBException(ex);
//		}
//	}
//
//	@Override
//	public void removeLeague(String leagueId) {
//		logger.info("removeLeague");
//		try {
//			League league = em.find(League.class, leagueId);
//			em.remove(league);
//		} catch (Exception ex) {
//			throw new EJBException(ex);
//		}
//	}
//
//	@Override
//	public League getLeague(String leagueId) {
//		logger.info("getLeague");
//
//		try {
//			return em.find(League.class, leagueId);
//		} catch (Exception ex) {
//			throw new EJBException(ex);
//		}
//	}
//
//	@Override
//	public void createLeague(League leagueDetails) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void createTeamInLeague(Team teamDetails, String leagueId) {
//		// TODO Auto-generated method stub
//
//	}
}

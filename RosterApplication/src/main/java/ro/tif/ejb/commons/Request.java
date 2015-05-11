package ro.tif.ejb.commons;

import java.util.List;

import javax.ejb.Remote;

import ro.tif.persistence.db.Player;

@Remote
public interface Request {
	
	List<Player>  getPlayers();
	
	
//	void addPlayer(String playerId, String teamId);
//
//	void createLeague(League leagueDetails);
//
//	void createPlayer(String id, String name, String position, double salary);
//
//	void createTeamInLeague(Team teamDetails, String leagueId);
//
//	void dropPlayer(String playerId, String teamId);
//
//	List<Player> getAllPlayers();
//
//	League getLeague(String leagueId);
//
//	List<League> getLeaguesOfPlayer(String playerId);
//
//	Player getPlayer(String playerId);
//
//	List<Player> getPlayersOfTeam(String teamId);
//
//	List<String> getSportsOfPlayer(String playerId);
//
//	Team getTeam(String teamId);
//
//	List<Team> getTeamsOfLeague(String leagueId);
//
//	void removeLeague(String leagueId);
//
//	void removePlayer(String playerId);
//
//	void removeTeam(String teamId);

}

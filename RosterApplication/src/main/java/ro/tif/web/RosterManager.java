package ro.tif.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ro.tif.persistence.db.Player;

@ManagedBean
@SessionScoped
public class RosterManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1053606336240625173L;

	@EJB
	private ro.tif.ejb.commons.Request request;

	private String playerId;
	private Player player;
	private List<Player> players;

	public List<Player> getAllPlayers() {
		this.players = request.getPlayers();
		return players;
	}

	public void setCurrentPlayer(String playerId) {
		this.playerId = playerId;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	@PostConstruct
	public void init(){
		getAllPlayers();
	}
	
}

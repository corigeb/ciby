package ro.tif.persistence.db;

import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.Collection;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TEAM")
public class Team implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3366465986396389102L;

	@Column(name = "ID")
	@Id
	private String id;

	@Column(name = "CITY")
	private String city;

	@Column(name = "NAME")
	private String name;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "LEAGUE_ID", referencedColumnName = "ID", insertable = false, updatable = false)
	private League league;

	@ManyToMany
	@JoinTable(name = "TEAM_PLAYER", joinColumns = @JoinColumn(name = "TEAM_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "PLAYER_ID", referencedColumnName = "ID"))
	private Collection<Player> players;

	public Team() {

	}

	public Team(String id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	public Collection<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Collection<Player> players) {
		this.players = players;
	}

	public void addPlayer(Player player) {
		this.getPlayers().add(player);
	}

	public void dropPlayer(Player player) {
		this.getPlayers().remove(player);
	}
}

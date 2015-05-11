package ro.tif.persistence.db;

import java.io.Serializable;
import java.util.Collection;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PLAYER")
public class Player implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1611664977084948349L;

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "POSITION")
	private String position;

	@Column(name = "SALARY")
	private double salary;

	@ManyToMany(mappedBy = "players")
	Collection<Team> teams;

	public Player() {
	}

	public Player(String id, String name, String position, double salary) {
		this.id = id;
		this.name = name;
		this.position = position;
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Collection<Team> getTeams() {
		return teams;
	}

	public void setTeams(Collection<Team> teams) {
		this.teams = teams;
	}

	public void addTeam(Team team) {
		this.getTeams().add(team);
	}

	public void dropTeam(Team team) {
		this.getTeams().remove(team);
	}

}

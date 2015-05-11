package ro.tif.persistence.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author Corina
 * 
 */
@Entity
@Table(name = "LEAGUE")
public class League implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "ID")
	@Id
	private String id;

	@Column(name = "DTYPE")
	private String dType;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SPORT")
	private String sport;

	public League(){
		
	}
	private League(Builder builder) {
		this.id = builder.id;
		this.dType = builder.dType;
		this.name = builder.name;
		this.sport = builder.sport;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getdType() {
		return dType;
	}

	public void setdType(String dType) {
		this.dType = dType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public static class Builder {

		private String id;
		private String dType;
		private String name;
		private String sport;

		public Builder(String id) {
			this.id = id;
		}

		public League build() {
			return new League(this);
		}

		public Builder withDType(String dType) {
			this.dType = dType;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withSport(String sport) {
			this.sport = sport;
			return this;
		}

	}
}

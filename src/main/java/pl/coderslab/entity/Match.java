package pl.coderslab.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="matches")
public class Match {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@ManyToOne(cascade=CascadeType.ALL)
	private Team team1;
	@ManyToOne(cascade=CascadeType.ALL)
	private Team team2;
	private int team1Goals;
	private int team2Goals;
	
	public Match() {
	}
	
	public Match(Team team1, Team team2) {
		super();
		this.team1 = team1;
		this.team2 = team2;
	}



	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	public int getTeam1Goals() {
		return team1Goals;
	}

	public void setTeam1Goals(int team1Goals) {
		this.team1Goals = team1Goals;
	}

	public int getTeam2Goals() {
		return team2Goals;
	}

	public void setTeam2Goals(int team2Goals) {
		this.team2Goals = team2Goals;
	}
	
}

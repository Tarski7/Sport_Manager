package pl.coderslab.entity;

import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Team {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@NotNull(message = "Name can not be empty")
	private String name;
	private int matches = 0;
	private int wins = 0;
	private int draws = 0;
	private int losses = 0;
	private int goalsFor = 0;
	private int goalsAgainst = 0;
	private int goalsDifference = 0;
	private int points = 0;
	private int budget;
	
	@OneToMany(mappedBy = "team", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Player> players;
	
	@OneToMany(mappedBy = "team")
	private List<Worker> workers;
	
	//@Transient
	//private List<Player> first11;
	//@OneToMany
	//private Player[] first11;
	
	public Team() {
		Random r = new Random();
		setBudget(r.nextInt(10000000));
	}
	
	public Team(String name) {
		this.name = name;
		Random r = new Random();
		setBudget(r.nextInt(10000000));
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMatches() {
		return matches;
	}

	public void setMatches(int matches) {
		this.matches = matches;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getDraws() {
		return draws;
	}

	public void setDraws(int draws) {
		this.draws = draws;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getGoalsFor() {
		return goalsFor;
	}

	public void setGoalsFor(int goalsFor) {
		this.goalsFor = goalsFor;
	}

	public int getGoalsAgainst() {
		return goalsAgainst;
	}

	public void setGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}

	public int getGoalsDifference() {
		return goalsDifference;
	}

	public void setGoalsDifference(int goalsDifference) {
		this.goalsDifference = goalsDifference;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	/*public Player[] getFirst11() {
		return first11;
	}

	public void setFirst11(Player[] first11) {
		this.first11 = first11;
	}*/

	/*public List<Player> getFirst11() {
		return first11;
	}

	public void setFirst11(List<Player> first11) {
		this.first11 = first11;
	}*/
	
}

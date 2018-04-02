package pl.coderslab.model;

import java.util.ArrayList;
import java.util.List;

import pl.coderslab.entity.Match;

public class Round {
	private int roundNo;
	private List<Match> matches = new ArrayList<>();
	
	public Round() {
	}

	public Round(int roundNo) {
		super();
		this.roundNo = roundNo;
	}

	public int getRoundNo() {
		return roundNo;
	}

	public void setRoundNo(int roundNo) {
		this.roundNo = roundNo;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}
}

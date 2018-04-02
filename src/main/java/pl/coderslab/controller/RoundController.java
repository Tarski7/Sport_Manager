package pl.coderslab.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entity.Match;
import pl.coderslab.entity.Team;
import pl.coderslab.model.Round;
import pl.coderslab.repository.MatchRepository;
import pl.coderslab.repository.TeamRepository;

class Data {
	private int data;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
}
	
@Controller
@RequestMapping("/round")
public class RoundController {

	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	MatchRepository matchRepository;

	@ModelAttribute("schedule")
	public int[] schedule() {
		
		int[] rounds = new int[7];
		for (int i = 0; i < 7; i++) {
			rounds[i] = i+1;
		}	
		return rounds;
	}
	
	
	@GetMapping("/test")
	public String test(Model model) {
		Data dat = new Data();
		model.addAttribute(dat);
		return "schedule";
	}
	
	
	@PostMapping("/test")
	public String test2(@ModelAttribute Data dat, Model model) {
		
		List<Team> teamList = teamRepository.findAll();
		System.out.println(teamList.get(0).getName());
		int liczba = dat.getData();
		for (int i = 1; i < liczba; i++) {
			teamList.add(1, teamList.get(teamList.size()-1));
        	teamList.remove(teamList.size()-1); 
		}
		
		Round round = new Round(liczba);
		round.getMatches().add(new Match(teamList.get(0), teamList.get(1)));
		round.getMatches().add(new Match(teamList.get(2), teamList.get(3)));
		round.getMatches().add(new Match(teamList.get(4), teamList.get(5)));
		round.getMatches().add(new Match(teamList.get(6), teamList.get(7)));
		System.out.println(round.getMatches().get(0).getTeam1().getName());
		System.out.println(round.getMatches().get(0).getTeam2().getName());
		
		model.addAttribute(round);
		return "test";
	}
	
	@PostMapping("/test2")
	public String test22(@ModelAttribute Data dat, Model model) {
		List<Team> teamList = teamRepository.findAll();
		System.out.println(teamList.get(0).getName());
		int liczba = dat.getData();
		for (int i = 1; i < liczba; i++) {
			teamList.add(1, teamList.get(teamList.size()-1));
        	teamList.remove(teamList.size()-1); 
		}
		
		Round round = new Round(liczba);
		round.getMatches().add(new Match(teamList.get(0), teamList.get(1)));
		round.getMatches().add(new Match(teamList.get(2), teamList.get(3)));
		round.getMatches().add(new Match(teamList.get(4), teamList.get(5)));
		round.getMatches().add(new Match(teamList.get(6), teamList.get(7)));
		System.out.println(round.getMatches().get(0).getTeam1().getName());
		System.out.println(round.getMatches().get(0).getTeam2().getName());
		
		Random rand = new Random();
		int r = 0;
		round.getMatches().get(0).setTeam1Goals(rand.nextInt(6));
		round.getMatches().get(0).setTeam2Goals(rand.nextInt(6));
		round.getMatches().get(1).setTeam1Goals(rand.nextInt(6));
		round.getMatches().get(1).setTeam2Goals(rand.nextInt(6));
		round.getMatches().get(2).setTeam1Goals(rand.nextInt(6));
		round.getMatches().get(2).setTeam2Goals(rand.nextInt(6));
		round.getMatches().get(3).setTeam1Goals(rand.nextInt(6));
		round.getMatches().get(3).setTeam2Goals(rand.nextInt(6));
		
		model.addAttribute(round);
		return "test";
	}
	
	@PostMapping("/save")
	public String test2(@ModelAttribute Round round, Model model) {
	
		for (Match m : round.getMatches()) {

			Match match = new Match();
			match.setTeam1(m.getTeam1());
			match.setTeam2(m.getTeam2());
			match.setTeam1Goals(m.getTeam1Goals());
			match.setTeam2Goals(m.getTeam2Goals());
			
			Team team1 = teamRepository.findOne(m.getTeam1().getId());
			Team team2 = teamRepository.findOne(m.getTeam2().getId());
			
			
			int matches = team1.getMatches();
			int matches2 = team2.getMatches();
			int wins = team1.getWins();
			int wins2 = team2.getWins();
			int losses = team1.getLosses();
			int losses2 = team2.getLosses();
			int draws = team1.getDraws();
			int draws2 = team2.getDraws();
			int points = team1.getPoints();
			int points2 = team2.getPoints();
			int team1GFor = team1.getGoalsFor();
			int team1GAgainst = team1.getGoalsAgainst();
			int team1GDiff = team1.getGoalsDifference();
			int team2GFor = team2.getGoalsFor();
			int team2GAgainst = team2.getGoalsAgainst();
			int team2GDiff = team2.getGoalsDifference();
			
			int team1Goals = m.getTeam1Goals();
			int team2Goals = m.getTeam2Goals();
			team1.setGoalsFor(team1GFor + team1Goals);
			team1.setGoalsAgainst(team1GAgainst + team2Goals);
			team1.setGoalsDifference(team1GDiff + (team1Goals - team2Goals));
			team2.setGoalsFor(team2GFor + team2Goals);
			team2.setGoalsAgainst(team2GAgainst + team1Goals);
			team2.setGoalsDifference(team2GDiff + (team2Goals - team1Goals));
			
			if (team1Goals > team2Goals) {
				team1.setMatches(matches + 1);
				team1.setWins(wins + 1);
				team1.setPoints(points + 3);
				
				team2.setMatches(matches2 + 1);
				team2.setLosses(losses2 + 1);
			} else if (team2Goals > team1Goals) {
				team2.setMatches(matches2 + 1);
				team2.setWins(wins2 + 1);
				team2.setPoints(points2 + 3);
				
				team1.setMatches(matches + 1);
				team1.setLosses(losses + 1);
			} else {
				team1.setMatches(matches + 1);
				team1.setDraws(draws + 1);
				team1.setPoints(points + 1);

				team2.setMatches(matches2 + 1);
				team2.setDraws(draws2 + 1);
				team2.setPoints(points2 + 1);
			}
			
			teamRepository.save(team1);
			teamRepository.save(team2);
		}
		return "redirect:/team/table";
	}
	
	
	@ModelAttribute("teams")
	public List<Team> getTeams() {
		return teamRepository.findAll();
	}
}

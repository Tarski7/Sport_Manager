package pl.coderslab.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.entity.Player;
import pl.coderslab.entity.Team;
import pl.coderslab.entity.Worker;
import pl.coderslab.repository.PlayerRepository;
import pl.coderslab.repository.TeamRepository;
import pl.coderslab.repository.WorkerRepository;

@Controller
@RequestMapping("/team")
public class TeamController {

	@Autowired
	TeamRepository teamRepository;

	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	WorkerRepository workerRepository;
	
	//tabela
	@GetMapping("/table")
	public String table() {
		return "table";
	}
	
	//lista drużyn
	@GetMapping("/teams")
	public String teams(Model model) {
		List<Team> teams = teamRepository.findAll();
		model.addAttribute("teams", teams);
		return "teams";
	}
	
	//dodanie przykładowych drużyn
	@RequestMapping("/add")
	@ResponseBody
	public String addTeam() {
		Team team = new Team();
		team.setName("Team1");
		Team team2 = new Team();
		team2.setName("Team2");
		Team team3 = new Team();
		team3.setName("Team3");
		Team team4 = new Team();
		team4.setName("Team4");
		Team team5 = new Team();
		team5.setName("Team5");
		Team team6 = new Team();
		team6.setName("Team6");
		Team team7 = new Team();
		team7.setName("Team7");
		Team team8 = new Team();
		team8.setName("Team8");
		teamRepository.save(team);
		teamRepository.save(team2);
		teamRepository.save(team3);
		teamRepository.save(team4);
		teamRepository.save(team5);
		teamRepository.save(team6);
		teamRepository.save(team7);
		teamRepository.save(team8);
		return "Teams have been added!";
	}
	
	//Zawodnicy klubu
	@RequestMapping("/players/{id}")
	public String playerList(Model model, @PathVariable long id) {
		
		Team team = teamRepository.findOne(id);
		List<Player> players = playerRepository.findAllByTeamOrderByTShirtNumberAsc(team);
		model.addAttribute("players", players);
		return "playerList";
	}
	
	//Pracownicy klubu
	@RequestMapping("/workers/{id}")
	public String workerList(Model model, @PathVariable long id) {
		
		Team team = teamRepository.findOne(id);
		List<Worker> workers = workerRepository.findAllByTeam(team);
		model.addAttribute("workers", workers);
		return "workerList";
	}
	
	//Edycja drużyny - zmiana nazwy
	@GetMapping("/name/{id}")
	public String teamName(Model model, @PathVariable long id) {
		
		Team team = teamRepository.findOne(id);
		model.addAttribute("team", team);
		return "teamName";
	}
	
	@PostMapping("/name/{id}")
	public String newName(HttpServletRequest rq, Model model, @Valid @ModelAttribute Team team, BindingResult result) {
		Team newTeam = teamRepository.findOne(team.getId());
		newTeam.setName(team.getName());
		if(result.hasErrors()) {
    		return "teamName";
    	}

    	teamRepository.save(newTeam);
		return "redirect: "+ rq.getServletContext().getContextPath() +"/team/teams";
	}
	
	@GetMapping("/lineup/{id}")
	public String lineUp(Model model, @PathVariable long id) {
		
		Team team = teamRepository.findOne(id);
		List<Player> players = playerRepository.findAllByTeamOrderByTShirtNumberAsc(team);
		model.addAttribute("players", players);
		return "lineUp";
	}
	
	@ModelAttribute("teams")
	public List<Team> getTeams() {
		return teamRepository.findAllByOrderByPointsDescGoalsDifferenceDesc();
	}
	
}
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.entity.Player;
import pl.coderslab.entity.Team;
import pl.coderslab.repository.PlayerRepository;
import pl.coderslab.repository.TeamRepository;

@Controller
@RequestMapping("/player")
public class PlayerController {

	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	//lista zawodników
	@GetMapping("/players")
	public String table() {
		return "playerList";
	}
	
	@RequestMapping("/transfer")
	@ResponseBody
	public String transfer() {
		Player player = playerRepository.findOneById(5);
		player.setTeam(teamRepository.findOne(2L));
		playerRepository.save(player);
		return "Player has been transfered!";
	}
	
	//dodanie przykładowych zawodników
	@RequestMapping("/addAll")
	@ResponseBody
	public String addAll() {
		Player player = new Player();
		player.setFirstName("Papryk");
		player.setLastName("Vege");
		player.setNationality("Armenian");
		player.settShirtNumber(99);
		player.setTeam(teamRepository.findOne(1L));
		playerRepository.save(player);
		Player player2 = new Player();
		player2.setFirstName("Marek");
		player2.setLastName("Mostowiak");
		player2.setNationality("Polish");
		player2.settShirtNumber(10);
		player2.setTeam(teamRepository.findOne(1L));
		playerRepository.save(player2);
		Player player3 = new Player();
		player3.setFirstName("Robert");
		player3.setLastName("Kurwica");
		player3.setNationality("Polish");
		player3.settShirtNumber(9);
		player3.setTeam(teamRepository.findOne(1L));
		playerRepository.save(player3);
		Player player4 = new Player();
		player4.setFirstName("Tomek");
		player4.setLastName("Laskawiec");
		player4.setNationality("Russian");
		player4.settShirtNumber(5);
		player4.setTeam(teamRepository.findOne(1L));
		playerRepository.save(player4);
		Player player5 = new Player();
		player5.setFirstName("Andrzej");
		player5.setLastName("Duda");
		player5.setNationality("Polish");
		player5.settShirtNumber(1);
		player5.setTeam(teamRepository.findOne(1L));
		playerRepository.save(player5);
		return "Players have been added!";
	}
	
	//formularz do dodania zawodnika
	@GetMapping("/add")
	public String addPlayer(Model model) {
		Player player = new Player();
		model.addAttribute("player", player);
		return "playerForm";
	}
	
	@PostMapping("/add")
	public String addPlayerSave(HttpServletRequest rq, Model model, @Valid @ModelAttribute Player player, BindingResult result){
		
    	if(result.hasErrors()) {
    		return "playerForm";
    	}
    	
    	playerRepository.save(player);
		return "redirect: "+ rq.getServletContext().getContextPath() +"/player/players";	
	}
	
	@ModelAttribute("players")
	public List<Player> getPlayers() {
		return playerRepository.findAll();
	}
	
	@ModelAttribute("teams")
	public List<Team> getTeams() {
		return teamRepository.findAll();
	}
}

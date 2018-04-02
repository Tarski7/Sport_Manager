package pl.coderslab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entity.Player;
import pl.coderslab.entity.Team;
import pl.coderslab.repository.PlayerRepository;
import pl.coderslab.repository.TeamRepository;

@Controller
@RequestMapping("/market")
public class TransferMarketController {

	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@GetMapping("")
	public String transferMarket(Model model) {
		List<Player> players = playerRepository.findAll();
		model.addAttribute("players", players);
		return "transferMarket";
	}
	
	/*@PostMapping("")
	public String buyPlayer() {
		
	}*/
	
	@ModelAttribute("players")
	public List<Player> getPlayers() {
		return playerRepository.findAll();
	}
	
	@ModelAttribute("teams")
	public List<Team> getTeams() {
		return teamRepository.findAll();
	}
}

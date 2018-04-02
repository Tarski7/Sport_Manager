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

import pl.coderslab.entity.Team;
import pl.coderslab.entity.Worker;
import pl.coderslab.repository.TeamRepository;
import pl.coderslab.repository.WorkerRepository;

@Controller
@RequestMapping("/worker")
public class WorkerController {

	@Autowired
	private WorkerRepository workerRepository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	//lista pracowników
	@GetMapping("/workers")
	public String table() {
		return "workerList";
	}
	
	//dodanie przykładowych pracowników
	@RequestMapping("/addAll")
	@ResponseBody
	public String addAll() {
		Worker worker = new Worker();
		worker.setFirstName("dr");
		worker.setLastName("Oetker");
		worker.setNationality("Polish");
		worker.setPosition("Doctor");
		worker.setTeam(teamRepository.findOne(1L));
		workerRepository.save(worker);
		Worker worker2 = new Worker();
		worker2.setFirstName("Adam");
		worker2.setLastName("Nawalnica");
		worker2.setNationality("Polish");
		worker2.setPosition("Trainer");
		worker2.setTeam(teamRepository.findOne(1L));
		workerRepository.save(worker2);
		Worker worker3 = new Worker();
		worker3.setFirstName("Donald");
		worker3.setLastName("Tusk");
		worker3.setNationality("German");
		worker3.setPosition("Physiotherapist");
		worker3.setTeam(teamRepository.findOne(1L));
		workerRepository.save(worker3);
		return "Workers have been added!";
	}
	
	//formularz do dodania pracownika
	@GetMapping("/add")
	public String addWorker(Model model) {
		Worker worker = new Worker();
		model.addAttribute("worker", worker);
		return "workerForm";
	}
	
	@PostMapping("/add")
	public String addWorkerSave(HttpServletRequest rq, Model model, @Valid @ModelAttribute Worker worker, BindingResult result){
		
    	if(result.hasErrors()) {
    		return "workerForm";
    	}
    	
    	workerRepository.save(worker);
		return "redirect: "+ rq.getServletContext().getContextPath() +"/worker/workers";	
	}
	
	@ModelAttribute("workers")
	public List<Worker> getWorker() {
		return workerRepository.findAll();
	}
	
	@ModelAttribute("teams")
	public List<Team> getTeams() {
		return teamRepository.findAll();
	}
}

package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.Team;
import pl.coderslab.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

	List<Worker> findAllByTeam(Team team);
}

package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

	List<Team> findAllByOrderByPointsDesc();
}

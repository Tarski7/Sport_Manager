package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.Match;


public interface MatchRepository extends JpaRepository<Match, Long> {

	
}

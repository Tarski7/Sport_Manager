package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.Player;
import pl.coderslab.entity.Team;

public interface PlayerRepository extends JpaRepository<Player, Long> {

	List<Player> findAllByTeamOrderByTShirtNumberAsc(Team team);
	Player findOneById(long id);
}

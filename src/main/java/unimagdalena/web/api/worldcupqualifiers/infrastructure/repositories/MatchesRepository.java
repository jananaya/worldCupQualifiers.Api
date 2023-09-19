package unimagdalena.web.api.worldcupqualifiers.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import unimagdalena.web.api.worldcupqualifiers.infrastructure.models.Match;

public interface MatchesRepository extends JpaRepository<Match, Long> {

}

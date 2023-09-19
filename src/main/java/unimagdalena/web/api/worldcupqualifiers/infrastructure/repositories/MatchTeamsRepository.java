package unimagdalena.web.api.worldcupqualifiers.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import unimagdalena.web.api.worldcupqualifiers.infrastructure.models.MatchTeam;

public interface MatchTeamsRepository extends JpaRepository<MatchTeam, Long> {

}

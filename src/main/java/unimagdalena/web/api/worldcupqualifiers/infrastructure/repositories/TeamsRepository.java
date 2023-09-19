package unimagdalena.web.api.worldcupqualifiers.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.models.Team;

public interface TeamsRepository extends JpaRepository<Team, Long> {

}

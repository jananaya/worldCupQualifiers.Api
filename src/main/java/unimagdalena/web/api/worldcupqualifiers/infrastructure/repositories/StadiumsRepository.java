package unimagdalena.web.api.worldcupqualifiers.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import unimagdalena.web.api.worldcupqualifiers.infrastructure.models.Stadium;

public interface StadiumsRepository extends JpaRepository<Stadium, Long> {

}

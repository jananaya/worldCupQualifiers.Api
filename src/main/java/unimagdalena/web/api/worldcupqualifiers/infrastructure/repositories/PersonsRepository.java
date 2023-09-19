package unimagdalena.web.api.worldcupqualifiers.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import unimagdalena.web.api.worldcupqualifiers.infrastructure.models.Person;

public interface PersonsRepository extends JpaRepository<Person, Long> {

}

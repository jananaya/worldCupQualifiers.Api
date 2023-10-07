package unimagdalena.web.api.worldcupqualifiers.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import unimagdalena.web.api.worldcupqualifiers.infrastructure.models.ERole;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.models.Role;

public interface RolesRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}

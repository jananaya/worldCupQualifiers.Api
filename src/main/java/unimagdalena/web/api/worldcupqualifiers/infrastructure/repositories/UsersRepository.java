package unimagdalena.web.api.worldcupqualifiers.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import unimagdalena.web.api.worldcupqualifiers.infrastructure.models.User;


public interface UsersRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    
}

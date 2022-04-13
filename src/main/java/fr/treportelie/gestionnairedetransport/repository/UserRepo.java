package fr.treportelie.gestionnairedetransport.repository;


import fr.treportelie.gestionnairedetransport.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
    List<User> findAll();
    User findAllById(Integer id);
    User deleteUserById(Integer id);
}

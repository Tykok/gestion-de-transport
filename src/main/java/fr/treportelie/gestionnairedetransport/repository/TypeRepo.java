package fr.treportelie.gestionnairedetransport.repository;

import fr.treportelie.gestionnairedetransport.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepo extends JpaRepository<Type, Integer> {

    Type getTypeById(int id);
}

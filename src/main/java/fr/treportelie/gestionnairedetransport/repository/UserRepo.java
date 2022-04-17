package fr.treportelie.gestionnairedetransport.repository;


import fr.treportelie.gestionnairedetransport.entity.Type;
import fr.treportelie.gestionnairedetransport.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
    List<User> findAll();
    User findAllById(Integer id);
    User deleteUserById(Integer id);


    @Query(value = "select avg(age) " +
            "from (" +
            "select YEAR(FROM_DAYS(datediff(now(), date_naissance))) as age " +
            "from user" +
            ") ageOfUser;",
            nativeQuery = true)
    Double getAverageAge();

    @Query(value = "SELECT type, count(type) as nb FROM user group by type;", nativeQuery = true)
    List countAllByType();

    List<User> getUsersByType(Type type);
}

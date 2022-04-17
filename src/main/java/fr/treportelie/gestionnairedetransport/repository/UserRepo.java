package fr.treportelie.gestionnairedetransport.repository;


import fr.treportelie.gestionnairedetransport.entity.Type;
import fr.treportelie.gestionnairedetransport.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    @Query(value = "SELECT t.reference, count(u.id) as nb " +
            "FROM user u " +
            "inner join type t " +
            "on t.id = u.id_type " +
            "group by u.id_type;", nativeQuery = true)
    List countAllByType();

    List<User> getUsersByType(Type type);

    @Query(value = "select t.reference as Type, " +
            "CONCAT(prenom, ' ', nom) as DisplayName, " +
            "YEAR(FROM_DAYS(datediff(now(), date_naissance))) as Age, " +
            "DAY(FROM_DAYS(datediff(now(), date_naissance))) as NbJourActif " +
            "from user u " +
            "inner join type t " +
            "on u.id_type = t.id " +
            "where u.id = :id ;",
            nativeQuery = true)
    Object getFormatedDataById(@Param("id")int id);
}

package fr.treportelie.gestionnairedetransport.repository;


import fr.treportelie.gestionnairedetransport.dto.CourseDto;
import fr.treportelie.gestionnairedetransport.dto.NumberUserDto;
import fr.treportelie.gestionnairedetransport.dto.UserDto;
import fr.treportelie.gestionnairedetransport.entity.Type;
import fr.treportelie.gestionnairedetransport.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
    List<User> findAll();

    User findAllById(Integer id);

    void deleteById(Integer id);

    @Query(value = "select avg(age) " +
            "from (" +
            "select YEAR(FROM_DAYS(datediff(now(), date_naissance))) as age " +
            "from user" +
            ") ageOfUser;",
            nativeQuery = true)
    Double getAverageAge();

    @Query(value = "SELECT count(u.id) as nb " +
            "FROM user u " +
            "inner join type t " +
            "on t.id = u.id_type " +
            "where t.reference = :ref ;", nativeQuery = true)
    Integer countAllByType(@Param("ref") String ref);

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
    UserDto getFormatedDataById(@Param("id") int id);

    @Query(value = "select CONCAT(prenom, ' ', nom) as DisplayName " +
            "from user " +
            "where id = :id ;",
            nativeQuery = true)
    String getDisplayNameById(@Param("id") int id);


    @Query(value = "select YEAR(FROM_DAYS(datediff(now(), date_naissance))) as Age "+
            "from user " +
            "where id = :id ;",
            nativeQuery = true)
    Integer getAgeById(@Param("id") int id);

    @Query(value = "select DAY(FROM_DAYS(datediff(now(), date_naissance))) as NbJourActif "+
                "from user " +
                "where id = :id ;",
                nativeQuery = true)
    Integer getNbJourActifById(@Param("id") int id);

    @Query(value="select id_type from user where id = :id", nativeQuery = true)
    Integer getIdTypeByIdUser(@Param("id") int id);

    @Query(value = " select concat(nom, ' ', prenom) as Client, " +
            "count(c.id) as NbCourse, " +
            "sum(c.distance) as Distance_total " +
            "from user u " +
            "inner join course c " +
            "on u.id = c.id_client " +
            "where u.id = :id ",
            nativeQuery = true)
    Object getFormatedDataByClient(@Param("id") int id);
}

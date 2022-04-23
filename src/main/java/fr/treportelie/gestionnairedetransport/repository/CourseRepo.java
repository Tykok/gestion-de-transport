package fr.treportelie.gestionnairedetransport.repository;

import fr.treportelie.gestionnairedetransport.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepo extends JpaRepository<Course, Integer> {

    @Query(value="select count(id_client) from course where id_client = :id", nativeQuery = true)
    Integer countByClient(@Param("id") int id);


    @Query(value="select sum(distance) from course where id_client = :id", nativeQuery = true)
    Integer sumOfDistanceByClient(@Param("id") int id);
}

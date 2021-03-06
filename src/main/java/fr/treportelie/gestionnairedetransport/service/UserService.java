package fr.treportelie.gestionnairedetransport.service;

import fr.treportelie.gestionnairedetransport.dto.CourseDto;
import fr.treportelie.gestionnairedetransport.dto.NumberUserDto;
import fr.treportelie.gestionnairedetransport.dto.UserDto;
import fr.treportelie.gestionnairedetransport.entity.Type;
import fr.treportelie.gestionnairedetransport.entity.User;
import fr.treportelie.gestionnairedetransport.repository.CourseRepo;
import fr.treportelie.gestionnairedetransport.repository.TypeRepo;
import fr.treportelie.gestionnairedetransport.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TypeRepo typeRepo;


    @Autowired
    private CourseRepo courseRepo;

    /**
     * This function is used to get an user by id
     *
     * @param id int
     * @return Optional<User>
     */
    public Optional<User> findById(Integer id) {
        return userRepo.findById(id);
    }

    /**
     * This function is used to get all user
     *
     * @return List<User>
     */
    public List<User> findAll() {
        return userRepo.findAll();
    }

    /**
     * This function is used to delete an user
     *
     * @param userId
     */
    public void deleteUserById(Integer userId) {
        userRepo.deleteById(userId);
    }

    public Double getAverageAge() {
        return userRepo.getAverageAge();
    }


    /**
     * This function is used to create an User
     *
     * @param user
     * @param id_type
     * @return Boolean
     */
    public Boolean saveUser(User user, String id_type) {

        if (user.getDate_naissance() == null
                && user.getNom() == null
                && user.getPrenom() == null) {
            return false;
        }


        if (user.getDate_inscription() == null) {
            user.setDate_inscription(LocalDate.now());
        }

        try {
            user.setType(typeRepo.getTypeById(Integer.parseInt(id_type)));
            userRepo.save(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    /**
     * This function return a list of numbers of users by type
     *
     * @return a list of numbers of users by type
     */
    public NumberUserDto countAllByType() {

        Integer numberOfClient = userRepo.countAllByType("CLIENT");
        Integer numberOfMotard = userRepo.countAllByType("CHAUFFEUR (MOTARD)");
        Integer numberOfDriver = userRepo.countAllByType("CHAUFFEUR (VOITURE)");

        NumberUserDto numberUserDto = new NumberUserDto(numberOfClient,numberOfMotard,numberOfDriver);

        return numberUserDto;
    }

    /**
     * This function return a list of users by type
     *
     * @return a list of users by type
     */
    public List<User> getUserByType(Type type) {
        return userRepo.getUsersByType(type);
    }

    /**
     * This function return an users by an id
     *
     * @param id
     * @return Object
     */
    public UserDto getFormatedDataById(Integer id) {

        String displayName = userRepo.getDisplayNameById(id);

        String typeReference = typeRepo.getTypeById(
                userRepo.getIdTypeByIdUser(id)
        ).getReference();

        Integer age = userRepo.getAgeById(id);
        Integer nbJourActif = userRepo.getNbJourActifById(id);

        return new UserDto(typeReference, displayName, age, nbJourActif);
    }

    /**
     * This function return all information of all course of an user
     *
     * @param id
     * @return Object
     */
    public CourseDto getFormatedDataByClient(Integer id) {
        String displayName = userRepo.getDisplayNameById(id);
        Integer nbCourse = courseRepo.countByClient(id);
        Integer distance = courseRepo.sumOfDistanceByClient(id);
        return new CourseDto(displayName, nbCourse, distance);
    }
}

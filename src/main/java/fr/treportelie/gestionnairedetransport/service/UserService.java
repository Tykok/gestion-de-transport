package fr.treportelie.gestionnairedetransport.service;

import fr.treportelie.gestionnairedetransport.entity.User;
import fr.treportelie.gestionnairedetransport.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    /**
     * This function is used to get an user by id
     * @param id int
     * @return Optional<User>
     */
    public Optional<User> findById(Integer id) {
        return userRepo.findById(id);
    }

    /**
     * This function is used to get all user
     * @return List<User>
     */
    public List<User> findAll() {
        return userRepo.findAll();
    }

    /**
     * This function is used to delete an user
     * @param user
     */
    public void deleteUserById(User user) {
        userRepo.deleteUserById(user.getId());
    }

    /**
     * This function is used to create an User
     * @param user
     * @return Boolean
     */
    public Boolean saveUser(User user) {

        if (user.getDate_naissance() == null
                && user.getNom() == null
                && user.getPrenom() == null
                && user.getType() == null) {
            return false;
        }

        if (user.getDate_inscription() == null) {
            user.setDate_inscription(LocalDate.now());
        }

        try {
            userRepo.save(user);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    /**
     * This function return a list of numbers of users by type
     * @return a list of numbers of users by type
     */
    public List countAllByType(){
        return userRepo.countAllByType();
    }
}

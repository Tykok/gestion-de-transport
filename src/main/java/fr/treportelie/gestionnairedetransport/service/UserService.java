package fr.treportelie.gestionnairedetransport.service;

import fr.treportelie.gestionnairedetransport.entity.User;
import fr.treportelie.gestionnairedetransport.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public Optional<User> findById(Integer id) {
        return userRepo.findById(id);
    }

    public List<User> findAll(){
        return userRepo.findAll();
    }

    public void deleteUserById(User user){
        userRepo.deleteUserById(user.getId());
    }

    public Boolean saveUser(String nom, String prenom, Date date_naissance, Date date_inscription, Integer type){
        User user = new User();
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setDate_naissance(date_naissance);
        user.setDate_inscription(date_inscription);
        user.setType(type);
        try{
            userRepo.save(user);
        }catch (Exception e){
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

package fr.treportelie.gestionnairedetransport.controller;

import fr.treportelie.gestionnairedetransport.entity.User;
import fr.treportelie.gestionnairedetransport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * This endpoint return a list of all users
     * @return List<User>
     */
    @GetMapping("/all")
    private List<User> getAllUser(){
        return userService.findAll();
    }

    /**
     * This endpoint return a specific user
     * @param id
     * @return User
     */
    @GetMapping("/get/{id}")
    private Optional<User> getAUser(@PathVariable String id){
        return userService.findById(Integer.valueOf(id));
    }

    /**
     * This endpoint used to delete an user
     * @param user
     * @return A sentence
     */
    @PostMapping("/delete")
    private String deleteUser(@RequestBody User user){
        try{
            userService.deleteUserById(user);
            return "User as been deleted";
        }catch (Exception e){
            return "Error when try to delete the user";
        }
    }

    /**
     * This endpoint used to count user by type
     * @return List
     */
    @GetMapping("/countByUserType")
    private List countUser(){
        return userService.countAllByType();
    }
}

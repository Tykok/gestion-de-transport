package fr.treportelie.gestionnairedetransport.controller;

import fr.treportelie.gestionnairedetransport.entity.Type;
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
     *
     * @return List<User>
     */
    @GetMapping("/all")
    private List<User> getAllUser() {
        return userService.findAll();
    }

    /**
     * This endpoint return a specific user
     *
     * @param id
     * @return User
     */
    @GetMapping("/get/{id}")
    private Optional<User> getAUser(@PathVariable String id) {
        return userService.findById(Integer.valueOf(id));
    }

    /**
     * This endpoint used to delete an user
     *
     * @param user
     * @return A sentence
     */
    @PostMapping("/delete")
    private String deleteUser(@RequestBody User user) {
        try {
            userService.deleteUserById(user);
            return "User as been deleted";
        } catch (Exception e) {
            return "Error when try to delete the user";
        }
    }

    /**
     * This endpoint return the age average of all users
     *
     * @return Double
     */
    @GetMapping("/average")
    private Double getAverageAge() {
        return userService.getAverageAge();
    }

    /**
     * This endpoint used to count user by type
     *
     * @return List
     */
    @GetMapping("/countByUserType")
    private List countUser() {
        return userService.countAllByType();
    }

    /**
     * This endpoint used to create an user
     *
     * @param user User
     * @return
     */
    @PostMapping("/insert")
    private String insertAnUser(@RequestBody User user) {
        if (userService.saveUser(user)) {
            return "User as been created";
        } else {
            return "Error when try to insert the user";
        }
    }

    /**
     * This endpoint used to update an user
     * @param type
     * @return List<User>
     */
    @PostMapping("/getUserByType")
    private List<User> getUserByType(@RequestBody Type type) {
        return userService.getUserByType(type);
    }

    @GetMapping("/getUser/{id}")
    private Object getUser(@PathVariable String id) {
        return userService.getFormatedDataById(Integer.valueOf(id));
    }
}

package camt.FitUp.Project.controller;

import camt.FitUp.Project.entity.Role;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by pan on 5/14/2016.
 */
@CrossOrigin
@RestController
@RequestMapping("/")

public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "customer", method = RequestMethod.GET)
    public List<User> list() {
        return userService.findAll();
    }

    @RequestMapping(value = "customer/login", method = RequestMethod.GET)
    public User findByUsername(@RequestParam("username") String username) {
        return userService.findByUsername(username);
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public User addUser(@RequestBody User user, BindingResult bindingResult) {
        return userService.addUser(user);
    }

    @RequestMapping(value = "customer/{id}", method = RequestMethod.PUT)
    public User edit(@PathVariable("id") Long id,
                     @RequestParam("username") String username,
                     @RequestParam("email") String email,
                     @RequestParam("password") String password) {
        User user = userService.getUser(id);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        return userService.updateUser(user);
    }

    @RequestMapping(value = "customer/{id}", method = RequestMethod.DELETE)
    public User delete(@PathVariable("id") Long id) {
        return userService.deleteUser(id);
    }

    @RequestMapping(value = "customer/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "customerRole/{id}", method = RequestMethod.PUT)
    public Role editRole(@PathVariable("id") Long id,
                         @RequestParam("roleSelected") String roleName) {
        Role role = userService.getRoleName(id);
        role.setRoleName(roleName);
        return userService.updateRole(role);
    }

    @RequestMapping(value = "customerRole/{id}", method = RequestMethod.GET)
    public Role getRole(@PathVariable("id") Long id) {
        return userService.getRoleName(id);
    }

    @RequestMapping(value = "user/getUser", method = RequestMethod.GET)
    public User getUserToEdit(@RequestParam("username") Long id) {
        return userService.getUser(id);
    }

}

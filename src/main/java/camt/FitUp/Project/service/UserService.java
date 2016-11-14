package camt.FitUp.Project.service;

import camt.FitUp.Project.entity.ImageUser;
import camt.FitUp.Project.entity.Role;
import camt.FitUp.Project.entity.User;

import java.util.List;

/**
 * Created by Dto on 4/19/2015.
 */
public interface UserService {

    List<User> findAll();

//    User login(String username);

    User registerUser(User user);

    User getUser(Long id);

    User updateUser(User user);

    User deleteUser(Long id);

    User addImageUser(User user, ImageUser image);

    User deleteImageUser(User user, Long imageId);

    Role getRoleName(Long id);

    Role updateRole(Role role);

    User findByUsername(String username);

}

package camt.FitUp.Project.dao;

import camt.FitUp.Project.entity.Role;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by pan on 5/15/2016.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        Role customerRole = new Role("member");
        Set<Role> roles = new HashSet<>();
        roles.add(customerRole);
        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User deleteUser(User user) {
        userRepository.delete(user);
        user.setId(null);
        return user;
    }

}

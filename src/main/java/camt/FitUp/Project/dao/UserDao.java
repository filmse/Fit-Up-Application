package camt.FitUp.Project.dao;

import camt.FitUp.Project.entity.FitUpInfo;
import camt.FitUp.Project.entity.User;

/**
 * Created by pan on 5/15/2016.
 */
public interface UserDao {

    User deleteUser(User user);

    User registerUser(User user);

    User findByUsername(String username);

}

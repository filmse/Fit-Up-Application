package camt.FitUp.Project.service;

import camt.FitUp.Project.dao.UserDao;
import camt.FitUp.Project.dao.UserDaoImpl;
import camt.FitUp.Project.entity.ImageUser;
import camt.FitUp.Project.entity.Role;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.repository.RoleRepository;
import camt.FitUp.Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Dto on 4/19/2015.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

//    @Override
//    @Transactional
//    public User login(String username) {
//        return userDao.login(username);
//    }

    @Override
    public User registerUser(User user) {
        return userDao.registerUser(user);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(Long id) {
        User user = getUser(id);
        return userDao.deleteUser(user);
    }

    @Override
    @Transactional
    public User addImageUser(User user, ImageUser image) {
        user.getImages().add(image);

        userRepository.save(user);
        return user;
    }

    @Override
    @Transactional
    public User deleteImageUser(User user, Long imageId) {
        Set<ImageUser> images = user.getImages();
        for (Iterator<ImageUser> it = images.iterator(); it.hasNext(); ) {
            ImageUser f = it.next();
            if (f.getId().equals(imageId)) {
                user.getImages().remove(f);
            }
        }
        userRepository.save(user);
        return user;
    }

    @Override
    public Role getRoleName(Long id) {
        return roleRepository.findOne(id);
    }

    @Override
    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}

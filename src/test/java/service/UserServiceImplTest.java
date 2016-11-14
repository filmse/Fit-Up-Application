package service;

import camt.FitUp.Project.dao.UserDaoImpl;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.repository.UserRepository;
import camt.FitUp.Project.service.UserServiceImpl;
import org.junit.Test;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

/**
 * Created by Dto on 7/18/2016.
 */
public class UserServiceImplTest {

//    @Test
//    public void testRegister() {
//        UserDaoImpl userDao = mock(UserDaoImpl.class);
//        User users = mock(User.class);
//
//        when(users.getUsername()).thenReturn("film");
//        when(users.getEmail()).thenReturn("film@gmail.com");
//        when(users.getPassword()).thenReturn("4455");
//
//        when(userDao.registerUser(users)).thenReturn(users);
//
//        UserServiceImpl userService = new UserServiceImpl();
//        userService.setUserDao(userDao);
//
//        User result = userService.registerUser(users);
//        assertNotNull(result);
//    }
//
//    @Test
//    public void testLogin() {
//
//        UserRepository userRepository = mock(UserRepository.class);
//        User users = mock(User.class);
//        when(userRepository.findByLogin("Jacker","1111")).thenReturn(users);
//
//        {
//            when(users.getId()).thenReturn(3l);
//            when(users.getUsername()).thenReturn("Jacker");
//            when(users.getEmail()).thenReturn("member@yahoo.com");
//            when(users.getPassword()).thenReturn("jacker003");
//        }
//
////        UserServiceImpl userService = new UserServiceImpl();
////        userService.setUserRepository(userRepository);
////
////        User result01 = userService.login("Jacker");
////        assertNotNull(result01);
////        assertEquals("Jacker", result01.getUsername());
////
////        User result02 = userService.login("Jackerrrrr");
////        assertNull(result02);
////
////        User result03 = userService.login("Jacker!!");
////        assertNull(result03);
////
////        User result04 = userService.login("");
////        assertNull(result04);
//
////        System.out.print(result01.getUsername());
////        System.out.println(" Id: " + result01.getId() + " Email: " + result01.getEmail() + " Password: " + result01.getPassword() + " roleName: " + result01.getRoles() + ".");
////        System.out.println(result02);
////        System.out.println(result03);
////        System.out.println(result04);
//    }
//
//    @Test
//    public void testDeleteUser() {
//        UserDaoImpl userDao = mock(UserDaoImpl.class);
//        User users = mock(User.class);
//
//        when(users.getUsername()).thenReturn("film");
//        when(users.getEmail()).thenReturn("film@gmail.com");
//        when(users.getPassword()).thenReturn("4455");
//
//        when(userDao.deleteUser(users)).thenReturn(null);
//
//        UserServiceImpl userService = new UserServiceImpl();
//        userService.setUserDao(userDao);
//
//    }

}
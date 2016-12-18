package service;

import camt.FitUp.Project.dao.UserDaoImpl;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.service.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Film on 7/18/2016.
 */

public class UserServiceTest {

    @Test
    public void testAddUserNotNull() {
        UserDaoImpl userDao = mock(UserDaoImpl.class);
        User user = new User("Davika", "Davika@gmail.com", "4432");
        when(userDao.addUser(user)).thenReturn(null);
        {
            User returnMock = new User("Davika", "Davika@gmail.com", "4432");
            returnMock.setId((long) 101);
            when(userDao.addUser(user)).thenReturn(returnMock);
        }
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDao);

        User result = userService.addUser(user);
        assertNotNull(result);
        assertEquals("Davika", result.getUsername());
        assertNotNull(result.getId());
        verify(userDao).addUser(user);
    }

    @Test
    public void testAddUserNull() {
        UserDaoImpl userDao = mock(UserDaoImpl.class);
        User user = new User("Davika", "Davika@gmail.com", "4432");
        {
            User returnMock = new User("Davika", "Davika@gmail.com", "4432");
            returnMock.setId((long) 101);
            //when(userDao.addUser(user)).thenReturn(returnMock);
        }

        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDao);
        User result = userService.addUser(user);
        assertNull(result);
        verify(userDao).addUser(user);
    }

    @Test
    public void testFindByUsername() {
        UserDaoImpl userDaoImpl = mock(UserDaoImpl.class);
        User users = mock(User.class);
        when(userDaoImpl.findByUsername("Member")).thenReturn(users);

        {
            when(users.getId()).thenReturn(3l);
            when(users.getUsername()).thenReturn("Member");
            when(users.getEmail()).thenReturn("member@yahoo.com");
            when(users.getPassword()).thenReturn("3333");
        }

        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDaoImpl);

        User result01 = userService.findByUsername("Member");
        assertNotNull(result01);
        assertEquals("Member", result01.getUsername());

        User result02 = userService.findByUsername("Jackerrrrr");
        assertNull(result02);

        User result03 = userService.findByUsername("Jacker!!");
        assertNull(result03);

        User result04 = userService.findByUsername("");
        assertNull(result04);
    }

}
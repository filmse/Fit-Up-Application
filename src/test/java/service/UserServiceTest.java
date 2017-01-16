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
    public void testFindByUsername() {
        UserDaoImpl userDaoImpl = mock(UserDaoImpl.class);
        User users = mock(User.class);
        when(userDaoImpl.findByUsername("Jacker")).thenReturn(users);

        {
            when(users.getId()).thenReturn(3l);
            when(users.getUsername()).thenReturn("Jacker");
            when(users.getEmail()).thenReturn("member@yahoo.com");
            when(users.getPassword()).thenReturn("jacker003");
        }

        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDaoImpl);

        User result01 = userService.findByUsername("Jacker");
        assertNotNull(result01);
        assertEquals("Jacker", result01.getUsername());

        User result02 = userService.findByUsername("Jacker0033333");
        assertNull(result02);

        User result03 = userService.findByUsername("Jacker003!!");
        assertNull(result03);

        User result04 = userService.findByUsername("");
        assertNull(result04);
    }

    @Test
    public void testAddUserNotNull() {
        UserDaoImpl userDao = mock(UserDaoImpl.class);
        User user = mock(User.class);
        when(userDao.addUser(user)).thenReturn(null);
        {
            User returnMock = new User(10l, "Jacker", "member@yahoo.com", "jacker003");
            returnMock.setId((long) 101);
            when(userDao.addUser(user)).thenReturn(returnMock);
        }
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDao);

        User result = userService.addUser(user);
        System.out.print(result);
        assertNotNull(result);
        assertEquals("Jacker", result.getUsername());
        assertEquals("member@yahoo.com", result.getEmail());
        assertEquals("jacker003", result.getPassword());
        assertNotNull(result.getId());
        verify(userDao).addUser(user);
    }

    @Test
    public void testAddUserNull() {
        UserDaoImpl userDao = mock(UserDaoImpl.class);
        User user = mock(User.class);
        {
            User returnMock = new User(10l, "Jacker", "member@yahoo.com", "jacker003");
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
    public void testDeleteUser() {
        UserServiceImpl userServiceImpl = mock(UserServiceImpl.class);
        User user = new User(2l, "Momomo", "trainer@yahoo.com", "momo002");
        when(userServiceImpl.getUser(2l)).thenReturn(null);
        {
            User returnMock = new User(2l, "Momomo", "trainer@yahoo.com", "momo002");
            when(userServiceImpl.deleteUser(2l)).thenReturn(returnMock);
        }

        User result = new User(2l, "Momomo", "trainer@yahoo.com", "momo002");
        assertNotNull(result);
        //System.out.println(result.getUsername());
        assertEquals(new Long(2), result.getId());
    }

}
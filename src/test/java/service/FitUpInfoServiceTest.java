//package service;
//
//import camt.FitUp.Project.dao.FitUpInfoDaoImpl;
//import camt.FitUp.Project.dao.UserDaoImpl;
//import camt.FitUp.Project.entity.FitUpInfo;
//import camt.FitUp.Project.entity.User;
//import camt.FitUp.Project.service.FitUpInfoServiceImpl;
//import org.junit.Test;
//
//import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNull;
//import static org.mockito.Mockito.*;
//
///**
// * Created by Film on 14/9/2559.
// */
//public class FitUpInfoServiceTest {
//
//    @Test
//    public void testAddInfoPass() {
//
//        FitUpInfoDaoImpl forumDao = mock(FitUpInfoDaoImpl.class);
//        FitUpInfo fitUpInfo = mock(FitUpInfo.class);
//
//        UserDaoImpl userDao = mock(UserDaoImpl.class);
//        User user = mock(User.class);
//
//        {
//            when(user.getId()).thenReturn(2l);
//            when(user.getUsername()).thenReturn("trainer");
//            when(user.getEmail()).thenReturn("trainer@yahoo.com");
//            when(user.getPassword()).thenReturn("2222");
//
//            when(userDao.registerUser(user)).thenReturn(user);
//        }
//
//        {
//            when(fitUpInfo.getId()).thenReturn(1l);
//            when(fitUpInfo.getName()).thenReturn("Sport Pro");
//            when(fitUpInfo.getDescription()).thenReturn("The people that need to know how implementing perfect body");
//
//            when(userDao.registerUser(user)).thenReturn(user);
//            when(forumDao.addForum(user, fitUpInfo)).thenReturn(fitUpInfo);
//        }
//
//        FitUpInfoServiceImpl forumService = new FitUpInfoServiceImpl();
//        forumService.setFitUpInfoDao(forumDao);
//
//        FitUpInfo result1 = forumService.addForum(user, fitUpInfo);
//        System.out.println(result1);
//
//        assertNotNull(result1);
//        assertNotNull(user);
//        assertNotNull(fitUpInfo);
//    }
//
//    //    @Test
////    public void testDelete() {
////        UserDaoImpl userDao = mock(UserDaoImpl.class);
////        User users = mock(User.class);
////
////        when(users.getUsername()).thenReturn("film");
////        when(users.getEmail()).thenReturn("film@gmail.com");
////        when(users.getPassword()).thenReturn("4455");
////
////        when(userDao.deleteUser(users)).thenReturn(null);
////
////        UserServiceImpl userService = new UserServiceImpl();
////        userService.setUserDao(userDao);
////
////    }
//
//    @Test
//    public void testAddInfoFailed() {
//
//        FitUpInfoDaoImpl forumDao = mock(FitUpInfoDaoImpl.class);
//        FitUpInfo fitUpInfo = new FitUpInfo();
//
//        UserDaoImpl userDao = mock(UserDaoImpl.class);
//        User user = mock(User.class);
//
//        FitUpInfoServiceImpl forumService = new FitUpInfoServiceImpl();
//        forumService.setFitUpInfoDao(forumDao);
//
//        FitUpInfo result2 = forumService.addForum(user, fitUpInfo);
//        assertNotNull(result2);
//
//    }
//
//}

package service;

import camt.FitUp.Project.dao.FitUpInfoDaoImpl;
import camt.FitUp.Project.entity.FitUpInfo;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.service.FitUpInfoServiceImpl;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Film on 19/12/2559.
 */

public class FitUpInfoServiceTest {

    @Test
    public void testAddFitUpInfoNotNull() {
        FitUpInfoDaoImpl fitUpInfoDao = mock(FitUpInfoDaoImpl.class);

        FitUpInfo fitUpInfo = new FitUpInfo(10l, "build body sick pack", "The people can build boy six pack in one week");
        User user = new User(10l,"Davika", "Davika@gmail.com", "4432");

        when(fitUpInfoDao.addForum(user, fitUpInfo)).thenReturn(null);
        {
            FitUpInfo returnMock = new FitUpInfo(10l, "build body sick pack", "The people can build boy six pack in one week");
            when(fitUpInfoDao.addForum(user, fitUpInfo)).thenReturn(returnMock);
        }

        FitUpInfoServiceImpl fitUpInfoServiceImpl = new FitUpInfoServiceImpl();
        fitUpInfoServiceImpl.setFitUpInfoDao(fitUpInfoDao);

        FitUpInfo result = fitUpInfoServiceImpl.addForum(user, fitUpInfo);
        assertNotNull(result);
//        System.out.println(user);
//        System.out.print(fitUpInfoDao);
    }

    @Test
    public void testAddFitUpInfoNull() {
        FitUpInfoDaoImpl fitUpInfoDao = mock(FitUpInfoDaoImpl.class);

        FitUpInfo fitUpInfo = new FitUpInfo(10l, "build body sick pack", "The people can build boy six pack in one week");
        User user = new User(10l,"Davika", "Davika@gmail.com", "4432");

        when(fitUpInfoDao.addForum(user, fitUpInfo)).thenReturn(null);
        {
            FitUpInfo returnMock = new FitUpInfo(10l, "build body sick pack", "The people can build boy six pack in one week");
            when(fitUpInfoDao.addForum(user, fitUpInfo)).thenReturn(returnMock);
        }

        FitUpInfoServiceImpl fitUpInfoServiceImpl = new FitUpInfoServiceImpl();
        fitUpInfoServiceImpl.setFitUpInfoDao(fitUpInfoDao);

        FitUpInfo result = fitUpInfoServiceImpl.addForum(null, fitUpInfo);
        assertNull(result);
//        System.out.println(user);
//        System.out.print(fitUpInfoDao);
    }

}

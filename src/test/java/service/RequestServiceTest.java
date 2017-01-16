package service;

import camt.FitUp.Project.dao.RequestDaoImpl;
import camt.FitUp.Project.entity.Request;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Film on 19/12/2559.
 */
public class RequestServiceTest {

    @Test
    public void addRequestNotNull() {
        RequestDaoImpl requestDaoImpl = mock(RequestDaoImpl.class);
        Request request = mock(Request.class);
        when(requestDaoImpl.addRequest(request)).thenReturn(request);

        {
            when(request.getId()).thenReturn(1l);
            when(request.getRequest()).thenReturn("Admin i forgot password!!");
        }

        assertNotNull(request);
    }

    @Test
    public void addRequestNull() {
        RequestDaoImpl requestDaoImpl = mock(RequestDaoImpl.class);
        Request request = mock(Request.class);
        when(requestDaoImpl.addRequest(request)).thenReturn(null);

        {
            when(request.getRequest()).thenReturn("Admin i forgot password!!");
        }

        Request request1 = new Request();
        request1.setRequest("Admin i forgot password!!");

        Request result01 = request1.setRequest("Admin i forgot password!!");
        Assert.assertNull(result01);
    }

    @Test
    public void deleteRequestNull() {
    }

}

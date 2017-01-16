package camt.FitUp.Project.service;

import camt.FitUp.Project.dao.RequestDao;
import camt.FitUp.Project.entity.Request;
import camt.FitUp.Project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Film on 5/11/2559.
 */
@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    RequestDao requestDao;

    @Override
    public Request addRequest(Request request) {
        return requestDao.addRequest(request);
    }

    @Override
    public List<Request> requestList() {
        return requestDao.requestList();
    }

    @Override
    public Request getRequest(Long id) {
        return requestDao.getRequest(id);
    }

    @Override
    public Request deletePassSet(Long id) {
        Request request = getRequest(id);
        return requestDao.deletePassSet(request);
    }

}

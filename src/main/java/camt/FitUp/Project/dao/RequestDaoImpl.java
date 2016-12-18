package camt.FitUp.Project.dao;

import camt.FitUp.Project.entity.Request;
import camt.FitUp.Project.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Film on 5/11/2559.
 */
@Repository
public class RequestDaoImpl implements RequestDao {

    @Autowired
    RequestRepository requestRepository;

    @Override
    public Request addRequest(Request request) {
        return requestRepository.save(request);
    }

    @Override
    public List<Request> requestList() {
        return requestRepository.findAll();
    }

    @Override
    public Request getRequest(Long id) {
        return requestRepository.findOne(id);
    }

    @Override
    public Request deletePassSet(Request request) {
            requestRepository.delete(request);
            request.setId(null);
            return request;
        }

}

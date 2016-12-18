package camt.FitUp.Project.dao;

import camt.FitUp.Project.entity.Request;

import java.util.List;

/**
 * Created by Film on 5/11/2559.
 */
public interface RequestDao {
    Request addRequest(Request request);

    List<Request> requestList();

    Request getRequest(Long id);

    Request deletePassSet(Request request);
}

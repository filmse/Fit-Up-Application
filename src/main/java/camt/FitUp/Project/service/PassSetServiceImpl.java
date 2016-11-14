package camt.FitUp.Project.service;

import camt.FitUp.Project.dao.PassSetDao;
import camt.FitUp.Project.entity.PassSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Film on 5/11/2559.
 */
@Service
public class PassSetServiceImpl implements PassSetService {

    @Autowired
    PassSetDao passSetDao;

    @Override
    public PassSet passSet(PassSet passSet) {
        return passSetDao.passSet(passSet);
    }

    @Override
    public List<PassSet> passSetList() {
        return passSetDao.passSetList();
    }

}

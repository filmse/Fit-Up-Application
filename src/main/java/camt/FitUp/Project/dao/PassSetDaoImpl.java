package camt.FitUp.Project.dao;

import camt.FitUp.Project.entity.PassSet;
import camt.FitUp.Project.repository.PassSetRepository;
import camt.FitUp.Project.service.PassSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Film on 5/11/2559.
 */
@Repository
public class PassSetDaoImpl implements PassSetDao {

    @Autowired
    PassSetRepository passSetRepository;

    @Override
    public PassSet passSet(PassSet passSet) {
        return passSetRepository.save(passSet);
    }

    @Override
    public List<PassSet> passSetList() {
        return passSetRepository.findAll();
    }

}

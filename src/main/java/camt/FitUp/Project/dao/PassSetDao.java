package camt.FitUp.Project.dao;

import camt.FitUp.Project.entity.PassSet;

import java.util.List;

/**
 * Created by Film on 5/11/2559.
 */
public interface PassSetDao {
    PassSet passSet(PassSet passSet);

    List<PassSet> passSetList();

    PassSet getPassSet(Long id);

    PassSet deletePassSet(PassSet passSet);
}

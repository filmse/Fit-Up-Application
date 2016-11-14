package camt.FitUp.Project.service;

import camt.FitUp.Project.entity.PassSet;

import java.util.List;

/**
 * Created by Film on 5/11/2559.
 */
public interface PassSetService {
    PassSet passSet(PassSet passSet);

    List<PassSet> passSetList();
}

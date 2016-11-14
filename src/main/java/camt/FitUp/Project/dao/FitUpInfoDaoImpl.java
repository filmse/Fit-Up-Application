package camt.FitUp.Project.dao;

import camt.FitUp.Project.entity.FitUpInfo;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.repository.FitUpInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Created by Dto on 2/9/2015.
 */

@Repository
public class FitUpInfoDaoImpl implements FitUpInfoDao {
    @Autowired
    FitUpInfoRepository fitUpInfoRepository;

    @Override
    public FitUpInfo addForum(User user, FitUpInfo fitUpInfo) {
        fitUpInfoRepository.save(fitUpInfo);
        return fitUpInfo;
    }

    @Override
    public FitUpInfo addImageForum(FitUpInfo fitUpInfo) {
        return fitUpInfoRepository.save(fitUpInfo);
    }

    @Override
    public List<FitUpInfo> getInfos() {
        return fitUpInfoRepository.findAll();
    }

    @Override
    public FitUpInfo findByName(String name) {
        return fitUpInfoRepository.findByName(name);
    }

    @Override
    public FitUpInfo deleteForum(FitUpInfo fitUpInfo) {
        fitUpInfoRepository.delete(fitUpInfo);
        fitUpInfo.setId(null);
        return fitUpInfo;
    }

    @Override
    public FitUpInfo updateForum(FitUpInfo fitUpInfo) {
        return fitUpInfoRepository.save(fitUpInfo);
    }

    @Override
    public void deleteImageForum(FitUpInfo fitUpInfo) {
    }

    @Override
    public FitUpInfo getForum(Long id) {
        return fitUpInfoRepository.findOne(id);
    }

}
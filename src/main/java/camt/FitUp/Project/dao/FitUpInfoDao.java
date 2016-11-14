package camt.FitUp.Project.dao;

import camt.FitUp.Project.entity.FitUpInfo;
import camt.FitUp.Project.entity.User;

import java.util.List;

/**
 * Created by Dto on 2/7/2015.
 */
public interface FitUpInfoDao {
    FitUpInfo addForum(User user, FitUpInfo fitUpInfo);
    FitUpInfo addImageForum(FitUpInfo fitUpInfo);
    List<FitUpInfo> getInfos();
    FitUpInfo findByName(String name);
    FitUpInfo deleteForum(FitUpInfo fitUpInfo);
    FitUpInfo updateForum(FitUpInfo fitUpInfo);
    void deleteImageForum(FitUpInfo fitUpInfo);
    FitUpInfo getForum(Long id);
}

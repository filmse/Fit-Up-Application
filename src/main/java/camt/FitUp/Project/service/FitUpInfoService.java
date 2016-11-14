package camt.FitUp.Project.service;

import camt.FitUp.Project.entity.FitUpInfo;
import camt.FitUp.Project.entity.ImageFitUpInfo;
import camt.FitUp.Project.entity.User;


import java.util.List;

/**
 * Created by Dto on 2/7/2015.
 */
public interface FitUpInfoService {
    FitUpInfo addForum(User user, FitUpInfo fitUpInfo);
    FitUpInfo addImageForum(FitUpInfo fitUpInfo, ImageFitUpInfo imageFitUpInfo);
    List<FitUpInfo> getInfos();
    FitUpInfo findByName(String name);
    FitUpInfo deleteForum(Long id);
    FitUpInfo getForum(Long id);
    FitUpInfo updateForum(FitUpInfo fitUpInfo);
    User deleteUserForum(User user, Long infoId);
    FitUpInfo deleteImageForum(FitUpInfo fitUpInfo, Long imageId);
}

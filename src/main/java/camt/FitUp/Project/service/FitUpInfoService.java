package camt.FitUp.Project.service;

import camt.FitUp.Project.entity.FitUpInfo;
import camt.FitUp.Project.entity.ImageFitUpInfo;
import camt.FitUp.Project.entity.User;

import java.util.List;

/**
 * Created by Dto on 2/7/2015.
 */
public interface FitUpInfoService {

    FitUpInfo addFitUpInfo(User user, FitUpInfo fitUpInfo);

    FitUpInfo addImageFitUpInfo(FitUpInfo fitUpInfo, ImageFitUpInfo imageFitUpInfo);

    List<FitUpInfo> getFitUpInfos();

    FitUpInfo findByName(String name);

    FitUpInfo deleteFitUpInfo(Long id);

    FitUpInfo getFitUpInfo(Long id);

    FitUpInfo updateFitUpInfo(FitUpInfo fitUpInfo);

    User deleteUserFitUpInfo(User user, Long infoId);

    FitUpInfo deleteImageFitUpInfo(FitUpInfo fitUpInfo, Long imageId);
}

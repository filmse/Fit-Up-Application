package camt.FitUp.Project.service;

import camt.FitUp.Project.dao.FitUpInfoDao;
import camt.FitUp.Project.dao.FitUpInfoDaoImpl;
import camt.FitUp.Project.dao.UserDao;
import camt.FitUp.Project.entity.FitUpInfo;
import camt.FitUp.Project.entity.ImageFitUpInfo;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.repository.FitUpInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Dto on 2/8/2015.
 */
@Service
public class FitUpInfoServiceImpl implements FitUpInfoService {

    @Autowired
    FitUpInfoDao fitUpInfoDao;

    @Autowired
    FitUpInfoRepository fitUpInfoRepository;

    @Autowired
    UserDao userDao;

    @Override
    public FitUpInfo addFitUpInfo(User user, FitUpInfo fitUpInfo) {
        return fitUpInfoDao.addForum(user, fitUpInfo);
    }

    @Override
    @Transactional
    public FitUpInfo addImageFitUpInfo(FitUpInfo fitUpInfo, ImageFitUpInfo imageFitUpInfo) {
        imageFitUpInfo = ImageUtil.resizeImage(imageFitUpInfo, 200);
        fitUpInfo.getImageInfos().add(imageFitUpInfo);
        fitUpInfoDao.addImageForum(fitUpInfo);
        return fitUpInfo;
    }

    @Override
    public List<FitUpInfo> getFitUpInfos() {
        return fitUpInfoDao.getInfos();
    }

    @Override
    public FitUpInfo findByName(String name) {
        return fitUpInfoDao.findByName(name);
    }

    @Override
    public FitUpInfo deleteFitUpInfo(Long id) {
        FitUpInfo fitUpInfo = getFitUpInfo(id);
        return fitUpInfoDao.deleteForum(fitUpInfo);
    }

    @Override
    public FitUpInfo getFitUpInfo(Long id) {
        return fitUpInfoDao.getForum(id);
    }

    @Override
    public FitUpInfo updateFitUpInfo(FitUpInfo fitUpInfo) {
        return fitUpInfoDao.updateForum(fitUpInfo);
    }

    @Override
    @Transactional
    public FitUpInfo deleteImageFitUpInfo(FitUpInfo fitUpInfo, Long imageId) {
        Set<ImageFitUpInfo> imageInfos = fitUpInfo.getImageInfos();
        for (Iterator<ImageFitUpInfo> it = imageInfos.iterator(); it.hasNext(); ) {
            ImageFitUpInfo f = it.next();
            if (f.getId().equals(imageId)) {
                fitUpInfo.getImageInfos().remove(f);
            }
        }
        fitUpInfoDao.deleteImageForum(fitUpInfo);
        return fitUpInfo;
    }

    @Override
    public User deleteUserFitUpInfo(User user, Long infoId) {
        Set<FitUpInfo> fitUpInfo = user.getInfos();
        FitUpInfo removeFitUpInfo = null;
        for (Iterator<FitUpInfo> it = fitUpInfo.iterator(); it.hasNext(); ) {
            FitUpInfo i = it.next();
            if (i.getId().equals(infoId)) {
                removeFitUpInfo = i;
                break;
            }
        }
        fitUpInfo.remove(removeFitUpInfo);
        return userDao.deleteUserFitUpInfo(user);
    }

    public void setFitUpInfoDao(FitUpInfoDaoImpl fitUpInfoDao) {
        this.fitUpInfoDao = fitUpInfoDao;
    }

}

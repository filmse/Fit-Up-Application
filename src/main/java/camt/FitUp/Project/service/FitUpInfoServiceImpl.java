package camt.FitUp.Project.service;

import camt.FitUp.Project.dao.FitUpInfoDao;
import camt.FitUp.Project.dao.FitUpInfoDaoImpl;
import camt.FitUp.Project.entity.FitUpInfo;
import camt.FitUp.Project.entity.ImageFitUpInfo;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.repository.FitUpInfoRepository;
import camt.FitUp.Project.repository.UserRepository;
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
    UserRepository userRepository;

    @Override
    public FitUpInfo addForum(User user, FitUpInfo fitUpInfo) {
        user.getInfos().add(fitUpInfo);
        fitUpInfoDao.addForum(user, fitUpInfo);
        return fitUpInfo;
    }

    @Override
    @Transactional
    public FitUpInfo addImageForum(FitUpInfo fitUpInfo, ImageFitUpInfo imageFitUpInfo) {
        imageFitUpInfo = ImageUtil.resizeImage(imageFitUpInfo, 200);
        fitUpInfo.getImageInfos().add(imageFitUpInfo);
        fitUpInfoDao.addImageForum(fitUpInfo);
        return fitUpInfo;
    }

    @Override
    public List<FitUpInfo> getInfos() {
        return fitUpInfoDao.getInfos();
    }

    @Override
    public FitUpInfo findByName(String name) {
        return fitUpInfoDao.findByName(name);
    }

    @Override
    public FitUpInfo deleteForum(Long id) {
        FitUpInfo fitUpInfo = getForum(id);
        return fitUpInfoDao.deleteForum(fitUpInfo);
    }

    @Override
    public FitUpInfo getForum(Long id) {
        return fitUpInfoDao.getForum(id);
    }

    @Override
    public FitUpInfo updateForum(FitUpInfo fitUpInfo) {
        return fitUpInfoDao.updateForum(fitUpInfo);
    }

    @Override
    @Transactional
    public FitUpInfo deleteImageForum(FitUpInfo fitUpInfo, Long imageId) {
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
    public User deleteUserForum(User user, Long infoId) {
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
        return userRepository.save(user);
    }

    public void setFitUpInfoDao(FitUpInfoDaoImpl fitUpInfoDao) {
        this.fitUpInfoDao = fitUpInfoDao;
    }

}

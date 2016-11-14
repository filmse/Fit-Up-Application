package camt.FitUp.Project.service;

import camt.FitUp.Project.dao.FavoriteDao;
import camt.FitUp.Project.entity.Favorite;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Film on 10/11/2559.
 */

@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    FavoriteDao favoriteDao;

    @Override
    public Favorite addFavorite(User user, Favorite favorite) {
        return favoriteDao.addFavorite(user, favorite);
    }

    @Override
    public List<Favorite> favoriteList() {
        return favoriteDao.favoriteList();
    }

    @Override
    public Favorite favoriteId(Long id) {
        return favoriteDao.favoriteId(id);
    }


}

package camt.FitUp.Project.dao;

import camt.FitUp.Project.entity.Favorite;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.entity.Video;
import camt.FitUp.Project.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Film on 10/11/2559.
 */

@Repository
public class FavoriteDaoImpl implements FavoriteDao {
    @Autowired
    FavoriteRepository favoriteRepository;

    @Override
    public Favorite addFavorite(User user, Favorite favorite) {
        user.getFavorites().add(favorite);
        favoriteRepository.save(favorite);
        return favorite;
    }

    @Override
    public List<Favorite> favoriteList() {
        return favoriteRepository.findAll();
    }

    @Override
    public Favorite favoriteId(Long id) {
        return favoriteRepository.findOne(id);
    }

}

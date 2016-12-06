package camt.FitUp.Project.dao;

import camt.FitUp.Project.entity.Favorite;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.entity.Video;
import camt.FitUp.Project.repository.FavoriteRepository;
import camt.FitUp.Project.repository.UserRepository;
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

    @Autowired
    UserRepository userRepository;

    @Override
    public Favorite addFavorite(Video video, Favorite favorite, User user) {
        favorite.getVideos().add(video);
        favoriteRepository.save(favorite);
        user.getFavorites().add(favorite);
        userRepository.save(user);
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

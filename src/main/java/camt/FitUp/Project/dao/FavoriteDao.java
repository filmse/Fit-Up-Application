package camt.FitUp.Project.dao;

import camt.FitUp.Project.entity.Favorite;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.entity.Video;

import java.util.List;

/**
 * Created by Film on 10/11/2559.
 */
public interface FavoriteDao {
    Favorite addFavorite(User user, Favorite favorite);

    List<Favorite> favoriteList();

    Favorite favoriteId(Long id);

}

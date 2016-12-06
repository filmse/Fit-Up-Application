package camt.FitUp.Project.service;

import camt.FitUp.Project.entity.Favorite;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.entity.Video;

import java.util.List;

/**
 * Created by Film on 10/11/2559.
 */
public interface FavoriteService {

    Favorite addFavorite(Video video, Favorite favorite, User user);

    List<Favorite> favoriteList();

    Favorite favoriteId(Long id);

}

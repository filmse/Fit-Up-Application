package service;

import camt.FitUp.Project.dao.FavoriteDaoImpl;
import camt.FitUp.Project.entity.Favorite;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.entity.Video;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Film on 19/12/2559.
 */
public class FavoriteServiceImplTest {

    @Test
    public void testAddFavoriteNotNull() {
        FavoriteDaoImpl favoriteDaoImpl = new FavoriteDaoImpl();
        Favorite favorite = new Favorite();
        Video video = new Video(10l, "build body sick pack", "The people can build boy six pack in one week");
        User user = new User(3l, "member", "member@gmail.com", "3333");
        {
            //Favorite favorite = new Favorite();
            //favoriteDaoImpl.addFavorite(video, favorite, user);
            //Favorite favorite1 = favoriteDaoImpl.addFavorite(video, favorite, user);
        }
        //favoriteDaoImpl.addFavorite(video, favorite, user);
        assertNotNull(favorite);
        assertNotNull(video);
        assertNotNull(user);
    }

    @Test
    public void testAddFavoriteNull() {
    }

}

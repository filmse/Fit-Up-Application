package camt.FitUp.Project.service;

import camt.FitUp.Project.entity.ShoppingCart;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.entity.Video;

import java.util.List;

/**
 * Created by Film on 14/10/2559.
 */
public interface ShoppingCartService {
    ShoppingCart addShoppingCart(Video video, ShoppingCart shoppingCart, User user);

    List<ShoppingCart> shoppinglist();

    ShoppingCart shoppingId(Long id);

//    ShoppingCart addSelectedVideo(ShoppingCart shoppingCart, Video video);
//
//    ShoppingCart addShoppingCart(ShoppingCart shoppingCart);
}
package camt.FitUp.Project.dao;

import camt.FitUp.Project.entity.ShoppingCart;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.entity.Video;

import java.util.List;

/**
 * Created by Film on 14/10/2559.
 */
public interface ShoppingCartDao {

    ShoppingCart addShoppingCart(Video video, ShoppingCart shoppingCart, User user);

    List<ShoppingCart> shoppinglist();

    ShoppingCart shoppingId(Long id);

//    ShoppingCart addShoppingCart(ShoppingCart shoppingCart);
}
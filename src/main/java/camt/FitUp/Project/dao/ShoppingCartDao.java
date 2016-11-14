package camt.FitUp.Project.dao;

import camt.FitUp.Project.entity.ShoppingCart;
import camt.FitUp.Project.entity.User;

import java.util.List;

/**
 * Created by Film on 14/10/2559.
 */
public interface ShoppingCartDao {
    ShoppingCart addShoppingCart(User user, ShoppingCart shoppingCart);

    List<ShoppingCart> shoppinglist();

    ShoppingCart shoppingId(Long id);
}
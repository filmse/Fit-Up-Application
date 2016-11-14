package camt.FitUp.Project.service;

import camt.FitUp.Project.entity.ShoppingCart;
import camt.FitUp.Project.entity.User;

import java.util.List;

/**
 * Created by Film on 14/10/2559.
 */
public interface ShoppingCartService {
    ShoppingCart addShoppingCart(User user, ShoppingCart shoppingCart);

    List<ShoppingCart> shoppinglist();

    ShoppingCart shoppingId(Long id);
}
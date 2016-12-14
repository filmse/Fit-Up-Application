package camt.FitUp.Project.service;

import camt.FitUp.Project.entity.*;

import java.util.List;

/**
 * Created by Film on 14/10/2559.
 */
public interface ShoppingCartService {

    ShoppingCart addShoppingCart(Video video, ShoppingCart shoppingCart, User user);

    List<ShoppingCart> shoppinglist();

    ShoppingCart shoppingId(Long id);

    ShoppingCart editShoppingCart(ShoppingCart shoppingCart);


    Transaction addTransaction(Transaction transaction, User user);

    List<Transaction> transactionList();

    ShoppingCart deleteShoppingCart(Long shoppingId);

    VideoPurchased addVideoPurchased(VideoPurchased videoPurchased, Video video, User user);
}
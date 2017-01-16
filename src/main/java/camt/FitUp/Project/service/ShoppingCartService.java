package camt.FitUp.Project.service;

import camt.FitUp.Project.entity.*;

import java.util.List;

/**
 * Created by Film on 14/10/2559.
 */
public interface ShoppingCartService {

    Payment addShoppingCart(Video video, Payment payment, User user);

    List<Payment> shoppinglist();

    Payment shoppingId(Long id);

    Payment editShoppingCart(Payment payment);

    Transaction addTransaction(Transaction transaction, User user);

    List<Transaction> transactionList();

    Payment deleteShoppingCart(Long shoppingId);

    VideoPurchased addVideoPurchased(VideoPurchased videoPurchased, Video video, User user);
}
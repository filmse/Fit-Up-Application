package camt.FitUp.Project.dao;

import camt.FitUp.Project.entity.*;
import camt.FitUp.Project.repository.ShoppingCartRepository;
import camt.FitUp.Project.repository.TransactionRepository;
import camt.FitUp.Project.repository.UserRepository;
import camt.FitUp.Project.repository.VideoPurchasedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Film on 14/10/2559.
 */
@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDao {

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    VideoPurchasedRepository videoPurchasedRepository;

    @Override
    public ShoppingCart addShoppingCart(Video video, ShoppingCart shoppingCart, User user) {
        shoppingCart.getVideos().add(video);
        shoppingCartRepository.save(shoppingCart);
        user.getShoppingCarts().add(shoppingCart);
        userRepository.save(user);
        return shoppingCart;
    }

    @Override
    public List<ShoppingCart> shoppinglist() {
        return shoppingCartRepository.findAll();
    }

    @Override
    public ShoppingCart shoppingId(Long id) {
        return shoppingCartRepository.findOne(id);
    }

    @Override
    public ShoppingCart editShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public Transaction addTransaction(Transaction transaction, User user) {
        transaction.getUsers().add(user);
        transactionRepository.save(transaction);
        return transaction;
    }

    @Override
    public List<Transaction> transactionList() {
        return transactionRepository.findAll();
    }

    @Override
    public ShoppingCart deleteShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartRepository.delete(shoppingCart);
        shoppingCart.setId(null);
        return shoppingCart;
    }

    @Override
    public VideoPurchased videoPurchased(VideoPurchased videoPurchased, Video video, User user) {
        videoPurchased.getVideos().add(video);
        videoPurchasedRepository.save(videoPurchased);
        user.getVideoPurchaseds().add(videoPurchased);
        userRepository.save(user);
        return videoPurchased;
    }

}
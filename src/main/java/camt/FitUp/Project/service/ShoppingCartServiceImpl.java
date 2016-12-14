package camt.FitUp.Project.service;

import camt.FitUp.Project.dao.ShoppingCartDao;
import camt.FitUp.Project.entity.*;
import camt.FitUp.Project.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Film on 14/10/2559.
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    ShoppingCartDao shoppingCartDao;

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Override
    public ShoppingCart addShoppingCart(Video video, ShoppingCart shoppingCart, User user) {
        shoppingCart.setPurchaseDate(Calendar.getInstance().getTime());
        return shoppingCartDao.addShoppingCart(video, shoppingCart, user);
    }

    @Override
    public List<ShoppingCart> shoppinglist() {
        return shoppingCartDao.shoppinglist();
    }

    @Override
    public ShoppingCart shoppingId(Long id) {
        return shoppingCartDao.shoppingId(id);
    }

    @Override
    public ShoppingCart editShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartDao.editShoppingCart(shoppingCart);
    }

    @Override
    public Transaction addTransaction(Transaction transaction, User user) {
        return shoppingCartDao.addTransaction(transaction, user);
    }

    @Override
    public List<Transaction> transactionList() {
        return shoppingCartDao.transactionList();
    }

    @Override
    public ShoppingCart deleteShoppingCart(Long shoppingId) {
        ShoppingCart shoppingCart = shoppingId(shoppingId);
        return shoppingCartDao.deleteShoppingCart(shoppingCart);
    }

    @Override
    public VideoPurchased addVideoPurchased(VideoPurchased videoPurchased, Video video, User user) {
        return shoppingCartDao.videoPurchased(videoPurchased, video, user);
    }

}

package camt.FitUp.Project.service;

import camt.FitUp.Project.dao.ShoppingCartDao;
import camt.FitUp.Project.entity.ShoppingCart;
import camt.FitUp.Project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Film on 14/10/2559.
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    ShoppingCartDao shoppingCartDao;

    @Override
    public ShoppingCart addShoppingCart(User user, ShoppingCart shoppingCart) {
        return shoppingCartDao.addShoppingCart(user, shoppingCart);
    }

    @Override
    public List<ShoppingCart> shoppinglist() {
        return shoppingCartDao.shoppinglist();
    }

    @Override
    public ShoppingCart shoppingId(Long id) {
        return shoppingCartDao.shoppingId(id);
    }
}
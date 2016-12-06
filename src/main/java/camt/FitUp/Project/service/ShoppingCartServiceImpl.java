package camt.FitUp.Project.service;

import camt.FitUp.Project.dao.ShoppingCartDao;
import camt.FitUp.Project.entity.ShoppingCart;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Film on 14/10/2559.
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    ShoppingCartDao shoppingCartDao;

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

}

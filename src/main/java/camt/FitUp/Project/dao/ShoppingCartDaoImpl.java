package camt.FitUp.Project.dao;

import camt.FitUp.Project.entity.ShoppingCart;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.entity.Video;
import camt.FitUp.Project.repository.ShoppingCartRepository;
import camt.FitUp.Project.repository.UserRepository;
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

}
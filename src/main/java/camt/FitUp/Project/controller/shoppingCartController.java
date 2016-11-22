package camt.FitUp.Project.controller;

import camt.FitUp.Project.entity.ShoppingCart;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.service.ShoppingCartService;
import camt.FitUp.Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Film on 14/10/2559.
 */
@CrossOrigin
@RestController
@RequestMapping("/")
public class shoppingCartController {

    @Autowired
    UserService userService;

    @Autowired
    ShoppingCartService shoppingCartService;

    @RequestMapping(value = "shopping", method = RequestMethod.POST)
    @ResponseBody
    public ShoppingCart addShoppingCart(@RequestParam("userId") Long userId, @RequestBody ShoppingCart shoppingCart, BindingResult bindingResult) {
        User user = userService.getUser(userId);
        return shoppingCartService.addShoppingCart(user, shoppingCart);


    }

    @RequestMapping(value = "shoppingList", method = RequestMethod.GET)
    public List<ShoppingCart> shoppinglist() {
        return shoppingCartService.shoppinglist();
    }

    @RequestMapping(value = "shoppingList/{id}", method = RequestMethod.GET)
    public ShoppingCart shoppingId(@PathVariable("id") Long id) {
        return shoppingCartService.shoppingId(id);
    }

}
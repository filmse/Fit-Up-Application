package camt.FitUp.Project.controller;

import camt.FitUp.Project.entity.ShoppingCart;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.entity.Video;
import camt.FitUp.Project.service.ShoppingCartService;
import camt.FitUp.Project.service.UserService;
import camt.FitUp.Project.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Film on 14/10/2559.
 */
@CrossOrigin
@RestController
@RequestMapping("/")
@Scope("session")
public class shoppingCartController {

    @Autowired
    UserService userService;

    @Autowired
    ShoppingCartService shoppingCartService;

    @Autowired
    VideoService videoService;

    @RequestMapping(value = "shopping", method = RequestMethod.POST)
    @ResponseBody
    public ShoppingCart addShoppingCart(@RequestParam("videoId") Long videoId, @RequestParam("userId") Long userId, @RequestBody ShoppingCart shoppingCart, BindingResult bindingResult) {
        Video video = videoService.getVideo(videoId);
        User user = userService.getUser(userId);
        return shoppingCartService.addShoppingCart(video, shoppingCart, user);
    }

//    @RequestMapping(value = "shoppingAddUser/{id}", method = RequestMethod.POST)
//    @ResponseBody
//    public ShoppingCart shoppingAddUserService(@PathVariable("id") Long userId, @RequestBody ShoppingCart shoppingCart, BindingResult bindingResult) {
//        User user = userService.getUser(userId);
//        return shoppingCartService.shoppingAddUserService(user, shoppingCart);
//    }

    @RequestMapping(value = "shoppingList", method = RequestMethod.GET)
    public List<ShoppingCart> shoppinglist() {
        return shoppingCartService.shoppinglist();
    }

    @RequestMapping(value = "shoppingList/{id}", method = RequestMethod.GET)
    public ShoppingCart shoppingId(@PathVariable("id") Long id) {
        return shoppingCartService.shoppingId(id);
    }

}
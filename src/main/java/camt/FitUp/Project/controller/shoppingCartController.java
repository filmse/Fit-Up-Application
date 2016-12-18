package camt.FitUp.Project.controller;

import camt.FitUp.Project.entity.*;
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
    public Payment addShoppingCart(@RequestParam("videoId") Long videoId, @RequestParam("userId") Long userId, @RequestBody Payment payment, BindingResult bindingResult) {
        Video video = videoService.getVideo(videoId);
        User user = userService.getUser(userId);
        return shoppingCartService.addShoppingCart(video, payment, user);
    }

    @RequestMapping(value = "shoppingList", method = RequestMethod.GET)
    public List<Payment> shoppinglist() {
        return shoppingCartService.shoppinglist();
    }

    @RequestMapping(value = "shoppingList/{id}", method = RequestMethod.GET)
    public Payment shoppingId(@PathVariable("id") Long id) {
        return shoppingCartService.shoppingId(id);
    }

    @RequestMapping(value = "transaction", method = RequestMethod.POST)
    public Transaction addTransaction(@RequestParam("userId") Long userId, @RequestBody Transaction transaction, BindingResult bindingResult) {
        User user = userService.getUser(userId);
        return shoppingCartService.addTransaction(transaction, user);
    }

    @RequestMapping(value = "transactionList", method = RequestMethod.GET)
    public List<Transaction> transactionList() {
        return shoppingCartService.transactionList();
    }

    @RequestMapping(value = "purchased", method = RequestMethod.POST)
    public VideoPurchased addVideoPurchased(@RequestParam("videoId") Long videoId,@RequestParam("userId") Long userId, @RequestBody VideoPurchased videoPurchased, BindingResult bindingResult) {
        Video video = videoService.getVideo(videoId);
        User user = userService.getUser(userId);
        return shoppingCartService.addVideoPurchased(videoPurchased, video, user);
    }

}
package camt.FitUp.Project.controller;

import camt.FitUp.Project.entity.Favorite;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.entity.Video;
import camt.FitUp.Project.service.FavoriteService;
import camt.FitUp.Project.service.UserService;
import camt.FitUp.Project.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Film on 10/11/2559.
 */

@CrossOrigin
@RestController
@RequestMapping("/")
public class AddFavoriteController {

    @Autowired
    UserService userService;

    @Autowired
    FavoriteService favoriteService;

    @Autowired
    VideoService videoService;

    @RequestMapping(value = "addToFavorite", method = RequestMethod.POST)
    @ResponseBody
    public Favorite addFavorite(@RequestParam("videoId") Long videoId, @RequestParam("userId") Long userId, @RequestBody Favorite favorite, BindingResult bindingResult) {
        Video video = videoService.getVideo(videoId);
        User user = userService.getUser(userId);
        return favoriteService.addFavorite(video, favorite, user);
    }

    @RequestMapping(value = "getToFavorite", method = RequestMethod.GET)
    public List<Favorite> favoriteList() {
        return favoriteService.favoriteList();
    }

    @RequestMapping(value = "getToFavoriteIdService/{id}", method = RequestMethod.GET)
    public Favorite favoriteId(@PathVariable("id") Long id) {
        return favoriteService.favoriteId(id);
    }

}

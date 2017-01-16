package camt.FitUp.Project.controller;

import camt.FitUp.Project.entity.ImageUser;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Iterator;

/**
 * Created by Film on 25/7/2559.
 */
@CrossOrigin
@Controller
@RequestMapping("/userImage")

public class UserImageController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public User addImageUser(HttpServletRequest request,
                             HttpServletResponse response, @RequestParam("userId") Long userId) {
        MultipartHttpServletRequest mRequest;
        User user = userService.getUser(userId);

        try {
            mRequest = (MultipartHttpServletRequest) request;
            Iterator<String> itr = mRequest.getFileNames();
            while (itr.hasNext()) {
                MultipartFile multipartFile = mRequest.getFile(itr.next());
                ImageUser image = new ImageUser();
                image.setFileName(multipartFile.getOriginalFilename());
                image.setContentType(multipartFile.getContentType());
                image.setContent(multipartFile.getBytes());
                image.setCreated(Calendar.getInstance().getTime());
                userService.addImageUser(user, image);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    @ResponseBody
    public User deleteImageUser(@RequestParam("imageId") Long imageId, @RequestParam("userId") Long userId) {
        User user = userService.getUser(userId);
        return userService.deleteImageUser(user, imageId);
    }
}

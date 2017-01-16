package camt.FitUp.Project.controller;

import camt.FitUp.Project.entity.FitUpInfo;
import camt.FitUp.Project.entity.ImageFitUpInfo;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.service.FitUpInfoService;
import camt.FitUp.Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Dto on 2/8/2015.
 */
@CrossOrigin
@RestController
@RequestMapping("/")
public class FitUpInfoController {

    @Autowired
    FitUpInfoService fitUpInfoService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "info", method = RequestMethod.POST)
    @ResponseBody
    public FitUpInfo add(@RequestParam("userId") Long userId, @RequestBody FitUpInfo fitUpInfo, BindingResult bindingResult) {
        User user = userService.getUser(userId);
        return fitUpInfoService.addFitUpInfo(user, fitUpInfo);
    }

    @RequestMapping(value = "/infoImage/add", method = RequestMethod.POST)
    @ResponseBody
    public FitUpInfo addImage(HttpServletRequest request,@RequestParam("infoId") Long infoId) {
        MultipartHttpServletRequest mRequest;
        FitUpInfo fitUpInfo = fitUpInfoService.getFitUpInfo(infoId);
        try {
            mRequest = (MultipartHttpServletRequest) request;
            Iterator<String> itr = mRequest.getFileNames();
            while (itr.hasNext()) {
                MultipartFile multipartFile = mRequest.getFile(itr.next());
                ImageFitUpInfo imageFitUpInfo = new ImageFitUpInfo();
                imageFitUpInfo.setFileName(multipartFile.getOriginalFilename());
                imageFitUpInfo.setContentType(multipartFile.getContentType());
                imageFitUpInfo.setContent(multipartFile.getBytes());
                imageFitUpInfo.setCreated(Calendar.getInstance().getTime());
                fitUpInfoService.addImageFitUpInfo(fitUpInfo, imageFitUpInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fitUpInfo;
    }

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public List<FitUpInfo> list() {
        return fitUpInfoService.getFitUpInfos();
    }

    @RequestMapping(value = "getInfo", method = RequestMethod.GET)
    public FitUpInfo findByName(@RequestParam("name") String name) {
        return fitUpInfoService.findByName(name);
    }

    @RequestMapping(value = "info/{id}", method = RequestMethod.PUT)
    public FitUpInfo edit(@PathVariable("id") Long id,
                          @RequestParam("name") String name,
                          @RequestParam("description") String description) {
        FitUpInfo fitUpInfo = fitUpInfoService.getFitUpInfo(id);
        fitUpInfo.setName(name);
        fitUpInfo.setDescription(description);
        return fitUpInfoService.updateFitUpInfo(fitUpInfo);
    }

    @RequestMapping(value = "info/{id}", method = RequestMethod.DELETE)
    public FitUpInfo delete(@PathVariable("id") Long id) {
        return fitUpInfoService.deleteFitUpInfo(id);
    }

    @RequestMapping(value = "info/{id}", method = RequestMethod.GET)
    public FitUpInfo getInfo(@PathVariable("id") Long id) {
        return fitUpInfoService.getFitUpInfo(id);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public User deleteInfo(@RequestParam("infoId") Long infoId, @RequestParam("userId") Long userId) {
        User user = userService.getUser(userId);
        return fitUpInfoService.deleteUserFitUpInfo(user, infoId);
    }

    @RequestMapping(value = "/removeImage", method = RequestMethod.DELETE)
    @ResponseBody
    public FitUpInfo deleteImageUser(@RequestParam("imageId") Long imageId, @RequestParam("infoId") Long infoId) {
        FitUpInfo fitUpInfo = fitUpInfoService.getFitUpInfo(infoId);
        return fitUpInfoService.deleteImageFitUpInfo(fitUpInfo, imageId);
    }
}

package camt.FitUp.Project.controller;

import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.entity.Video;
import camt.FitUp.Project.service.UserService;
import camt.FitUp.Project.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by Film on 24/9/2559.
 */

@CrossOrigin
@RestController
@RequestMapping("/")
public class VideoController {
    @Autowired
    UserService userService;

    @Autowired
    VideoService videoService;

    @RequestMapping(value = "video", method = RequestMethod.POST)
    @ResponseBody
    Video add(@RequestParam("userId") Long userId, @RequestBody Video video, BindingResult bindingResult) {
        User user = userService.getUser(userId);
        return videoService.addVideo(user, video);
    }

    @RequestMapping(value = "video/{id}", method = RequestMethod.GET)
    public Video getVideo(@PathVariable("id") Long id) {
        return videoService.getVideo(id);
    }

    @RequestMapping(value = "video", method = RequestMethod.GET)
    public List<Video> list(HttpServletRequest request) throws IOException {
//        HashSet<VideoClip> videoClips = new HashSet<>();
//        for (int i = 0; i < videoService.getvideos().size(); i++) {
//            for (VideoClip v1 : videoService.getvideos().get(i).getVideoClips()) {
//                //  Path path = new Paths.("C:\\Users\\Film\\AppData\\Local\\Temp\\tomcat-docbase.7283868075101832394.8080\\video");
//                try {
//                    //C:\Users\Film\AppData\Local\Temp\tomcat-docbase.7283868075101832394.8080\video\
//                    byte[] file = Files.readAllBytes(new File("C:\\Users\\Film\\Documents\\ProjectFit-Up\\FitUp\\www\\templates\\video\\" + videoService.getvideos().get(i).getId() + v1.getId() + ".mp4").toPath());
//                    v1.setContent(file);
//                    videoClips.add(v1);
//                    ///videoService.getvideos().get(i).;
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            ///videoService.getvideos().get(i).setVideoClips();
//            videoService.getvideos().get(i).setVideoClips(videoClips);
//            videoClips = new HashSet<>();
//        }
        return videoService.getvideos();
    }

    @RequestMapping(value = "videoName", method = RequestMethod.GET)
    public Video getListByName(@RequestParam("name") String name) {
        return videoService.getListByName(name);
    }

    @RequestMapping(value = "video/{id}", method = RequestMethod.PUT)
    public Video edit(@PathVariable("id") Long id,
                      @RequestParam("name") String name,
                      @RequestParam("description") String description,
                      @RequestParam("price") String price) {
        Video video = videoService.getVideo(id);
        video.setName(name);
        video.setDescription(description);
        video.setPrice(price);
        return videoService.updateVideo(video);
    }

    @RequestMapping(value = "/removeVideo", method = RequestMethod.DELETE)
    public User deleteVideo(@RequestParam("videoId") Long videoId, @RequestParam("userId") Long userId) {
        User user = userService.getUser(userId);
        return videoService.deleteUserVideo(user, videoId);
    }

    @RequestMapping(value = "/removeVideoClip", method = RequestMethod.DELETE)
    @ResponseBody
    public Video deleteVideoClip(@RequestParam("videoClipId") Long videoClipId, @RequestParam("videoId") Long videoId) {
        Video video = videoService.getVideo(videoId);
        return videoService.deleteVideoClip(video, videoClipId);
    }

    //    @RequestMapping(value="/play/{id}", method=RequestMethod.GET)
//    public  void getMedia(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws IOException
//    {
//        Video video = videoService.getVideo(id);
//        //logic for getting path to media on server
//        String path =  "C:\\Users\\Film\\Documents\\Fit-Up-Application\\src\\main\\resources\\video\\"++"mp4";///context.getRealPath("//video//Fitness run");
//
//        System.out.print("makky"+path);
//        ///return "makky"+path;
//        byte[] bytes = Files.readAllBytes(Paths.get(path));
//        response.getOutputStream().write(bytes);
//    }

//    @RequestMapping(value = "/playVideo/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public void  home(@PathVariable("id") Long id,Locale locale, Model model, HttpServletRequest    request, HttpServletResponse response) throws IOException {
//       /// logger.info("Welcome home! The client locale is {}.", locale);
//         VideoClip videoClip = videoClipRepository.findOne(id);
//        String filePath = "C:\\Users\\Film\\Documents\\Fit-Up-Application\\src\\main\\resources\\video\\"+videoClip.getId()+".mp4";
//        int fileSize = (int) new File(filePath).length();
//        response.setContentLength(fileSize);
//        response.setContentType("video");
//        FileInputStream inputStream = new FileInputStream(filePath);
//        ServletOutputStream outputStream = response.getOutputStream();
//       int value = IOUtils.copy(inputStream, outputStream);
//        System.out.println("File Size :: "+fileSize);
//        System.out.println("Copied Bytes :: "+value);
//        IOUtils.closeQuietly(inputStream);
//        IOUtils.closeQuietly(outputStream);
//       /// response.setBufferSize(fileSize);
//    }


}

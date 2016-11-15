package camt.FitUp.Project.controller;

import camt.FitUp.Project.entity.Video;
import camt.FitUp.Project.entity.VideoClip;
import camt.FitUp.Project.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;

/**
 * Created by Film on 25/9/2559.
 */

@CrossOrigin
@Controller
@RequestMapping("/videoClip")
public class VideoClipController {

    @Autowired
    VideoService videoService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Video addVideoClip(HttpServletRequest request,
                              HttpServletResponse response, @RequestParam("videoId") Long videoId) throws IOException {
        MultipartHttpServletRequest mRequest;
        Video video = videoService.getVideo(videoId);

        try {
            mRequest = (MultipartHttpServletRequest) request;
            Iterator<String> itr = mRequest.getFileNames();
            while (itr.hasNext()) {
                MultipartFile multipartFile = mRequest.getFile(itr.next());

                VideoClip videoClip = new VideoClip();
                videoClip.setFileName(multipartFile.getOriginalFilename());
                videoClip.setContentType(multipartFile.getContentType());
                videoClip.setCreated(Calendar.getInstance().getTime());
                videoClip.setContent(multipartFile.getBytes());
                //System.out.println(context.getRealPath("Save file in folder"));
                //System.out.println("Complete!!!!!");
                Video video1 = videoService.addVideoClip(video, videoClip);
                for (VideoClip v : video1.getVideoClips()) {

//                  File outputFile = new File("C:\\Users\\Film\\Documents\\Application\\src\\main\\resources\\video\\" + video1.getId() + "-" + v.getId() + ".mp4");
                    File outputFile = new File("C:\\Users\\Film\\Documents\\Fit-Up-Application\\FitUp\\www\\templates\\video\\" + multipartFile.getOriginalFilename());
//                    File outputFile = new File("C:\\Users\\Film\\Documents\\Fit-Up\\FitUp\\www\\templates\\video\\" + video1.getId() + "-" + v.getId()+ ".mp4");
                    FileOutputStream outputStream = new FileOutputStream(outputFile);
                    outputStream.write(multipartFile.getBytes());
                }
//                File outputFile = new File("C:\\Users\\Film\\Documents\\Fit-Up-Application\\FitUp\\www\\templates\\video\\" + video1.getId() + ".mp4");
//                FileOutputStream outputStream = new FileOutputStream(outputFile);
//                outputStream.write(multipartFile.getBytes());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return video;
    }

//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    @ResponseBody
//    public Video addVideoClip(HttpServletRequest request,
//                              HttpServletResponse response, @RequestParam("videoId") Long videoId) throws IOException {
//        MultipartHttpServletRequest mRequest;
//        Video video = videoService.getVideo(videoId);
//
//        try {
//            mRequest = (MultipartHttpServletRequest) request;
//            Iterator<String> itr = mRequest.getFileNames();
//            while (itr.hasNext()) {
//                System.out.print("makky");
//                MultipartFile multipartFile = mRequest.getFile(itr.next());
//
//                VideoClip videoClip = new VideoClip();
//                videoClip.setFileName(multipartFile.getOriginalFilename());
//                videoClip.setContentType(multipartFile.getContentType());
//                videoClip.setCreated(Calendar.getInstance().getTime());
//                /// videoClip.setContent(multipartFile.getBytes());
//                //System.out.println(context.getRealPath("Save file in folder"));
//                //System.out.println("Complete!!!!!");
//                Video video1 = videoService.addVideoClip(video, videoClip);
//                for (VideoClip v : video1.getVideoClips()) {
//
////                  File outputFile = new File("C:\\Users\\Film\\Documents\\Application\\src\\main\\resources\\video\\" + video1.getId() + "-" + v.getId() + ".mp4");
//                    File outputFile = new File("C:\\Users\\Film\\Documents\\Fit-Up-Application\\src\\main\\resources\\video\\" + v.getId()+".mp4");
////                    File outputFile = new File("C:\\Users\\Film\\Documents\\Fit-Up\\FitUp\\www\\templates\\video\\" + video1.getId() + "-" + v.getId()+ ".mp4");
//                    FileOutputStream outputStream = new FileOutputStream(outputFile);
//                    outputStream.write(multipartFile.getBytes());
//                }
////                File outputFile = new File("C:\\Users\\Film\\Documents\\Fit-Up-Application\\FitUp\\www\\templates\\video\\" + video1.getId() + ".mp4");
////                FileOutputStream outputStream = new FileOutputStream(outputFile);
////                outputStream.write(multipartFile.getBytes());
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return video;
//    }
}

package camt.FitUp.Project.service;

import camt.FitUp.Project.entity.VideoClip;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.Calendar;

/**
 * Created by Film on 8/11/2559.
 */
public class VideoUtil {

    static VideoUtil videoUtil = null;

    public static VideoUtil getInstance() {
        if (videoUtil == null) {
            videoUtil = new VideoUtil();
        }
        return videoUtil;
    }

    public static VideoClip getVideoClip(String resourcePath) {

        VideoClip videoClip = new VideoClip();
        ClassLoader classLoader = VideoUtil.getInstance().getClass().getClassLoader();
        File file = new File(classLoader.getResource(resourcePath).getFile());

        try {
            videoClip.setFileName(file.getName());
            videoClip.setContentType(Files.probeContentType(file.toPath()));

            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fis.read(buf)) != -1; ) {
                bos.write(buf, 0, readNum);
            }
            videoClip.setContent(bos.toByteArray());
            videoClip.setCreated(Calendar.getInstance().getTime());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return videoClip;
    }

//    public InputStream getResource() throws NoSuchFileException
//    {
//        ClassLoader classLoader = this.getClass().getClassLoader();
//
//        InputStream inputStream = classLoader.getResourceAsStream(filePath);
//
//        if(inputStream == null)
//        {
//            throw new NoSuchFileException("Resource file not found. Note that the current directory is the source folder!");
//        }
//
//        return inputStream;
//    }

}
package camt.FitUp.Project.service;

import camt.FitUp.Project.entity.ImageFitUpInfo;
import camt.FitUp.Project.entity.ImageUser;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.util.Calendar;

/**
 * Created by Dto on 4/23/2015.
 */
public class ImageUtil {


    static ImageUtil imageUtil = null;

    public static ImageUtil getInstance() {
        if (imageUtil == null) {
            imageUtil = new ImageUtil();
        }
        return imageUtil;
    }

    public static ImageUser getImage(String resourcePath) {

        ImageUser image = new ImageUser();
        ClassLoader classLoader = ImageUtil.getInstance().getClass().getClassLoader();
        File file = new File(classLoader.getResource(resourcePath).getFile());

        try {
            image.setFileName(file.getName());
            image.setContentType(Files.probeContentType(file.toPath()));
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fis.read(buf)) != -1; ) {
                bos.write(buf, 0, readNum);
            }
            image.setContent(bos.toByteArray());
            image.setCreated(Calendar.getInstance().getTime());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;

    }

//    public static ImageFitUpInfo getImages(String resourcePath) {
//        ImageFitUpInfo imageForum = new ImageFitUpInfo();
//        ClassLoader classLoader = ImageUtil.getInstance().getClass().getClassLoader();
//
//        File file = new File(classLoader.getResource(resourcePath).getFile());
//
//        try {
//
//            imageForum.setFileName(file.getName());
//            imageForum.setContentType(Files.probeContentType(file.toPath()));
//            FileInputStream fis = new FileInputStream(file);
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            byte[] buf = new byte[1024];
//            for (int readNum; (readNum = fis.read(buf)) != -1; ) {
//                bos.write(buf, 0, readNum);
//            }
//            imageForum.setContent(bos.toByteArray());
//            imageForum.setCreated(Calendar.getInstance().getTime());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return imageForum;
//
//    }

    public static ImageFitUpInfo resizeImage(ImageFitUpInfo imageFitUpInfo, int width) {
        // resize imageFitUpInfo

        InputStream imageStream = new ByteArrayInputStream(imageFitUpInfo.getContent());
        try {
            // change the imageFitUpInfo byte array to Buffer ImageFitUpInfo
            BufferedImage bufferedImage = ImageIO.read(imageStream);
            //Scale the imageFitUpInfo using the default api
            BufferedImage scaledImage = Scalr.resize(bufferedImage, 300);

            //Convert BufferedImage to byte
            // convert BufferedImage to byte array
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(scaledImage, getFileExtension(imageFitUpInfo.getFileName()), baos);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            imageFitUpInfo.setContent(imageInByte);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageFitUpInfo;
    }

    private static String getFileExtension(String fileName) {
        String extension = "";

        int i = fileName.lastIndexOf('.');
        int p = Math.max(fileName.lastIndexOf('/'), fileName.lastIndexOf('\\'));

        if (i > p) {
            extension = fileName.substring(i + 1);
        }
        return extension;
    }


}


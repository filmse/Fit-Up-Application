package service;

import camt.FitUp.Project.dao.VideoDaoImpl;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.entity.Video;
import camt.FitUp.Project.service.VideoServiceImpl;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Film on 19/12/2559.
 */
public class VideoServiceTest {

    @Test
    public void testAddVideoNotNull() {
        Video video = new Video(1l, "build body sick pack", "The Video for build body", "100.00");
        User user = new User(2l, "Trainer", "Trainer@gmail.com", "2222");

        VideoDaoImpl videoDaoImpl = mock(VideoDaoImpl.class);
        videoDaoImpl.addVideo(user, video);
        assertNotNull(user);
        //when(videoDaoImpl.addVideo(user, video)).thenReturn(null);
        //System.out.println(video);
        //System.out.println(user);
//        {
//            Video returnMock = new Video(10l, "build body sick pack", "The Video for build body", "100.00");
//            when(videoDaoImpl.addVideo(user, video)).thenReturn(returnMock);
//        }
//        VideoServiceImpl videoServiceImpl = new VideoServiceImpl();
//        videoServiceImpl.addVideo(user, video);
//        assertNotNull(user);
    }

    @Test
    public void testAddVideoNull() {
        VideoDaoImpl videoDaoImpl = mock(VideoDaoImpl.class);
        Video video = new Video(10l, "build body sick pack", "The Video for build body", "100.00");
        User user = new User(2l, "Trainer", "Trainer@gmail.com", "2222");

        when(videoDaoImpl.addVideo(user, video)).thenReturn(null);
        {
            Video returnMock = new Video(10l, "build body sick pack", "The Video for build body", "100.00");
            when(videoDaoImpl.addVideo(user, video)).thenReturn(returnMock);
        }

        VideoServiceImpl videoServiceImpl = new VideoServiceImpl();
        videoServiceImpl.setVideoDao(videoDaoImpl);

        Video result = videoServiceImpl.setVideoDao(videoDaoImpl);
        assertNull(result);
    }

    @Test
    public void testDeleteVideo() {
    }

}

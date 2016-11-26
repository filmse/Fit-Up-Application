package camt.FitUp.Project.service;

import camt.FitUp.Project.dao.UserDao;
import camt.FitUp.Project.dao.VideoDao;
import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.entity.Video;
import camt.FitUp.Project.entity.VideoClip;
import camt.FitUp.Project.repository.UserRepository;
import camt.FitUp.Project.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Film on 24/9/2559.
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoDao videoDao;

    @Autowired
    VideoRepository videoRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Video addVideo(User user, Video video) {
        user.getVideos().add(video);
        videoDao.addVideo(user, video);
        return video;
    }

    @Override
    public Video getVideo(Long id) {
        return videoDao.getVideo(id);
    }

    @Override
    public Video addVideoClip(Video video, VideoClip videoClip) {
        video.getVideoClips().add(videoClip);
        ////videoRepository.save(video);
        return videoRepository.save(video);
    }

    @Override
    public List<Video> getvideos() {
        return videoRepository.findAll();
    }

    @Override
    public Video getListByName(String name) {
        return videoDao.getListByName(name);
    }

    @Override
    public Video updateVideo(Video video) {
        return videoDao.updateVideo(video);
    }

    @Override
    @Transactional
    public Video deleteVideoClip(Video video, Long videoId) {
        Set<VideoClip> videoClips = video.getVideoClips();
        for (Iterator<VideoClip> it = videoClips.iterator(); it.hasNext(); ) {
            VideoClip f = it.next();
            if (f.getId().equals(videoId)) {
                video.getVideoClips().remove(f);
            }
        }
        videoDao.deleteVideoClip(video);
        return video;
    }

    @Override
    public User deleteUserVideo(User user, Long videoId) {
        Set<Video> video = user.getVideos();
        Video removeVideo = null;
        for (Iterator<Video> it = video.iterator(); it.hasNext(); ) {
            Video i = it.next();
            if (i.getId().equals(videoId)) {
                removeVideo = i;
                break;
            }
        }
        video.remove(removeVideo);
        return userRepository.save(user);
    }

}

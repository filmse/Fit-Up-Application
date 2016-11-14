package camt.FitUp.Project.dao;

import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.entity.Video;
import camt.FitUp.Project.entity.VideoClip;
import camt.FitUp.Project.repository.VideoClipRepository;
import camt.FitUp.Project.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Film on 24/9/2559.
 */

@Repository
public class VideoDaoImpl implements VideoDao {

    @Autowired
    VideoRepository videoRepository;
    @Autowired
    VideoClipRepository videoClipRepository;

    @Override
    public Video addVideo(User user, Video video) {
        videoRepository.save(video);
        return video;
    }

    @Override
    public Video getVideo(Long id) {
        return videoRepository.findOne(id);
    }

    @Override
    public Video getListByName(String name) {
        return videoRepository.findByName(name);
    }

    @Override
    public Video updateVideo(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public Video deleteVideoClip(Video video) {
        videoRepository.delete(video);
        video.setId(null);
        return video;
    }

}

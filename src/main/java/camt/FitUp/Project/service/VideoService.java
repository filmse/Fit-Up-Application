package camt.FitUp.Project.service;

import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.entity.Video;
import camt.FitUp.Project.entity.VideoClip;

import java.util.List;

/**
 * Created by Film on 24/9/2559.
 */
public interface VideoService {

    Video addVideo(User user, Video video);

    Video getVideo(Long id);

    Video addVideoClip(Video video, VideoClip videoClip);

    List<Video> getvideos();

    Video getListByName(String name);

    Video updateVideo(Video video);

    User deleteUserVideo(User user, Long videoId);

    Video deleteVideoClip(Video video, Long videoClipId);

}

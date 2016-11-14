package camt.FitUp.Project.dao;

import camt.FitUp.Project.entity.User;
import camt.FitUp.Project.entity.Video;
import camt.FitUp.Project.entity.VideoClip;

/**
 * Created by Film on 24/9/2559.
 */

public interface VideoDao {

    Video addVideo(User user, Video video);

    Video getVideo(Long id);

    Video getListByName(String name);

    Video updateVideo(Video video);

    Video deleteVideoClip(Video video);

}

package camt.FitUp.Project.repository;

import camt.FitUp.Project.entity.Video;
import camt.FitUp.Project.entity.VideoClip;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dto on 2/9/2015.
 */

public interface VideoRepository extends JpaRepository<Video, Long> {
    Video findByName(String name);
}

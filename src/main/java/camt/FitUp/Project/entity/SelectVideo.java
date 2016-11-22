package camt.FitUp.Project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by Film on 17/11/2559.
 */
@Entity
public class SelectVideo {

    @Id
    @GeneratedValue
    Long id;
    @OneToOne
    Video video;

    public SelectVideo(Video video) {
        this.video = video;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SelectVideo that = (SelectVideo) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return !(video != null ? !video.equals(that.video) : that.video != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (video != null ? video.hashCode() : 0);
        return result;
    }


}

package camt.FitUp.Project.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Film on 14/12/2559.
 */

@Entity
public class VideoPurchased {
    @Id
    @GeneratedValue
    Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Video> videos = new HashSet<>();

    public VideoPurchased(Set<Video> videos) {
        this.videos = videos;
    }

    public  VideoPurchased(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Video> getVideos() {
        return videos;
    }

    public void setVideos(Set<Video> videos) {
        this.videos = videos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VideoPurchased that = (VideoPurchased) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return videos != null ? videos.equals(that.videos) : that.videos == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (videos != null ? videos.hashCode() : 0);
        return result;
    }
}

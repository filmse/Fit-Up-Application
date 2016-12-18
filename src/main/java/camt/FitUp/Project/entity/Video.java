package camt.FitUp.Project.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dto on 2/7/2015.
 */
@Entity
public class Video implements Comparable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String price;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    Set<VideoClip> videoClips = new HashSet<>();

    public Video(String name, String description, String price, Set<VideoClip> videoClips, Set<Payment> payments) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.videoClips = videoClips;

    }

    public Video(String name, String description, String price, Set<VideoClip> videoClips) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.videoClips = videoClips;
    }

    public Video(Long id, String name, String description, String price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Video() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<VideoClip> getVideoClips() {
        return videoClips;
    }

    public void setVideoClips(Set<VideoClip> videoClips) {
        this.videoClips = videoClips;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Video)) return false;

        Video video = (Video) o;

        if (id != null ? !id.equals(video.id) : video.id != null) return false;
        if (name != null ? !name.equals(video.name) : video.name != null) return false;
        if (description != null ? !description.equals(video.description) : video.description != null) return false;
        if (price != null ? !price.equals(video.price) : video.price != null) return false;
        if (videoClips != null ? !videoClips.equals(video.videoClips) : video.videoClips != null) return false;
        return true;
    }

    @Override
    public int hashCode() {

        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    public Video(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public int compareTo(Object o) {

        return (int) (this.getId() - ((Video) o).getId());
    }
}

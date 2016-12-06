//package camt.FitUp.Project.entity;
//
//import org.hibernate.annotations.Cascade;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Created by Film on 10/11/2559.
// */
//@Entity
//public class Favorite {
//
//    @Id
//    @GeneratedValue
//    Long id;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Favorite that = (Favorite) o;
//
//        return !(id != null ? !id.equals(that.id) : that.id != null);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id != null ? id.hashCode() : 0;
//        return result;
//    }
//}

package camt.FitUp.Project.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dto on 2/7/2015.
 */
@Entity
public class Favorite {
    @Id
    @GeneratedValue
    Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Video> videos = new HashSet<>();

    public Set<Video> getVideos() {
        return videos;
    }

    public void setVideos(Set<Video> videos) {
        this.videos = videos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
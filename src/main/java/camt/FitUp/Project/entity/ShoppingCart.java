package camt.FitUp.Project.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dto on 2/7/2015.
 */
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue
    Long id;

    @Temporal(TemporalType.TIMESTAMP)
    Date purchaseDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Video> videos = new HashSet<>();

    public ShoppingCart(Date purchaseDate, Set<Video> videos) {
        this.purchaseDate = purchaseDate;
        this.videos = videos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingCart that = (ShoppingCart) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (purchaseDate != null ? !purchaseDate.equals(that.purchaseDate) : that.purchaseDate != null) return false;
        return videos != null ? videos.equals(that.videos) : that.videos == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (purchaseDate != null ? purchaseDate.hashCode() : 0);
        result = 31 * result + (videos != null ? videos.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Set<Video> getVideos() {
        return videos;
    }

    public void setVideos(Set<Video> videos) {
        this.videos = videos;
    }

    public ShoppingCart() {
        this.setPurchaseDate(Calendar.getInstance().getTime());
    }


}
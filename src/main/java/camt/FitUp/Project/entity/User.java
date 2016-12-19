package camt.FitUp.Project.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dto on 4/19/2015.
 */
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<ImageUser> images = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<FitUpInfo> infos = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Video> videos = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Payment> payments = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Favorite> favorites = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<VideoPurchased> videoPurchaseds = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (roles != null ? !roles.equals(user.roles) : user.roles != null) return false;
        if (images != null ? !images.equals(user.images) : user.images != null) return false;
        if (infos != null ? !infos.equals(user.infos) : user.infos != null) return false;
        if (videos != null ? !videos.equals(user.videos) : user.videos != null) return false;
        if (payments != null ? !payments.equals(user.payments) : user.payments != null)
            return false;
        if (favorites != null ? !favorites.equals(user.favorites) : user.favorites != null) return false;
        return videoPurchaseds != null ? videoPurchaseds.equals(user.videoPurchaseds) : user.videoPurchaseds == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        result = 31 * result + (images != null ? images.hashCode() : 0);
        result = 31 * result + (infos != null ? infos.hashCode() : 0);
        result = 31 * result + (videos != null ? videos.hashCode() : 0);
        result = 31 * result + (payments != null ? payments.hashCode() : 0);
        result = 31 * result + (favorites != null ? favorites.hashCode() : 0);
        result = 31 * result + (videoPurchaseds != null ? videoPurchaseds.hashCode() : 0);
        return result;
    }

    public User(String username, String email, String password, Set<Role> roles, Set<ImageUser> images, Set<FitUpInfo> infos, Set<Video> videos, Set<Payment> payments, Set<Favorite> favorites, Set<VideoPurchased> videoPurchaseds) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.images = images;
        this.infos = infos;
        this.videos = videos;
        this.payments = payments;
        this.favorites = favorites;
        this.videoPurchaseds = videoPurchaseds;
    }

    public User(String username, String email, String password, Set<Role> roles, Set<ImageUser> images, Set<FitUpInfo> infos, Set<Video> videos, Set<Payment> payments, Set<Favorite> favorites) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.images = images;
        this.infos = infos;
        this.videos = videos;
        this.payments = payments;
        this.favorites = favorites;
    }

    public User(String username, String email, String password, Set<Role> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public User(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password, Set<Role> roles, Set<ImageUser> images, Set<FitUpInfo> infos) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.images = images;
        this.infos = infos;
    }

    public User(String username, String email, String password, Set<Role> roles, Set<ImageUser> images, Set<FitUpInfo> infos, Set<Video> videos) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.images = images;
        this.infos = infos;
        this.videos = videos;
    }

    //@PreUpdate
    //@PrePersist
    //public void setLastUpdate() {
    //   this.setPassword(new BCryptPasswordEncoder(10).encode(this.getPassword()));
    //}


    public Set<VideoPurchased> getVideoPurchaseds() {
        return videoPurchaseds;
    }

    public void setVideoPurchaseds(Set<VideoPurchased> videoPurchaseds) {
        this.videoPurchaseds = videoPurchaseds;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    public User() {
    }

    public Set<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Favorite> favorites) {
        this.favorites = favorites;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<ImageUser> getImages() {
        return images;
    }

    public void setImages(Set<ImageUser> images) {
        this.images = images;
    }

    public Set<FitUpInfo> getInfos() {
        return infos;
    }

    public void setInfos(Set<FitUpInfo> infos) {
        this.infos = infos;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", infos=" + infos +
                ", videos=" + videos +
                ", images=" + images +
                '}';
    }

}

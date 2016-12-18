package camt.FitUp.Project.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Film on 2/7/2015.
 */
@Entity
public class FitUpInfo implements Comparable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<ImageFitUpInfo> imageInfos = new HashSet<>();

    public FitUpInfo(Long id, String name, String description, ImageFitUpInfo imageFitUpInfo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageInfos.add(imageFitUpInfo);
    }

    public Set<ImageFitUpInfo> getImageInfos() {
        return imageInfos;
    }

    public void setImageInfos(Set<ImageFitUpInfo> imageInfos) {
        this.imageInfos = imageInfos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FitUpInfo() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FitUpInfo)) return false;

        FitUpInfo fitUpInfo = (FitUpInfo) o;

        if (description != null ? !description.equals(fitUpInfo.description) : fitUpInfo.description != null)
            return false;
        if (id != null ? !id.equals(fitUpInfo.id) : fitUpInfo.id != null) return false;
        if (name != null ? !name.equals(fitUpInfo.name) : fitUpInfo.name != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    public FitUpInfo(Long id, String name, String description) {
        this.name = name;
        this.description = description;
        this.id = id;
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
    public int compareTo(Object o) {

        return (int) (this.getId() - ((FitUpInfo) o).getId());
    }
}

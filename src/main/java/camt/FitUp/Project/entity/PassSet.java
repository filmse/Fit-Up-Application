package camt.FitUp.Project.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Film on 5/11/2559.
 */

@Entity
public class PassSet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String passSet;

    public PassSet(String passSet) {
        this.passSet = passSet;
    }

    public PassSet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassSet() {
        return passSet;
    }

    public void setPassSet(String passSet) {
        this.passSet = passSet;
    }

    @Override
    public String toString() {
        return "passSet{" +
                "id=" + id +
                ", passSet='" + passSet + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (passSet != null ? passSet.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PassSet passSet = (PassSet) o;

        if (id != null ? !id.equals(passSet.id) : passSet.id != null) return false;
        if (passSet != null ? !passSet.equals(passSet.passSet) : passSet.passSet != null) return false;
        return !(passSet != null ? !passSet.equals(passSet.passSet) : passSet.passSet != null);
    }

}

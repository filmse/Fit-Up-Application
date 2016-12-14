package camt.FitUp.Project.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Film on 14/12/2559.
 */

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    Long id;

    private String confirmEmail;
    private String confirmTime;
    private String confirmMoney;
    private String confirmSecretId;

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<User> users = new HashSet<>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Transaction(String confirmEmail, String confirmTime, String confirmMoney, String confirmSecretId, Set<User> users) {
        this.confirmEmail = confirmEmail;
        this.confirmTime = confirmTime;
        this.confirmMoney = confirmMoney;
        this.confirmSecretId = confirmSecretId;
        this.users = users;
    }

    public Transaction(String confirmEmail, String confirmTime, String confirmMoney, String confirmSecretId) {
        this.confirmEmail = confirmEmail;
        this.confirmTime = confirmTime;
        this.confirmMoney = confirmMoney;
        this.confirmSecretId = confirmSecretId;
    }

    public Transaction() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (confirmEmail != null ? !confirmEmail.equals(that.confirmEmail) : that.confirmEmail != null) return false;
        if (confirmTime != null ? !confirmTime.equals(that.confirmTime) : that.confirmTime != null) return false;
        if (confirmMoney != null ? !confirmMoney.equals(that.confirmMoney) : that.confirmMoney != null) return false;
        return confirmSecretId != null ? confirmSecretId.equals(that.confirmSecretId) : that.confirmSecretId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (confirmEmail != null ? confirmEmail.hashCode() : 0);
        result = 31 * result + (confirmTime != null ? confirmTime.hashCode() : 0);
        result = 31 * result + (confirmMoney != null ? confirmMoney.hashCode() : 0);
        result = 31 * result + (confirmSecretId != null ? confirmSecretId.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

    public String getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(String confirmTime) {
        this.confirmTime = confirmTime;
    }

    public String getConfirmMoney() {
        return confirmMoney;
    }

    public void setConfirmMoney(String confirmMoney) {
        this.confirmMoney = confirmMoney;
    }

    public String getConfirmSecretId() {
        return confirmSecretId;
    }

    public void setConfirmSecretId(String confirmSecretId) {
        this.confirmSecretId = confirmSecretId;
    }
}

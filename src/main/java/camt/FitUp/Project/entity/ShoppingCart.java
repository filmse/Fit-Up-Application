package camt.FitUp.Project.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

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

    public ShoppingCart(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingCart that = (ShoppingCart) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return !(purchaseDate != null ? !purchaseDate.equals(that.purchaseDate) : that.purchaseDate != null);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (purchaseDate != null ? purchaseDate.hashCode() : 0);
        return result;
    }

    public ShoppingCart() {
        this.setPurchaseDate(Calendar.getInstance().getTime());
    }
}
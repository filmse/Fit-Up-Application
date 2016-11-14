package camt.FitUp.Project.repository;

import camt.FitUp.Project.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Film on 14/10/2559.
 */
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}

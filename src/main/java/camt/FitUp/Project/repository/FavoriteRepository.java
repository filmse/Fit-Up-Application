package camt.FitUp.Project.repository;

import camt.FitUp.Project.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Film on 10/11/2559.
 */

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
}

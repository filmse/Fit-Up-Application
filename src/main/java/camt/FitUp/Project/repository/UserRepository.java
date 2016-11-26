package camt.FitUp.Project.repository;

import camt.FitUp.Project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dto on 4/19/2015.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);


}

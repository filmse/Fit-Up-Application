package camt.FitUp.Project.repository;

import camt.FitUp.Project.entity.FitUpInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dto on 2/9/2015.
 */

public interface FitUpInfoRepository extends JpaRepository<FitUpInfo,Long>{
    FitUpInfo findByName(String name);
}

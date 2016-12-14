package camt.FitUp.Project.repository;

import camt.FitUp.Project.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Film on 14/12/2559.
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}

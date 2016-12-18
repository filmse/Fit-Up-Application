package camt.FitUp.Project.repository;

import camt.FitUp.Project.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Film on 14/10/2559.
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

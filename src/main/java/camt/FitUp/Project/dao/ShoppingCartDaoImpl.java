package camt.FitUp.Project.dao;

import camt.FitUp.Project.entity.*;
import camt.FitUp.Project.repository.PaymentRepository;
import camt.FitUp.Project.repository.TransactionRepository;
import camt.FitUp.Project.repository.UserRepository;
import camt.FitUp.Project.repository.VideoPurchasedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Film on 14/10/2559.
 */
@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDao {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    VideoPurchasedRepository videoPurchasedRepository;

    @Override
    public Payment addShoppingCart(Video video, Payment payment, User user) {
        payment.getVideos().add(video);
        paymentRepository.save(payment);
        user.getPayments().add(payment);
        userRepository.save(user);
        return payment;
    }

    @Override
    public List<Payment> shoppinglist() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment shoppingId(Long id) {
        return paymentRepository.findOne(id);
    }

    @Override
    public Payment editShoppingCart(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Transaction addTransaction(Transaction transaction, User user) {
        transaction.getUsers().add(user);
        transactionRepository.save(transaction);
        return transaction;
    }

    @Override
    public List<Transaction> transactionList() {
        return transactionRepository.findAll();
    }

    @Override
    public Payment deleteShoppingCart(Payment payment) {
        paymentRepository.delete(payment);
        payment.setId(null);
        return payment;
    }

    @Override
    public VideoPurchased videoPurchased(VideoPurchased videoPurchased, Video video, User user) {
        videoPurchased.getVideos().add(video);
        videoPurchasedRepository.save(videoPurchased);
        user.getVideoPurchaseds().add(videoPurchased);
        userRepository.save(user);
        return videoPurchased;
    }

}
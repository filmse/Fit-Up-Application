package camt.FitUp.Project.service;

import camt.FitUp.Project.dao.ShoppingCartDao;
import camt.FitUp.Project.entity.*;
import camt.FitUp.Project.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Film on 14/10/2559.
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    ShoppingCartDao shoppingCartDao;

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public Payment addShoppingCart(Video video, Payment payment, User user) {
        payment.setPurchaseDate(Calendar.getInstance().getTime());
        return shoppingCartDao.addShoppingCart(video, payment, user);
    }

    @Override
    public List<Payment> shoppinglist() {
        return shoppingCartDao.shoppinglist();
    }

    @Override
    public Payment shoppingId(Long id) {
        return shoppingCartDao.shoppingId(id);
    }

    @Override
    public Payment editShoppingCart(Payment payment) {
        return shoppingCartDao.editShoppingCart(payment);
    }

    @Override
    public Transaction addTransaction(Transaction transaction, User user) {
        return shoppingCartDao.addTransaction(transaction, user);
    }

    @Override
    public List<Transaction> transactionList() {
        return shoppingCartDao.transactionList();
    }

    @Override
    public Payment deleteShoppingCart(Long shoppingId) {
        Payment payment = shoppingId(shoppingId);
        return shoppingCartDao.deleteShoppingCart(payment);
    }

    @Override
    public VideoPurchased addVideoPurchased(VideoPurchased videoPurchased, Video video, User user) {
        return shoppingCartDao.videoPurchased(videoPurchased, video, user);
    }

}

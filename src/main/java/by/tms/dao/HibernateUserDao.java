package by.tms.dao;

import by.tms.entity.User;
import by.tms.service.CalculatorOperation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Component
public class HibernateUserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<User> findByUsername(String username) {
        Session currentSession = sessionFactory.getCurrentSession();
        org.hibernate.query.Query<User> query = currentSession.createQuery("from User where username = :username", User.class);
        query.setParameter("username", username);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }


    @Transactional(readOnly = true)
    public User findById(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        User user = currentSession.get(User.class, id);
        return user;
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> query = currentSession.createQuery("from User", User.class);
        List<User> resultList = query.getResultList();
        return resultList;
    }

}

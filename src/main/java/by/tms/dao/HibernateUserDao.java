package by.tms.dao;

import by.tms.entity.User;
import by.tms.service.CalculatorOperation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Component
public class HibernateUserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional()
    public void saveUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveUser(user);
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

    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        Session currentSession = sessionFactory.getCurrentSession();
        User user = currentSession.get(User.class, username);
        return user;
    }


    public void saveOrUpdate(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(user);
    }

    @Transactional()
    public void saveOperation(User user, CalculatorOperation operation) {
        Session currentSession = sessionFactory.getCurrentSession();
        user.saveOperation(operation);
        currentSession.save(user);
    }

    public void update(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(user);
    }


}

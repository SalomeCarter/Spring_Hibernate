package by.tms.dao;

import by.tms.entity.Operation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class HibernateOperationDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(Operation operation){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(operation);
    }

    @Transactional(readOnly = true)
    public List<Operation> findByUser(long id){
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Operation> query = currentSession.createQuery("from Operation where id = :id", Operation.class);
        query.setParameter("id", id);
        return query.getResultList();
    }


}

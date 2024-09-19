package lk.ijse.repo;

import jakarta.persistence.Query;
import lk.ijse.entity.Customer;
import org.hibernate.Session;

import java.util.List;

public class Methods {

    public int InsertCustomer(Session session, String  cInsert) {
        Query query = session.createQuery(cInsert);
        int i = query.executeUpdate();
        return i;
    }

    public int UpdateCustomer(String sql,Session session) {
        Query query = session.createQuery(sql);
        query.setParameter("name", "keshan");
        query.setParameter("id", 2);
        return query.executeUpdate();
    }

    public int DeleteCustomer(String sql,Session session) {
        Query query = session.createQuery(sql);
        query.setParameter("id", 2);
        return query.executeUpdate();
    }

    public List<Customer> SearchCustomer(String hql3 , Session session) {
        org.hibernate.query.Query query = session.createQuery(hql3);
        query.setParameter("name" , "rukshan");
        List<Customer> customers = query.list();
        return customers;
    }

    public List<Object[]> joinQuey(String hql4, Session session) {
        org.hibernate.query.Query query1 = session.createQuery(hql4);
        List<Object[]> customerr = query1.list();
        return customerr;

    }
}

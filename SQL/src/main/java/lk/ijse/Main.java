package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();



        //insert
        NativeQuery query = session.createNativeQuery("insert into Customer values (?1,?2,?3)");
        query.setParameter(1,1);
        query.setParameter(2,"Negombo");
        query.setParameter(3,"Keshan");
        query.executeUpdate();


      //update
        NativeQuery query1 = session.createNativeQuery("update Customer set name = ?1 where id = ?2");
        query1.setParameter(1,"Randika");
        query1.setParameter(2,1);
        query1.executeUpdate();

        //Delete
        NativeQuery query2 = session.createNativeQuery("delete from Customer where id = ?1");
        query2.setParameter(1,1);
        query2.executeUpdate();

        // search
        NativeQuery<Object[]> query3 = session.createNativeQuery("select name, address from Customer where id = :id");
        query3.setParameter("id", 2);
        List<Object[]> customers = query3.list();

        for (Object[] customer : customers) {
            System.out.println("Name: " + customer[0]);
            System.out.println("Address: " + customer[1]);
        }


        transaction.commit();
        session.close();


    }
}
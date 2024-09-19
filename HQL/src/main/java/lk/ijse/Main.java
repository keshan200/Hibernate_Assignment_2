package lk.ijse;


import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Customer;
import lk.ijse.repo.Methods;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {


            Methods methods = new Methods();
            Session session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();


            //insert
            String cInsert = "INSERT INTO Customer (id, name, address) VALUES (3, 'Bandara', 'kandy')";
           int i = methods.InsertCustomer(session, cInsert);
            System.out.println(i);

            //update
            String hql = "update Customer set name =:name where id =:id";
           int i1 = methods.UpdateCustomer(hql, session);
           System.out.println(i1);

            //delete
            String hql2 = "delete from Customer where id =:id";
            int i2 = methods.DeleteCustomer(hql2, session);
            System.out.println(i2);


             //search
             String hql3 = "from Customer where name = :name";
             List<Customer> customers = methods.SearchCustomer(hql3, session);
            for(Customer customer : customers){
                 System.out.println(customer.getId());
                 System.out.println(customer.getName());
           }


           //join query
           String hql4 = "select a.aid, a.city, a.street from Address a inner join Customer c on a.customer = c ";
         List<Object[]> customerr = methods.joinQuey(hql4, session);
           for (Object[] o : customerr) {
              System.out.println(Arrays.toString(o));
         }

           Query query=session.createQuery("select id,name from Customer where id=?1");
           query.setParameter(1,3);
           List <Object[]> cus = query.list();
           for (Object[] customer : cus) {
               System.out.println(Arrays.toString(customer));

           }

          Query query1=session.createQuery("select id,name from Customer");
          List <Object[]> customer  = query1.list();
         for (Object[] c : customer) {
              System.out.println(Arrays.toString(c));
         }

        Query query3=session.createQuery("select a.aid,a.city from Address a inner join Customer c on a.aid = c.id");
       List <Object[]> custo = query3.list();
       for (Object[] obj  : custo){
            System.out.println(Arrays.toString(obj));
       }

        transaction.commit();
             session.close();

    }
}
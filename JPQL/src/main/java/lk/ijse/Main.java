package lk.ijse;

import jakarta.persistence.TypedQuery;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Address;
import lk.ijse.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Keshan");


        Address address = new Address();
        address.setCity("Negombo");
        address.setCustomer(customer);

        session.save(customer);
        session.save(address);


        //update
        Query query1 = session.createQuery("UPDATE Customer c SET c.name = :name WHERE c.id = :id");
        query1.setParameter("name", "Randika");
        query1.setParameter("id", 1);
        query1.executeUpdate();


        //delete
        Query query2 = session.createQuery("DELETE FROM Customer c WHERE c.id = :id");
        query2.setParameter("id", 1);
        query2.executeUpdate();

        //search
        Query<Customer> query3 = session.createQuery("SELECT c FROM Customer c WHERE c.id = :id", Customer.class);
        query3.setParameter("id", 2);
        List<Customer> cus = query3.getResultList();

        for (Customer cuss : cus) {
            System.out.println("Name: " + cuss.getName());
            System.out.println("Address: " + cuss.getAddresses());
        }



        //join
        String jpql = "SELECT c FROM Customer c JOIN c.addresses a WHERE a.city = :city";
        TypedQuery<Customer> query = session.createQuery(jpql, Customer.class);
        query.setParameter("city", "Colombo");
        List<Customer> cust = query.getResultList();

        for (Customer c : cust) {
            System.out.println("Customer Name: " + c.getName());
            for (Address addres : c.getAddresses()) {
                System.out.println("Address: " + addres.getStreet() + ", " + addres.getCity());
            }
        }

    }
}
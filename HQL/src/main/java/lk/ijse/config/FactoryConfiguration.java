package lk.ijse.config;


import lk.ijse.entity.Address;
import lk.ijse.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {

    private static FactoryConfiguration sessionFactoryConfiguration;

    private SessionFactory session;

    private FactoryConfiguration(){
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(Address.class);
        session = configuration.buildSessionFactory();

    }
    public static FactoryConfiguration getInstance(){
        if (sessionFactoryConfiguration == null){
            sessionFactoryConfiguration = new FactoryConfiguration();
        }
        return sessionFactoryConfiguration;
    }
    public Session getSession() {
        return session.openSession();
    }
}

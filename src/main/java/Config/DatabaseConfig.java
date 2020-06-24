package Config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DatabaseConfig {
    private static StandardServiceRegistry registry = null;
    private static SessionFactory sessionFactory = null;

    public static synchronized Session getSession() {
        if(sessionFactory == null) {
            try {
                registry = new StandardServiceRegistryBuilder()
                        .configure()
                        .build();
                sessionFactory = new MetadataSources(registry)
                        .buildMetadata()
                        .buildSessionFactory(); // utworzenie tabel
            } catch (Exception e) {
                e.printStackTrace();
                StandardServiceRegistryBuilder.destroy(registry);
            }
        }
        return sessionFactory.openSession();
    }

    public static void closeSession(){
        if(registry!=null && sessionFactory != null){
            sessionFactory.close();
        }
    }

}

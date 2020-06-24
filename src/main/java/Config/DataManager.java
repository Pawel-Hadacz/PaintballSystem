package Config;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DataManager {
    private EntityManager em;

    public DataManager(EntityManager em) {
      // em = Persistence.createEntityManagerFactory().createEntityManager();
    }
}

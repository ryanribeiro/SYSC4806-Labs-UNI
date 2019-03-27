import lab4.model.BuddyInfo;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

public class BuddyInfoPersistenceTest {

    @Test
    public void performJPA() {
        BuddyInfo buddy1 = new BuddyInfo("Ryan", "Klondike", "555-555-5555");
        BuddyInfo buddy2 = new BuddyInfo("John", "Jail", "555-867-5309");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-test");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        entityManager.persist(buddy1);
        entityManager.persist(buddy2);
        entityTransaction.commit();

        Query query = entityManager.createQuery("SELECT b FROM BuddyInfo b");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = query.getResultList();

        System.out.println("List of buddies\n--------------------");


        entityManager.close();
        entityManagerFactory.close();
    }
}
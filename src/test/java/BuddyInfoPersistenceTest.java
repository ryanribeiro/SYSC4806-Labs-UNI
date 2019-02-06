import org.junit.Test;

import javax.persistence.*;

import java.util.List;

import static org.junit.Assert.*;

public class BuddyInfoPersistenceTest {
    @Test
    public void performJPA() {
        BuddyInfo buddy1 = new BuddyInfo("Ryan", "Klondike", "555-555-5555");
        buddy1.setId(1);
        BuddyInfo buddy2 = new BuddyInfo("John", "Jail", "555-867-5309");
        buddy2.setId(2);

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

        results.forEach(b -> System.out.println(b.getName() + " (id = " + b.getId() + ")"));

        entityManager.close();
        entityManagerFactory.close();
    }
}
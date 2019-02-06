import org.junit.Test;

import javax.persistence.*;
import java.util.List;

public class AddressBookPersistenceTest {

    @Test
    public void performJPA() {
        AddressBook book1 = new AddressBook();
        BuddyInfo buddy1 = new BuddyInfo("Ryan", "Klondike", "555-555-5555");
        BuddyInfo buddy2 = new BuddyInfo("John", "Jail", "555-867-5309");
        book1.addBuddy(buddy1);
        book1.addBuddy(buddy2);

        AddressBook book2 = new AddressBook();
        BuddyInfo buddy3 = new BuddyInfo("Jack", "Main", "555-132-4452");
        BuddyInfo buddy4 = new BuddyInfo("Jill", "Lane", "555-666-7777");
        book2.addBuddy(buddy3);
        book2.addBuddy(buddy4);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-test");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        entityManager.persist(book1);
        entityManager.persist(book2);
        entityTransaction.commit();

        Query query = entityManager.createQuery("SELECT a FROM AddressBook a");

        @SuppressWarnings("unchecked")
        List<AddressBook> results = query.getResultList();

        System.out.println("List of address books\n--------------------");

        for (AddressBook a : results) {
            System.out.println("(AddressBook id = " + a.getId() + ")");
            List<BuddyInfo> buddiesList = a.getBuddiesList();
            for (BuddyInfo b : buddiesList) {
                System.out.println(b.getName() + " (id = " + b.getId() + ")");
            }
        }

        entityManager.close();
        entityManagerFactory.close();
    }

}
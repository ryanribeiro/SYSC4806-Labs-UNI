import model.AddressBook;
import model.BuddyInfo;

import static org.junit.Assert.*;

public class AddressBookTest {

    private AddressBook addressBook;
    private BuddyInfo buddy1, buddy2, buddy3;

    @org.junit.Before
    public void setUp() throws Exception {
        this.addressBook = new AddressBook();
        this.buddy1 = new BuddyInfo("Ryan", "Klondike", "555-555-5555");
        this.buddy2 = new BuddyInfo("John", "Jail", "123-456-7890");
        this.buddy3 = new BuddyInfo("Jane", "Main Street", "1-800-555-5555");
    }

    @org.junit.Test
    public void testAddAndRemoveBuddy() {
        this.addressBook.addBuddy(this.buddy1);
        this.addressBook.addBuddy(this.buddy2);
        this.addressBook.addBuddy(this.buddy3);
        int size = this.addressBook.getBuddiesList().size();

        assertEquals("Size should be three.", 3, size);

        this.addressBook.removeBuddy(1);
        size = this.addressBook.getBuddiesList().size();

        assertEquals("Size should now be two.", 2, size);
    }

    @org.junit.Test
    public void testRemoveAllBuddies() {
        this.addressBook.addBuddy(this.buddy1);
        this.addressBook.addBuddy(this.buddy2);
        this.addressBook.addBuddy(this.buddy3);
        this.addressBook.removeAllBuddies();
        int size = this.addressBook.getBuddiesList().size();

        assertEquals("All buddies removed, should be empty.", 0, size);
    }
}
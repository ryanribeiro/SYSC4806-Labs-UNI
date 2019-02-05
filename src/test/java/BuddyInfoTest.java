import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    private BuddyInfo buddy;

    @Before
    public void setUp() throws Exception {
        buddy = new BuddyInfo("Ryan", "Klondike", "555-555-5555");
    }

    @Test
    public void testGetAndSetName() {
        this.buddy.setName("FAKE");

        assertEquals("Name should be 'FAKE'", "FAKE", buddy.getName());
    }

    @Test
    public void testGetAndSetAddress() {
        this.buddy.setAddress("FAKE");

        assertEquals("Address should be 'FAKE'", "FAKE", buddy.getAddress());
    }

    @Test
    public void testGetAndSetPhoneNumber() {
        this.buddy.setPhoneNumber("FAKE");

        assertEquals("Phonenumber should be 'FAKE'", "FAKE", buddy.getPhoneNumber());
    }

    @Test
    public void testIsEqual() {
        BuddyInfo fakeBuddy = new BuddyInfo("FAKE", "Klondike", "555-555-5555");
        BuddyInfo goodBuddy = new BuddyInfo("Ryan", "Klondike", "555-555-5555");

        assertEquals("Buddies are not the same, should be false", false, this.buddy.isEqual(fakeBuddy));
        assertEquals("Buddies are the same, should be true", true, this.buddy.isEqual(goodBuddy));
    }

    @Test
    public void testToString() {
        String printout = this.buddy.toString();
        String expected = "Name: Ryan Address: Klondike Phonenumber: 555-555-5555";

        assertEquals("Strings should match", expected, printout);
    }
}
import java.util.*;

public class AddressBook {
    private ArrayList<BuddyInfo> buddiesList;

    public AddressBook() {
        this.buddiesList = new ArrayList<BuddyInfo>();
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        BuddyInfo buddy1 = new BuddyInfo("Ryan", "Klondike", "555-555-5555");
        BuddyInfo buddy2 = new BuddyInfo("John", "Jail", "123-456-7890");
        BuddyInfo buddy3 = new BuddyInfo("Jane", "Main Street", "1-800-555-5555");

        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);
        addressBook.addBuddy(buddy3);

        addressBook.printAddressBook();
    }

    public ArrayList<BuddyInfo> getBuddiesList() {
        return this.buddiesList;
    }

    public void addBuddy(BuddyInfo buddy) {
        this.buddiesList.add(buddy);
    }

    public void removeBuddy(int index) {
        this.buddiesList.remove(index);
    }

    public void removeAllBuddies() {
        this.buddiesList.clear();
    }

    public void printAddressBook() {
        this.getBuddiesList().forEach(value->System.out.println(value));
    }
}

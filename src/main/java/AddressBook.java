import javax.persistence.*;
import java.util.*;

@Entity
public class AddressBook {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<BuddyInfo> buddiesList;

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

    public List<BuddyInfo> getBuddiesList() {
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
        for (BuddyInfo buddy : this.getBuddiesList()) {
            System.out.println(buddy.toString());
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

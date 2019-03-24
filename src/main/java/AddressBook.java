import java.util.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @EqualsAndHashCode
public class AddressBook {
    private ArrayList<BuddyInfo> buddiesList = new ArrayList<>();

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        BuddyInfo buddy1 = new BuddyInfo("Jumpy Jack", "Up the Hill", "555-555-5550");
        BuddyInfo buddy2 = new BuddyInfo("Jolly Jill", "Up the Hill ", "555-555-5551");
        BuddyInfo buddy3 = new BuddyInfo("Jealous Jane", "Bottom of the Hill", "555-555-5552");

        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);
        addressBook.addBuddy(buddy3);

        addressBook.printAddressBook();
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
}

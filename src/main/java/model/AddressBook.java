package model;

import javax.persistence.*;
import java.util.*;
import java.util.List;

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

        //Lab 3 stuff
        Launcher launcher = new Launcher();
        launcher.launch();
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

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public int getColumnCount() {
        return 1;
    }

    public String getColumnName(int column) {
        return "Buddies";
    }

    public int getRowCount() {
        return buddiesList.size();
    }

    public void setValueAt(Object value,
                           int rowIndex, int columnIndex) {
        buddiesList.set(rowIndex, (BuddyInfo) value);
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return buddiesList.get(rowIndex);
    }
}

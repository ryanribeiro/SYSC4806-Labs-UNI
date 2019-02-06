import javax.persistence.*;
import java.util.*;
import javax.swing.*;

@Entity
public class AddressBook {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<BuddyInfo> buddiesList;

    private JFrame jFrame;
    private JMenuBar jMenuBar;
    private JMenu jMenuAddressBook, jMenuBuddyInfo;
    private JMenuItem jMenuItemCreate, jMenuItemSave, jMenuItemDisplay, jMenuItemAdd;
//    private JTextArea jTextArea;

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
        addressBook.initializeGUI();
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

    private void initializeGUI() {
        jFrame = new JFrame("Address Book");
        jFrame.setSize(500,500);

        //Create menus and menu bar
        jMenuBar = new JMenuBar();
        jMenuAddressBook = new JMenu("address Book");
        jMenuBuddyInfo = new JMenu("Buddy Info");

        //Create menu items
        jMenuItemCreate = new JMenuItem("Create");
        jMenuItemSave = new JMenuItem("Save");
        jMenuItemDisplay = new JMenuItem("Display");
        jMenuItemAdd = new JMenuItem("Add");

        //Add items to menus
        jMenuAddressBook.add(jMenuItemCreate);
        jMenuAddressBook.add(jMenuItemSave);
        jMenuAddressBook.add(jMenuItemDisplay);
        jMenuBuddyInfo.add(jMenuItemAdd);

        //Add menus to menu bar
        jMenuBar.add(jMenuAddressBook);
        jMenuBar.add(jMenuBuddyInfo);

        //Add menu bar to frame
        jFrame.add(jMenuBar);

        jFrame.setVisible(true);
    }
}

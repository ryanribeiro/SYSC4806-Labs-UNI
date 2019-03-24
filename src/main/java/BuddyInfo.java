public class BuddyInfo {
    private String name;
    private String address;
    private String phoneNumber;

    public BuddyInfo () {
        this("Temp", "Temp", "Temp");
    }

    public BuddyInfo (String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean isEqual(BuddyInfo buddy) {
        if (this.getName().equals(buddy.getName())) {
            if (this.getAddress().equals(buddy.getAddress())){
                if (this.getPhoneNumber().equals(buddy.getPhoneNumber())){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + " Address: " + this.getAddress() + " Phonenumber: " + this.getPhoneNumber();
    }
}

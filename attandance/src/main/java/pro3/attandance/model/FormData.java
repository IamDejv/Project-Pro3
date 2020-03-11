package pro3.attandance.model;

public class FormData {
    private String firstname;
    private String lastname;
    private String dateOfBirth;
    private String dateofcome;
    private boolean active;
    private ContactInfo contactInfo;
    private int roleid;
    private Address address;


    public FormData(String firstname, String lastname, String dateOfBirth, String dateofcome, boolean active, ContactInfo contactInfo, int roleid, Address address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.dateofcome = dateofcome;
        this.active = active;
        this.contactInfo = contactInfo;
        this.roleid = roleid;
        this.address = address;
    }

    public FormData() {
    }

    public String getfirstname() {
        return firstname;
    }

    public void setfirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getdateOfBirth() {
        return dateOfBirth;
    }

    public void setdateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateofcome() {
        return dateofcome;
    }

    public void setDateofcome(String dateofcome) {
        this.dateofcome = dateofcome;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public int getroleid() {
        return roleid;
    }

    public void setroleid(int roleid) {
        this.roleid = roleid;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "FormData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", dateofcome='" + dateofcome + '\'' +
                ", active=" + active +
                ", contactInfo=" + contactInfo.getEmail() + " " + contactInfo.getPhone() +
                ", roleid=" + roleid +
                ", address=" + address.getCity() + " " + address.getState() + " " + address.getStreet() + " " + address.getZip() +
                '}';
    }
}

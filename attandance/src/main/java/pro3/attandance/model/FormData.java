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
    private int sex;
    private String password;


    public FormData(String firstname, String lastname, String dateOfBirth, String dateofcome, boolean active, ContactInfo contactInfo, int roleid, Address address, int sex, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.dateofcome = dateofcome;
        this.active = active;
        this.contactInfo = contactInfo;
        this.roleid = roleid;
        this.address = address;
        this.sex = sex;
        this.password = password;
    }

    public FormData() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
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

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "FormData{" +
                "firstname=' " + firstname + '\'' +
                ", lastname=' " + lastname + '\'' +
                ", dateOfBirth=' " + dateOfBirth + '\'' +
                ", dateofcome=' " + dateofcome + '\'' +
                ", active= " + active +
                ", contactInfo= " + contactInfo.getEmail() + " " + contactInfo.getPhone() +
                ", roleid= " + roleid +
                ", address= " + address.getCity() + " " + address.getState() + " " + address.getStreet() + " " + address.getZip() +
                ", sex= " + sex +
                '}';
    }


}

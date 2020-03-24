package pro3.attandance.model;

import pro3.attandance.enums.RoleEnum;
import pro3.attandance.repository.CompanyRepository;
import pro3.attandance.services.CompanyService;
import pro3.attandance.services.RoleService;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personsid")
    private int personid;

    @Column(name = "firstname")
    @NotNull
    private String firstname;

    @Column(name = "lastname")
    @NotNull
    private String lastname;

    @Column(name = "isactive")
    @NotNull
    private boolean active;

    @Column(name = "dateofbirth")
    @NotNull
    private String dateOfBirth;

    @Column(name = "dateofcome")
    private String dateofcome;

    @Column(name = "password")
    private String password;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "role_roleid", insertable = false, updatable = false)
    private Role role;

    @Column(name = "role_roleid")
    private int roleid;

    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @NotNull
    private Address address;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @NotNull
    private ContactInfo contactInfo;

    public Person() {
    }

    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}

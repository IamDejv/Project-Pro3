package pro3.attandance.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contactinfo")
public class ContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contactinfoid")
    private int companyid;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "phone")
    @NotNull
    private String phone;

    @Column(name = "ismain")
    @NotNull
    private boolean isMain;

    @ManyToOne
    private Person person;

    public ContactInfo() {
    }

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

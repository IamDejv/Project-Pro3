package pro3.attandance.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usersid")
    private int userid;

    @Column(name = "username")
    @NotNull
    private String username;

    //One to One, na strane kde chci mit id, tak staci tohle
    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @NotNull
    private Person person;

    @Column(name = "user_companyid")
    private int companyid;

    public User() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }
}

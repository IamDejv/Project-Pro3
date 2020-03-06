package pro3.attandance.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usersid")
    private int userid;

    @Column(name = "username")
    private String username;

    //One to One, na strane kde chci mit id, tak staci tohle
    @OneToOne
    private Person person;
    //Many to One, na strane, kde chci mit id, tak staci tohle
    @ManyToOne
    private Company company;

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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}

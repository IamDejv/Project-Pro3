package pro3.attandance.model;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Autowired;
import pro3.attandance.repository.CompanyRepository;
import pro3.attandance.services.BaseService;
import pro3.attandance.services.CompanyService;

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

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @NotNull
    private Person person;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "company_companiesid", insertable = false, updatable = false)
    private Company company;

    @Column(name = "company_companiesid")
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

    public Company getCompany() {
        return company;
    }

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}

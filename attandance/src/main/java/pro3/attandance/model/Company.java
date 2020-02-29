package pro3.attandance.model;

import javax.persistence.*;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "companiesid")
    private int companyid;

    @Column(name = "name")
    private String name;
}

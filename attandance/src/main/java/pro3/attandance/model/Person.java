package pro3.attandance.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personsid")
    private int personid;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "isActive")
    private boolean active;

    @Column(name = "dateofbirth")
    private Date dateOfBirth;

    @Column(name = "dateofcome")
    private Date dateofcome;

}

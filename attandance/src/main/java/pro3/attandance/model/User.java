package pro3.attandance.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "usersid")
    private int userid;

    @Column(name = "username")
    private String username;

    @Column(name = "personsid")
    private String personid;


}

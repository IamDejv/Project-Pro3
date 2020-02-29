package pro3.attandance.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "addressesid")
    private Date addresid;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private Date state;

    @Column(name = "street")
    private String street;

    @Column(name = "zip")
    private String zip;

}

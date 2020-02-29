package pro3.attandance.model;

import javax.persistence.*;

@Entity
@Table(name = "sponsors")
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sponsorsid")
    private int sponsorid;

    @Column(name = "name")
    private String name;
}

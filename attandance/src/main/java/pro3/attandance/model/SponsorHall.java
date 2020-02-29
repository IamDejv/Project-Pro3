package pro3.attandance.model;

import javax.persistence.*;

@Entity
@Table(name = "sponsorshall")
public class SponsorHall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sponsorshallid")
    private int sponsorhallid;

}

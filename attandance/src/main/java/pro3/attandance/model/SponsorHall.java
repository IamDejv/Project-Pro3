package pro3.attandance.model;

import javax.persistence.*;

@Entity
@Table(name = "sponsorshall")
public class SponsorHall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sponsorshallid")
    private int sponsorhallid;

    @ManyToOne
    private Hall hall;

    @ManyToOne
    private Sponsor sponsor;

    public SponsorHall() {
    }

    public int getSponsorhallid() {
        return sponsorhallid;
    }

    public void setSponsorhallid(int sponsorhallid) {
        this.sponsorhallid = sponsorhallid;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }
}

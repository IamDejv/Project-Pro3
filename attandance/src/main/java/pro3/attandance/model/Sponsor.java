package pro3.attandance.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sponsors")
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sponsorid")
    private int sponsorid;

    @Column(name = "name")
    @NotNull
    private String name;

    public Sponsor() {
    }

    public int getSponsorid() {
        return sponsorid;
    }

    public void setSponsorid(int sponsorid) {
        this.sponsorid = sponsorid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

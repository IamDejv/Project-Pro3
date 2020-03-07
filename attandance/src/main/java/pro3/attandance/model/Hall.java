package pro3.attandance.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "hall")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hallid")
    private String hallid;


    @Column(name = "name")
    @NotNull
    private String name;

    @OneToOne
    @NotNull
    private Address address;

    public Hall() {
    }

    public String getHallid() {
        return hallid;
    }

    public void setHallid(String hallid) {
        this.hallid = hallid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

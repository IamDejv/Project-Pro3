package pro3.attandance.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="address_generator", sequenceName = "address_seq", allocationSize=50)
    @Column(name = "addressesid")
    private int addresid;

    @Column(name = "city")
    @NotNull
    private String city;

    @Column(name = "state")
    @NotNull
    private String state;

    @Column(name = "street")
    @NotNull
    private String street;

    @Column(name = "zip")
    @NotNull
    private String zip;

    public Address() {
    }

    public int getAddresid() {
        return addresid;
    }

    public void setAddresid(int addresid) {
        this.addresid = addresid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

}

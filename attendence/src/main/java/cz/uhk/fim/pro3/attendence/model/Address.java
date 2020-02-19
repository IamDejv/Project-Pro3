package cz.uhk.fim.pro3.attendence.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "Addresses")
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String street;

    private String zip;

    private String city;

    private String state;

    public Address(@JsonProperty("street") String street,
                   @JsonProperty("zip") String zip,
                   @JsonProperty("city") String city,
                   @JsonProperty("state") String state) {
        this.street = street;
        this.zip = zip;
        this.city = city;
        this.state = state;
    }

    public int getId() {
        return id;
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
}

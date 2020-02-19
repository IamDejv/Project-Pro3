package cz.uhk.fim.pro3.attendence.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "piNumber")
    private String piNumber;

    @Column(name = "dateOfBirth")
    private String dateOfBirth;

    @Column(name = "dateOfCome")
    private String dateOfCome;

    @Column(name = "dateOfLeave")
    private String dateOfLeave;

    @Column(name = "sex")
    private String sex;

    @Column(name = "isPaid")
    private boolean isPaid;

    public User() {
    }

    public User(@JsonProperty("firstname") String firstname,
                @JsonProperty("lastname") String lastname,
                @JsonProperty("dateCome") String dateCome,
                @JsonProperty("dateLeave") String dateLeave,
                @JsonProperty("dateOfBirth") String dateOfBirth,
                @JsonProperty("isPaid") boolean isPaid,
                @JsonProperty("sex") String sex) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfCome= dateCome;
        this.dateOfLeave = dateLeave;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.isPaid = isPaid;

    }

    //Getters and Setters

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPiNumber() {
        return piNumber;
    }

    public void setPiNumber(String piNumber) {
        this.piNumber = piNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfCome() {
        return dateOfCome;
    }

    public void setDateOfCome(String dateOfCome) {
        this.dateOfCome = dateOfCome;
    }

    public String getDateOfLeave() {
        return dateOfLeave;
    }

    public void setDateOfLeave(String dateOfLeave) {
        this.dateOfLeave = dateOfLeave;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}

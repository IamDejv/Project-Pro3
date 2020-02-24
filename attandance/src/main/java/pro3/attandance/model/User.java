package pro3.attandance.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int userid;

    private String firstname;

    private String lastname;

    private String piNumber;

    private String dateOfBirth;

    private String dateOfCome;

    private String dateOfLeave;

    private String sex;

    private boolean isPaid;

    public User() {
    }

    public User(@JsonProperty("firstname") String firstname,
                @JsonProperty("lastname") String lastname,
                @JsonProperty("piNumber") String piNumber,
                @JsonProperty("dateOfBirth") String dateOfBirth,
                @JsonProperty("dateOfCome") String dateOfCome,
                @JsonProperty("dateOfLeave") String dateOfLeave,
                @JsonProperty("sex") String sex,
                @JsonProperty("isPaid") boolean isPaid
                ) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.piNumber = piNumber;
        this.dateOfBirth = dateOfBirth;
        this.dateOfCome = dateOfCome;
        this.dateOfLeave = dateOfLeave;
        this.sex = sex;
        this.isPaid = isPaid;
    }


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

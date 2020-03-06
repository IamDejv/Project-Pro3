package pro3.attandance.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "attandees")
public class Attendee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "attandeesid")
    private int attendeeid;

    @Column(name = "ispaid")
    private boolean isPaid;

    @Column(name = "sex")
    private int sex;

    @OneToOne
    private Person person;

    public Attendee() {
    }

    public int getAttendeeid() {
        return attendeeid;
    }

    public void setAttendeeid(int attendeeid) {
        this.attendeeid = attendeeid;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

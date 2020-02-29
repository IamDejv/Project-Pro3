package pro3.attandance.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "attandees")
public class Attendee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "attandeesid")
    private int attendeeid;

    @Column(name = "isPaid")
    private boolean isPaid;

    @Column(name = "sex")
    private int sex;

}

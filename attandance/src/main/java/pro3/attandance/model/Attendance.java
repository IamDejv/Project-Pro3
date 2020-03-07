package pro3.attandance.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "attendanceid")
    private int attendanceid;

    @Column(name = "presence")
    private int presence;

    @ManyToOne
    @NotNull
    private Attendee attendee;

    @ManyToOne
    @NotNull
    private Training training;

    public Attendance() {
    }

    public int getAttendanceid() {
        return attendanceid;
    }

    public void setAttendanceid(int attendanceid) {
        this.attendanceid = attendanceid;
    }

    public int getPresence() {
        return presence;
    }

    public void setPresence(int presence) {
        this.presence = presence;
    }

    public Attendee getAttendee() {
        return attendee;
    }

    public void setAttendee(Attendee attendee) {
        this.attendee = attendee;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }
}

package pro3.attandance.model;

import pro3.attandance.utils.DayGenerator;

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

    @Column(name = "trainingDate")
    @NotNull
    private String trainingDate;

    @ManyToOne
    @JoinColumn(name = "attendee_attandeesid", insertable = false, updatable = false)
    private Attendee attendee;

    @Column(name = "attendee_attandeesid")
    @NotNull
    private int attendeeid;

    @Column(name = "training_trainingsid")
    @NotNull
    private int trainingid;


    @ManyToOne
    @JoinColumn(name = "training_trainingsid", insertable = false, updatable = false)
    private Training training;

    public Attendance() {
    }

    public Attendance(@NotNull String trainingDate, @NotNull int attendeeid, @NotNull int trainingid, int presence) {
        this.trainingDate = trainingDate;
        this.attendeeid = attendeeid;
        this.trainingid = trainingid;
        this.presence = presence;
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

    public String getTrainingDate() {
        return DayGenerator.webalizeDate(trainingDate);
    }

    public void setTrainingDate(String trainingDate) {
        this.trainingDate = trainingDate;
    }

    public int getAttendeeid() {
        return attendeeid;
    }

    public void setAttendeeid(int attendeeid) {
        this.attendeeid = attendeeid;
    }

    public int getTrainingid() {
        return trainingid;
    }

    public void setTrainingid(int trainingid) {
        this.trainingid = trainingid;
    }
}

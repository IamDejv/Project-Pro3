package pro3.attandance.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "trainings")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trainingsid")
    private int trainingid;

    @Column(name = "type")
    @NotNull
    private int type;

    @Column(name = "endtime")
    @NotNull
    private String endtime;

    @Column(name = "trainingDay")
    private String trainingDay;

    @Column(name = "trainingName")
    private String name;

    @Column(name = "starttime")
    @NotNull
    private String starttime;

    @Column(name = "endDate")
    @NotNull
    private String endDate;

    @Column(name = "startDate")
    @NotNull
    private String startDate;


    @ManyToOne
    @JoinColumn(name = "user_usersid", insertable = false, updatable = false)
    private User user ;

    @Column(name = "user_usersid")
    @NotNull
    private int userid;

    @ManyToOne
    @JoinColumn(name = "hall_hallid", insertable = false, updatable = false)
    private Hall hall;

    @Column(name = "hall_hallid")
    private int hallid;

    public Training() {
    }

    public int getTrainingid() {
        return trainingid;
    }

    public void setTrainingid(int trainingid) {
        this.trainingid = trainingid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public String getTrainingDay() {
        return trainingDay;
    }

    public void setTrainingDay(String trainingDay) {
        this.trainingDay = trainingDay;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getHallid() {
        return hallid;
    }

    public void setHallid(int hallid) {
        this.hallid = hallid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String getEndDate) {
        this.endDate = getEndDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String getStartDate) {
        this.startDate = getStartDate;
    }
}

package pro3.attandance.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "trainings")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trainingsid")
    private int trainingid;

    @Column(name = "type")
    private int type;

    @Column(name = "endtime")
    private Timestamp endtime;

    @Column(name = "starttime")
    private Timestamp starttime;
}

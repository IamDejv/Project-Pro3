package pro3.attandance.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "actions")
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "actionsid")
    private Date actionsid;

    @Column(name = "description")
    private String description;

    @Column(name = "dateaction")
    private Date dateAction;

    @Column(name = "type")
    private String type;

}

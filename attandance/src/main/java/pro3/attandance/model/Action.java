package pro3.attandance.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "actions")
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "actionsid")
    private int actionsid;

    @Column(name = "description")
    private String description;

    @Column(name = "dateaction")
    private String dateAction;

    @Column(name = "type")
    private String type;

    @ManyToOne
    private Address address;

    public Action() {
    }

    public int getActionsid() {
        return actionsid;
    }

    public void setActionsid(int actionsid) {
        this.actionsid = actionsid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateAction() {
        return dateAction;
    }

    public void setDateAction(String dateAction) {
        this.dateAction = dateAction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

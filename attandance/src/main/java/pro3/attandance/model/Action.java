package pro3.attandance.model;

import pro3.attandance.enums.TrainingTypeEnum;
import pro3.attandance.enums.TypeEnum;
import pro3.attandance.utils.DayGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "actions")
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "actionsid")
    private int actionsid;

    @Column(name = "actionName")
    private String actionName;

    @Column(name = "description")
    private String description;

    @Column(name = "dateaction")
    @NotNull
    private String dateAction;

    @Column(name = "type")
    @NotNull
    private String type;

    @Column(name = "userAction")
    @OneToMany
    private List<UserAction> userAction;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
        return DayGenerator.webalizeDate(dateAction);
    }

    public void setDateAction(String dateAction) {
        this.dateAction = dateAction;
    }

    public String getType() {
        return TypeEnum.webalizeEnum(Integer.parseInt(type));
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

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }
}

package pro3.attandance.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usersactions")
public class UserAction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "useractionid")
    private int useractionid;

    @ManyToOne
    @JoinColumn(name = "user_usersid", insertable = false, updatable = false)
    private User user;

    @Column(name = "user_usersid")
    @NotNull
    private int userid;

    @Column(name = "action_actionsid")
    @NotNull
    private int actionid;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "action_actionsid", insertable = false, updatable = false)
    private Action action;

    public UserAction() {
    }

    public int getUseractionid() {
        return useractionid;
    }

    public void setUseractionid(int useractionid) {
        this.useractionid = useractionid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getActionid() {
        return actionid;
    }

    public void setActionid(int actionid) {
        this.actionid = actionid;
    }
}

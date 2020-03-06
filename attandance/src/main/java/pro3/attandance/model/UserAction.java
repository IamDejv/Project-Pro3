package pro3.attandance.model;

import javax.persistence.*;

@Entity
@Table(name = "usersactions")
public class UserAction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "useractionid")
    private int useractionid;

    @ManyToOne
    private User user;

    @ManyToOne
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
}

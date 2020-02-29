package pro3.attandance.model;

import javax.persistence.*;

@Entity
@Table(name = "usersactions")
public class UserAction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "useractionid")
    private int useractionid;

}

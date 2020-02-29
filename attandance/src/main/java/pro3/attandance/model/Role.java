package pro3.attandance.model;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roleid")
    private int roleid;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;
}

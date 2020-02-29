package pro3.attandance.model;

import javax.persistence.*;

@Entity
@Table(name = "hall")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hallid")
    private String hallid;


    @Column(name = "name")
    private String name;
}

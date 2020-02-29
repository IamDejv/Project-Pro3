package pro3.attandance.model;

import javax.persistence.*;

@Entity
@Table(name = "contactinfo")
public class ContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contactinfoid")
    private int companyid;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "isMain")
    private boolean isMain;
}

package pl.hospital.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "doctor")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "profession")
    private String profession;




}

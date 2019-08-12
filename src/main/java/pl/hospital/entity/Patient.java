package pl.hospital.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Parameter;
import springfox.documentation.spring.web.json.Json;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String lastName;

    private Date dateOfBirth;

    private String gender;


//    @Type(type = "json",
//            parameters =
//            @Parameter(name = "classType",value = "pl.hospital.entity.PatientDetails"))
    @JsonIgnore
    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_Details_Id")
  //  @Column(columnDefinition = "json")
    private PatientDetails patientDetails;


    public Patient(){

    }

    public Patient(String name, String lastName, Date dateOfBirth, String gender) {
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }
}

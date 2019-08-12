package pl.hospital.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Type;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
//@Embeddable
public class PatientDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long patient_Details_Id;

    private String city;

    private String street;

  //  @Type(type = "jsonb")
    @JsonBackReference
    @OneToOne(mappedBy = "patientDetails",
            cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    private Patient patient;

    public PatientDetails(){

    }

}

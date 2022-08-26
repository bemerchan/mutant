package co.com.dna.domains;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dna", schema = "mutant")
@Setter
@Getter
public class DnaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dna")
    private String dna;

    @Column(name = "mutant")
    private boolean mutant;
}

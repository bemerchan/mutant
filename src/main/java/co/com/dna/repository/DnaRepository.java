package co.com.dna.repository;

import co.com.dna.domains.DnaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DnaRepository extends JpaRepository<DnaEntity, Integer> {

    List<DnaEntity> findByDna(String dna);

    @Query("select count(m) from DnaEntity m where m.mutant = :mutant")
    int countMutant(@Param("mutant") boolean mutant);
}

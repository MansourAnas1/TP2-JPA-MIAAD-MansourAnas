package ma.miaad.mansouranastp2.repositories;

import ma.miaad.mansouranastp2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByNom(String name);
}

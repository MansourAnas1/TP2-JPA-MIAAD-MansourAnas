package ma.miaad.mansouranastp2.web;

import ma.miaad.mansouranastp2.entities.Patient;
import ma.miaad.mansouranastp2.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> patients(){
        return patientRepository.findAll();
    }
    @GetMapping("/patient/{id}")
    public Patient getPatientById(@PathVariable Long id){
        return patientRepository.findById(id).orElse(null);
    }
}


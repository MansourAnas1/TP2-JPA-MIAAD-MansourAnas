package ma.miaad.mansouranastp2;

import ma.miaad.mansouranastp2.entities.*;
import ma.miaad.mansouranastp2.repositories.ConsultationRepository;
import ma.miaad.mansouranastp2.repositories.MedecinRepository;
import ma.miaad.mansouranastp2.repositories.PatientRepository;
import ma.miaad.mansouranastp2.repositories.RendezVousRepository;
import ma.miaad.mansouranastp2.service.HospitalServiceImpl;
import ma.miaad.mansouranastp2.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class MansourAnasTp2Application {

    public static void main(String[] args) {
        SpringApplication.run(MansourAnasTp2Application.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService hospitalService ,
                            MedecinRepository medecinRepository ,
                            PatientRepository patientRepository,
                            RendezVousRepository rendezVousRepository, HospitalServiceImpl hospitalServiceImpl) {
        return args -> {
            Stream.of("Mansour","Anas","Mohamed")
                    .forEach(name->{
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissace(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    });
            Stream.of("khalid","walid","khalil")
                    .forEach(name->{
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        hospitalService.saveMedecin(medecin);
                    });
            Patient patient=patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findByNom("Mohamed");
            Medecin medecin = medecinRepository.findByNom("khalil");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            RendezVous saveDRDV = hospitalService.saveRDV(rendezVous);
            System.out.println(saveDRDV.getId());

            RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultation...");
            hospitalService.saveConsultation(consultation);

        };

    }

}

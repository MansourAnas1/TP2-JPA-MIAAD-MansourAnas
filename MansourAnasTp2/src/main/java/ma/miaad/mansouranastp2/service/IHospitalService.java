package ma.miaad.mansouranastp2.service;

import ma.miaad.mansouranastp2.entities.Consultation;
import ma.miaad.mansouranastp2.entities.Medecin;
import ma.miaad.mansouranastp2.entities.Patient;
import ma.miaad.mansouranastp2.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
package com.example.application.backend.service;

import com.example.application.backend.entity.Patient;
import com.example.application.backend.repository.PatientRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PatientService {
    private static final Logger LOGGER = Logger.getLogger(PatientService.class.getName());
    private PatientRepo patientRepo;

    public PatientService(PatientRepo patientRepo){
        this.patientRepo = patientRepo;
    }
    public List<Patient> findAll(){
        return patientRepo.findAll();
    }

    public long count(){
        return patientRepo.count();
    }

    public void delete(Patient patient){
        patientRepo.delete(patient);
    }

    public Patient getByBedNum(double bedNum){
        for(long i = 1;i < patientRepo.count();i++){
            double tempBedNum = patientRepo.getOne(i).getBedNum();
            if(tempBedNum == bedNum){
                return patientRepo.getOne(i);
            }
        }
        return null;
    }

    public void save(Patient patient){
        if (patient == null){
            LOGGER.log(Level.SEVERE, "Patient is null");
            return;
        }
        patientRepo.save(patient);
    }
}

package com.ems.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.ems.model.Designation;
import com.ems.repository.DesignationRepository;

@Service
public class DesginationService {

    @Autowired
    private DesignationRepository designationRepository;

    public Designation addDesgination(Designation designation) {
        return this.designationRepository.save(designation);
    }

    public Designation getDesgination(Long desgId) {
        return this.designationRepository.findById(desgId).get();
    }

    public List<Designation> getAllDesgination() {
        return this.designationRepository.findAll();
    }
}

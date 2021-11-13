package com.ems.repository;

import com.ems.model.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface DesignationRepository extends JpaRepository<Designation, Long> {
}

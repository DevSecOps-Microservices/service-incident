package com.microservices_project.service_incident.repository;

import com.microservices_project.service_incident.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface IncidentRepository extends JpaRepository<Incident, Long> {
    @Modifying
    @Query("UPDATE Incident i SET i.captureUrl = :captureUrl WHERE i.id = :id")
    void updateCaptureUrl(@Param("id") Long id, @Param("captureUrl") String captureUrl);
}

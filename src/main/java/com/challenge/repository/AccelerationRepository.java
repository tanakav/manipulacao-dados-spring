package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {

    @Query("SELECT c.id.acceleration " +
            "FROM Candidate c " +
            "WHERE c.id.company.id = :companyId")
    List<Acceleration> findByCompanyId(@Param("companyId") Long companyId);

}

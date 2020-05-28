package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {

    @Query("SELECT c.id.user " +
            "FROM Candidate c " +
            "WHERE c.id.acceleration.name = :name")
    List<User> findByAccelerationName(@Param("name") String name);

    @Query("SELECT c.id.user " +
            "FROM Candidate c " +
            "WHERE c.id.company.id = :companyId")
    List<User> findByCompanyId(@Param("companyId") Long companyId);
}

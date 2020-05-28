package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChallengeRepository extends CrudRepository<Challenge,Long> {

    @Query("SELECT s.id.challenge " +
            "FROM Submission s " +
            "JOIN s.id.challenge.accelerations a " +
            "WHERE s.id.user.id = :userId AND a.id = :accelerationId")
    List<Challenge> findByAccelerationIdAndUserId(@Param("accelerationId") Long accelerationId,@Param("userId") Long userId);
}

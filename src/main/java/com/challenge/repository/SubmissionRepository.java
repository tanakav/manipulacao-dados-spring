package com.challenge.repository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface SubmissionRepository extends CrudRepository<Submission, SubmissionId> {

    @Query("SELECT COALESCE(max(s.score),0)" +
            "FROM Submission s " +
            "WHERE s.id.challenge.id = :challengeId")
    BigDecimal findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);

    @Query("SELECT c.submissions " +
            "FROM Challenge c JOIN c.accelerations a WHERE c.id = :challengeId AND a.id = :accelerationId")
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId,@Param("accelerationId") Long accelerationId);
}

package br.edu.ifpb.pweb2.kawa.Athena.repositories;

import br.edu.ifpb.pweb2.kawa.Athena.models.EnrollmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EnrollmentStatusRepository extends JpaRepository<EnrollmentStatus, Long> {

    List<EnrollmentStatus> findBySemesterId(Long id);
    @Query("SELECT e FROM EnrollmentStatus e \n" +
            "JOIN e.semester s \n" +
            "JOIN s.institution i \n" +
            "WHERE i.id = :institutionId")
    List<EnrollmentStatus> findByInstitution(@Param("institutionId") Long institutionId);

    List<EnrollmentStatus> findBySemesterEndsAtBefore(LocalDate currentDate);

    List<EnrollmentStatus> findBySemesterEndsAtBetween(LocalDate currentDate, LocalDate nDaysAfter);
}

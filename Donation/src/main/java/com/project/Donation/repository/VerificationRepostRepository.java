package com.project.Donation.repository;

import com.project.Donation.entity.VerificationReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationRepostRepository extends JpaRepository<VerificationReport,Long> {
}

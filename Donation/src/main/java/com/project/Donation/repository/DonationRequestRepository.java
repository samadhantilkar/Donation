package com.project.Donation.repository;

import com.project.Donation.entity.DonationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRequestRepository extends JpaRepository<DonationRequest,Long> {
    List<DonationRequest> findByRequesterId(Long id);
}

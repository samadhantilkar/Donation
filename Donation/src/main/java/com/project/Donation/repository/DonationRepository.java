package com.project.Donation.repository;

import com.project.Donation.entity.Donation;
import com.project.Donation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation,Long> {

    List<Donation> findByDonor(User user);

    // Filter donations by city (via DonationRequest's location)
    @Query("SELECT d FROM Donation d JOIN d.donationRequest dr WHERE dr.location = :city")
    List<Donation> findByCity(@Param("city") String city);

    // Filter donations by request ID
    List<Donation> findByDonationRequestId(Long requestId);
}

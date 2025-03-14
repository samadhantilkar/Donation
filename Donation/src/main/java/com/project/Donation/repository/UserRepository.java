package com.project.Donation.repository;

import com.project.Donation.entity.Enum.ROLE;
import com.project.Donation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

    List<User> findByCityAndRole(String city, ROLE role);

    List<User> findByRoleAndCity(ROLE role, String city);
}

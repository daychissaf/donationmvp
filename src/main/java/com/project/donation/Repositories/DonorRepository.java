package com.project.donation.Repositories;

import com.project.donation.Models.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorRepository extends JpaRepository<Donor, Long> {



}

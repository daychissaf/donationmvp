package com.project.donation.Services;

import com.project.donation.Models.Donor;

import java.util.List;
import java.util.Optional;

public interface DonorService {

    boolean userExists(String email);
    boolean createUser(Donor user);

    List<Donor> getAllUsers();

    boolean updateUser(Long idUser, Donor user);
    boolean deleteUser(Long idUser);

}

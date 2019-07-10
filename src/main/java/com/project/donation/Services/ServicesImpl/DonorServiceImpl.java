package com.project.donation.Services.ServicesImpl;

import com.project.donation.Models.Donor;
import com.project.donation.Repositories.DonorRepository;
import com.project.donation.Services.DonorService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DonorServiceImpl implements DonorService {

    @Autowired
    DonorRepository userRepository;

    @Override
    public boolean userExists(String email) {

        List<Donor> users;
        users=userRepository.findAll();

        if(users == null) return false;

        for(Donor user: users) {

            if(user.getEmail().equals(email)) return true;
        }
        return false;
    }

    @Override
    public boolean createUser(Donor user) {

        if( userExists(user.getEmail()) ) return false;
        if(user.getFirstName() == null || user.getLastName() == null || user.getEmail() == null || user.getPassword() == null) return false;
        userRepository.save(user);
        return true;
    }

    @Override
    public List<Donor> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public boolean updateUser(Long idUser, Donor user) {

        Donor user1=userRepository.findById(idUser).get();


        if (!user1.equals(Optional.empty())) {
            if(user.getFirstName()!=null) user1.setFirstName(user.getFirstName());
            if(user.getLastName()!=null) user1.setLastName(user.getLastName());
            if(user.getEmail()!=null) {
                if (userExists(user.getEmail())) return false;
                user1.setEmail(user.getEmail());
            }
            if(user.getPassword()!=null) user1.setPassword(user.getPassword());
            userRepository.save(user1);
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteUser(Long idUser) {
        Optional<Donor> user = userRepository.findById(idUser);
        if(!user.equals(Optional.empty())) {
            user.get().setActive(false);
            userRepository.save(user.get());
            return true;
        }
        return false;
    }

}


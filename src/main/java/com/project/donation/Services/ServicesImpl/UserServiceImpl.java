package com.project.donation.Services.ServicesImpl;

import com.project.donation.Models.User;
import com.project.donation.Repositories.UserRepository;
import com.project.donation.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean userExists(String email) {

        List<User> users;
        users=userRepository.findAll();

        if(users == null) return false;

        for(User user: users) {

            if(user.getEmail().equals(email)) return true;
        }
        return false;
    }

    @Override
    public boolean createUser(User user) {

        if( userExists(user.getEmail()) ) return false;
        if(user.getFirstName() == null || user.getLastName() == null || user.getEmail() == null || user.getPassword() == null) return false;
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public boolean updateUser(Long idUser, User user) {

        User user1=userRepository.findById(idUser).get();


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
        Optional<User> user = userRepository.findById(idUser);
        if(!user.equals(Optional.empty())) {
            user.get().setActive(false);
            userRepository.save(user.get());
            return true;
        }
        return false;
    }
}


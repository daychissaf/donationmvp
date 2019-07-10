package com.project.donation.Controllers;

import com.project.donation.Models.Donor;
import com.project.donation.Services.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DonorCrudController {

    @Autowired
    private DonorService userService;

    @GetMapping("/donors")
    public List<Donor> getAllUsers(){
        return  userService.getAllUsers();
    }

    @PostMapping("/createDonor")
    public boolean createUser(@RequestBody Donor donor) {
        return userService.createUser(donor);
    }

    @PutMapping("/updateDonor/{idDonor}")
    public boolean updateUser(@PathVariable("idDonor") Long idDonor, @RequestBody Donor donor) {return userService.updateUser(idDonor,donor);}

    @DeleteMapping("/deleteDonor/{idDonor}")
    public boolean deleteUser(@PathVariable("idDonor") Long idDonor) {return userService.deleteUser(idDonor);}
}

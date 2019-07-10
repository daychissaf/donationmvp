package com.project.donation.Controllers;

import com.project.donation.Models.Sponsor;
import com.project.donation.Services.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SponsorCrudController {

    @Autowired
    private SponsorService sponsorService;

    @GetMapping("/sponsors")
    public List<Sponsor> getAllSponsors(){
        return  sponsorService.getAllSponsors();
    }

    @PostMapping("/createSponsor")
    public boolean createSponsor(@RequestBody Sponsor sponsor) {
        return sponsorService.createSponsor(sponsor);
    }

    @PutMapping("/updateSponsor/{idSponsor}")
    public boolean updateSponsor(@PathVariable("idSponsor") Long idSponsor, @RequestBody Sponsor sponsor) {
        return sponsorService.updateSponsor(idSponsor,sponsor);}

    @DeleteMapping("/deleteSponsor/{idSponsor}")
    public boolean deleteSponsor(@PathVariable("idSponsor") Long idSponsor) {return sponsorService.deleteSponsor(idSponsor);}
}

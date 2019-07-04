package com.project.donation.Services.ServicesImpl;


import com.project.donation.Models.Sponsor;
import com.project.donation.Repositories.SponsorRepository;
import com.project.donation.Services.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SponsorServiceImpl implements SponsorService {

    @Autowired
    SponsorRepository sponsorRepository;


    @Override
    public List<Sponsor> getAllSponsors() {
        return sponsorRepository.findAll();
    }

    @Override
    public boolean createSponsor(Sponsor sponsor) {

        if(sponsor.getSponsorName() == null) return false;

        sponsorRepository.save(sponsor);
        return true;
    }

    @Override
    public boolean updateSponsor(Long idSponsor, Sponsor sponsor) {
        Sponsor sponsor1=sponsorRepository.findById(idSponsor).get();

        if (!sponsor1.equals(Optional.empty())) {
            if(sponsor.getSponsorName()!=null) sponsor1.setSponsorName(sponsor.getSponsorName());

            sponsorRepository.save(sponsor1);
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteSponsor(Long idSponsor) {
        if(!sponsorRepository.findById(idSponsor).equals(Optional.empty())) {
            sponsorRepository.deleteById(idSponsor);
            return true;
        }
        return false;
    }
}

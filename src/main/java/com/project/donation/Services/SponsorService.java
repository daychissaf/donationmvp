package com.project.donation.Services;

import com.project.donation.Models.Sponsor;
import com.project.donation.Models.User;

import java.util.List;

public interface SponsorService {
    List<Sponsor> getAllSponsors();

    boolean sponsorExists(Long idSponsor);

    boolean createSponsor(Sponsor sponsor);

    boolean updateSponsor(Long idSponsor, Sponsor sponsor);

    boolean deleteSponsor(Long idSponsor);
}

package com.project.donation.Services.ServicesImpl;

import com.project.donation.Models.Association;
import com.project.donation.Models.Project;
import com.project.donation.Repositories.AssociationRepository;
import com.project.donation.Repositories.ProjectRepository;
import com.project.donation.Services.AssociationService;
import com.project.donation.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssociationServiceImpl implements AssociationService {

    @Autowired
    AssociationRepository associationRepository;
    @Autowired
    ProjectService projectService;
    @Override
    public List<Association> getAllAssocations() {

        return associationRepository.findAll();
    }

    @Override
    public boolean createAssociation(Association association) {

        associationRepository.save(association);
        return true;
    }

    @Override
    public boolean updateAssociation(Long idAssociation, Association association) {

        Association association1 = associationRepository.findById(idAssociation).get();
        if (!association1.equals(Optional.empty())) {
            if(association.getAssociationName() != null){
                association1.setAssociationName(association.getAssociationName());
                associationRepository.save(association1);
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean deleteAssociation(Long idAssociation) {

        Optional<Association> association = associationRepository.findById(idAssociation);
        if (!association.equals(Optional.empty())) {
            association.get().setActive(false);
            associationRepository.save(association.get());
            return true;
        }
        return false;
    }
}

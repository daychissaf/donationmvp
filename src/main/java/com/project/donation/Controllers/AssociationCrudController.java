package com.project.donation.Controllers;

import com.project.donation.Models.Association;
import com.project.donation.Services.AssociationService;
import com.project.donation.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssociationCrudController {

    @Autowired
    private AssociationService associationService;

    @GetMapping("/associations")
    public List<Association> getAllAssociations() {
        return associationService.getAllAssocations();
    }

    @PostMapping("/createAssociation")
    public boolean createAssociation(@RequestBody Association association) {
        return associationService.createAssociation(association);
    }

    @PutMapping("/updateAssociation/{idAssociation}")
    public boolean updateAssociation(@PathVariable("idAssociation") Long idAssociation ,@RequestBody Association association) {
        return associationService.updateAssociation(idAssociation, association);
    }

    @DeleteMapping("/deleteAssociation/{idAssociation}")
    public boolean deleteAssociation(@PathVariable("idAssociation") Long idAssociation) {
        return associationService.deleteAssociation(idAssociation);
    }
}

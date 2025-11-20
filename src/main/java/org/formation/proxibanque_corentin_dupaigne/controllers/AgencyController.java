package org.formation.proxibanque_corentin_dupaigne.controllers;

import org.formation.proxibanque_corentin_dupaigne.models.Agency;
import org.formation.proxibanque_corentin_dupaigne.services.AgencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agencies")
public class AgencyController {

    private final AgencyService agencyService;

    public AgencyController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @GetMapping
    public ResponseEntity<List<Agency>> getAllAgencies() {
        List<Agency> agencies = agencyService.findAll();
        return new ResponseEntity<>(agencies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agency> getAgencyById(@PathVariable Long id) {
        return agencyService.findById(id)
                .map(agency -> new ResponseEntity<>(agency, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Agency> createAgency(@RequestBody Agency agency) {
        Agency savedAgency = agencyService.save(agency);
        return new ResponseEntity<>(savedAgency, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agency> updateAgency(@PathVariable Long id, @RequestBody Agency agency) {
        Agency updatedAgency = agencyService.update(id, agency);
        if (updatedAgency != null) {
            return new ResponseEntity<>(updatedAgency, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgency(@PathVariable Long id) {
        agencyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


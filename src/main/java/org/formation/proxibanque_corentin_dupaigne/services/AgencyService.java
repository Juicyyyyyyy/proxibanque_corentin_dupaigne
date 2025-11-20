package org.formation.proxibanque_corentin_dupaigne.services;

import org.formation.proxibanque_corentin_dupaigne.models.Agency;
import org.formation.proxibanque_corentin_dupaigne.repositories.AgencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgencyService {

    private final AgencyRepository agencyRepository;

    public AgencyService(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    public List<Agency> findAll() {
        return agencyRepository.findAll();
    }

    public Optional<Agency> findById(Long id) {
        return agencyRepository.findById(id);
    }

    public Agency save(Agency agency) {
        return agencyRepository.save(agency);
    }

    public void deleteById(Long id) {
        agencyRepository.deleteById(id);
    }

    public Agency update(Long id, Agency agency) {
        if (agencyRepository.existsById(id)) {
            agency.setId(id);
            return agencyRepository.save(agency);
        }
        return null;
    }
}


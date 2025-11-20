package org.formation.proxibanque_corentin_dupaigne.services;

import org.formation.proxibanque_corentin_dupaigne.models.Advisor;
import org.formation.proxibanque_corentin_dupaigne.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Advisor> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Advisor> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public Advisor save(Advisor advisor) {
        return employeeRepository.save(advisor);
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    public Advisor update(Long id, Advisor advisor) {
        if (employeeRepository.existsById(id)) {
            advisor.setId(id);
            return employeeRepository.save(advisor);
        }
        return null;
    }
}


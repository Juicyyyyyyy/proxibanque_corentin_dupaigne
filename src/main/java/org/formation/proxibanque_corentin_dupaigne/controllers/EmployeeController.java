package org.formation.proxibanque_corentin_dupaigne.controllers;

import org.formation.proxibanque_corentin_dupaigne.models.Advisor;
import org.formation.proxibanque_corentin_dupaigne.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Advisor>> getAllEmployees() {
        List<Advisor> advisors = employeeService.findAll();
        return new ResponseEntity<>(advisors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Advisor> getEmployeeById(@PathVariable Long id) {
        return employeeService.findById(id)
                .map(employee -> new ResponseEntity<>(employee, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Advisor> createEmployee(@RequestBody Advisor advisor) {
        Advisor savedAdvisor = employeeService.save(advisor);
        return new ResponseEntity<>(savedAdvisor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Advisor> updateEmployee(@PathVariable Long id, @RequestBody Advisor advisor) {
        Advisor updatedAdvisor = employeeService.update(id, advisor);
        if (updatedAdvisor != null) {
            return new ResponseEntity<>(updatedAdvisor, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


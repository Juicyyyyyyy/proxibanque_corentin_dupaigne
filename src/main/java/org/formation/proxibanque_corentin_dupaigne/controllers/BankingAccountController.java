package org.formation.proxibanque_corentin_dupaigne.controllers;

import org.formation.proxibanque_corentin_dupaigne.models.BankingAccount;
import org.formation.proxibanque_corentin_dupaigne.services.BankingAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banking-accounts")
public class BankingAccountController {

    private final BankingAccountService bankingAccountService;

    public BankingAccountController(BankingAccountService bankingAccountService) {
        this.bankingAccountService = bankingAccountService;
    }

    @GetMapping
    public ResponseEntity<List<BankingAccount>> getAllBankingAccounts() {
        List<BankingAccount> bankingAccounts = bankingAccountService.findAll();
        return new ResponseEntity<>(bankingAccounts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankingAccount> getBankingAccountById(@PathVariable Long id) {
        return bankingAccountService.findById(id)
                .map(bankingAccount -> new ResponseEntity<>(bankingAccount, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<BankingAccount> createBankingAccount(@RequestBody BankingAccount bankingAccount) {
        BankingAccount savedBankingAccount = bankingAccountService.save(bankingAccount);
        return new ResponseEntity<>(savedBankingAccount, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankingAccount> updateBankingAccount(@PathVariable Long id, @RequestBody BankingAccount bankingAccount) {
        BankingAccount updatedBankingAccount = bankingAccountService.update(id, bankingAccount);
        if (updatedBankingAccount != null) {
            return new ResponseEntity<>(updatedBankingAccount, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBankingAccount(@PathVariable Long id) {
        bankingAccountService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


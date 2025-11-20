package org.formation.proxibanque_corentin_dupaigne.services;

import org.formation.proxibanque_corentin_dupaigne.models.BankingAccount;
import org.formation.proxibanque_corentin_dupaigne.repositories.BankingAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankingAccountService {

    private final BankingAccountRepository bankingAccountRepository;

    public BankingAccountService(BankingAccountRepository bankingAccountRepository) {
        this.bankingAccountRepository = bankingAccountRepository;
    }

    public List<BankingAccount> findAll() {
        return bankingAccountRepository.findAll();
    }

    public Optional<BankingAccount> findById(Long id) {
        return bankingAccountRepository.findById(id);
    }

    public BankingAccount save(BankingAccount bankingAccount) {
        return bankingAccountRepository.save(bankingAccount);
    }

    public void deleteById(Long id) {
        bankingAccountRepository.deleteById(id);
    }

    public BankingAccount update(Long id, BankingAccount bankingAccount) {
        if (bankingAccountRepository.existsById(id)) {
            bankingAccount.setId(id);
            return bankingAccountRepository.save(bankingAccount);
        }
        return null;
    }
}


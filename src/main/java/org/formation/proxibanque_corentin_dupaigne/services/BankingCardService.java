package org.formation.proxibanque_corentin_dupaigne.services;

import org.formation.proxibanque_corentin_dupaigne.models.BankingCard;
import org.formation.proxibanque_corentin_dupaigne.repositories.BankingCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankingCardService {

    private final BankingCardRepository bankingCardRepository;

    public BankingCardService(BankingCardRepository bankingCardRepository) {
        this.bankingCardRepository = bankingCardRepository;
    }

    public List<BankingCard> findAll() {
        return bankingCardRepository.findAll();
    }

    public Optional<BankingCard> findById(Long id) {
        return bankingCardRepository.findById(id);
    }

    public BankingCard save(BankingCard bankingCard) {
        return bankingCardRepository.save(bankingCard);
    }

    public void deleteById(Long id) {
        bankingCardRepository.deleteById(id);
    }

    public BankingCard update(Long id, BankingCard bankingCard) {
        if (bankingCardRepository.existsById(id)) {
            bankingCard.setId(id);
            return bankingCardRepository.save(bankingCard);
        }
        return null;
    }
}


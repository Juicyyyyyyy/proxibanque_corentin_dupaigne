package org.formation.proxibanque_corentin_dupaigne.controllers;

import org.formation.proxibanque_corentin_dupaigne.models.BankingCard;
import org.formation.proxibanque_corentin_dupaigne.services.BankingCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banking-cards")
public class BankingCardController {

    private final BankingCardService bankingCardService;

    public BankingCardController(BankingCardService bankingCardService) {
        this.bankingCardService = bankingCardService;
    }

    @GetMapping
    public ResponseEntity<List<BankingCard>> getAllBankingCards() {
        List<BankingCard> bankingCards = bankingCardService.findAll();
        return new ResponseEntity<>(bankingCards, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankingCard> getBankingCardById(@PathVariable Long id) {
        return bankingCardService.findById(id)
                .map(bankingCard -> new ResponseEntity<>(bankingCard, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<BankingCard> createBankingCard(@RequestBody BankingCard bankingCard) {
        BankingCard savedBankingCard = bankingCardService.save(bankingCard);
        return new ResponseEntity<>(savedBankingCard, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankingCard> updateBankingCard(@PathVariable Long id, @RequestBody BankingCard bankingCard) {
        BankingCard updatedBankingCard = bankingCardService.update(id, bankingCard);
        if (updatedBankingCard != null) {
            return new ResponseEntity<>(updatedBankingCard, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBankingCard(@PathVariable Long id) {
        bankingCardService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


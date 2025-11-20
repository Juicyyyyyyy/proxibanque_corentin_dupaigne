package org.formation.proxibanque_corentin_dupaigne.repositories;

import org.formation.proxibanque_corentin_dupaigne.models.BankingCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankingCardRepository extends JpaRepository<BankingCard, Long> {
}


package org.formation.proxibanque_corentin_dupaigne;

import org.formation.proxibanque_corentin_dupaigne.models.*;
import org.formation.proxibanque_corentin_dupaigne.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;

@Component
public class DataSeeder implements CommandLineRunner {

    private final AgencyService agencyService;
    private final EmployeeService employeeService;
    private final ClientService clientService;
    private final BankingAccountService bankingAccountService;
    private final BankingCardService bankingCardService;

    public DataSeeder(AgencyService agencyService, EmployeeService employeeService,
                      ClientService clientService, BankingAccountService bankingAccountService,
                      BankingCardService bankingCardService) {
        this.agencyService = agencyService;
        this.employeeService = employeeService;
        this.clientService = clientService;
        this.bankingAccountService = bankingAccountService;
        this.bankingCardService = bankingCardService;
    }

    @Override
    public void run(String... args) {
        if (agencyService.findAll().isEmpty()) {
            seedData();
        }
    }

    private void seedData() {
        Agency agency1 = new Agency();
        agency1.setName("Agence Paris Centre");
        agency1 = agencyService.save(agency1);

        Agency agency2 = new Agency();
        agency2.setName("Agence Lyon Part-Dieu");
        agency2 = agencyService.save(agency2);

        Agency agency3 = new Agency();
        agency3.setName("Agence Marseille Canebière");
        agency3 = agencyService.save(agency3);

        Employee employee1 = new Employee();
        employee1.setAgency(agency1);
        employee1.setName("Jean Dupont");
        employee1.setEmail("jean.dupont@proxibanque.fr");
        employee1.setPassword("password123");
        employeeService.save(employee1);

        Employee employee2 = new Employee();
        employee2.setAgency(agency1);
        employee2.setName("Marie Martin");
        employee2.setEmail("marie.martin@proxibanque.fr");
        employee2.setPassword("password123");
        employeeService.save(employee2);

        Employee employee3 = new Employee();
        employee3.setAgency(agency2);
        employee3.setName("Pierre Bernard");
        employee3.setEmail("pierre.bernard@proxibanque.fr");
        employee3.setPassword("password123");
        employeeService.save(employee3);

        Employee employee4 = new Employee();
        employee4.setAgency(agency3);
        employee4.setName("Sophie Dubois");
        employee4.setEmail("sophie.dubois@proxibanque.fr");
        employee4.setPassword("password123");
        employeeService.save(employee4);

        Client client1 = new Client();
        client1.setName("Alice Durand");
        client1.setAddress("15 Rue de la République");
        client1.setPostalCode("75001");
        client1.setHometown("Paris");
        client1.setPhoneNumber("0612345678");
        client1 = clientService.save(client1);

        Client client2 = new Client();
        client2.setName("Robert Leroy");
        client2.setAddress("42 Avenue des Champs-Élysées");
        client2.setPostalCode("75008");
        client2.setHometown("Paris");
        client2.setPhoneNumber("0698765432");
        client2 = clientService.save(client2);

        Client client3 = new Client();
        client3.setName("Claire Moreau");
        client3.setAddress("8 Place Bellecour");
        client3.setPostalCode("69002");
        client3.setHometown("Lyon");
        client3.setPhoneNumber("0611223344");
        client3 = clientService.save(client3);

        Client client4 = new Client();
        client4.setName("Thomas Petit");
        client4.setAddress("25 Rue de la Canebière");
        client4.setPostalCode("13001");
        client4.setHometown("Marseille");
        client4.setPhoneNumber("0655667788");
        client4 = clientService.save(client4);

        Client client5 = new Client();
        client5.setName("Emma Rousseau");
        client5.setAddress("10 Boulevard Haussmann");
        client5.setPostalCode("75009");
        client5.setHometown("Paris");
        client5.setPhoneNumber("0644556677");
        client5 = clientService.save(client5);

        BankingAccount account1 = new BankingAccount();
        account1.setClient(client1);
        account1.setQuantity(5000.0f);
        account1.setOpenedDate(LocalDate.now().minusYears(2));
        account1 = bankingAccountService.save(account1);

        BankingAccount account2 = new BankingAccount();
        account2.setClient(client2);
        account2.setQuantity(15000.0f);
        account2.setOpenedDate(LocalDate.now().minusMonths(6));
        account2 = bankingAccountService.save(account2);

        BankingAccount account3 = new BankingAccount();
        account3.setClient(client3);
        account3.setQuantity(8000.0f);
        account3.setOpenedDate(LocalDate.now().minusYears(1));
        account3 = bankingAccountService.save(account3);

        BankingAccount account4 = new BankingAccount();
        account4.setClient(client4);
        account4.setQuantity(3000.0f);
        account4.setOpenedDate(LocalDate.now().minusMonths(3));
        account4 = bankingAccountService.save(account4);

        BankingAccount account5 = new BankingAccount();
        account5.setClient(client5);
        account5.setQuantity(12000.0f);
        account5.setOpenedDate(LocalDate.now().minusMonths(9));
        account5 = bankingAccountService.save(account5);

        Random random = new Random();

        BankingCard card1 = new BankingCard();
        card1.setBankingAccount(account1);
        card1.setCardNumber(1000000000000000L + random.nextInt(999999999));
        bankingCardService.save(card1);

        BankingCard card2 = new BankingCard();
        card2.setBankingAccount(account2);
        card2.setCardNumber(2000000000000000L + random.nextInt(999999999));
        bankingCardService.save(card2);

        BankingCard card3 = new BankingCard();
        card3.setBankingAccount(account3);
        card3.setCardNumber(3000000000000000L + random.nextInt(999999999));
        bankingCardService.save(card3);

        BankingCard card4 = new BankingCard();
        card4.setBankingAccount(account4);
        card4.setCardNumber(4000000000000000L + random.nextInt(999999999));
        bankingCardService.save(card4);

        BankingCard card5 = new BankingCard();
        card5.setBankingAccount(account5);
        card5.setCardNumber(5000000000000000L + random.nextInt(999999999));
        bankingCardService.save(card5);
    }
}


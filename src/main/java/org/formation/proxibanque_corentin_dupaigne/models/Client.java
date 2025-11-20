package org.formation.proxibanque_corentin_dupaigne.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;
    private String name;
    private String address;
    private String postalCode;
    private String hometown;
    private String phoneNumber;
    @ManyToOne
    private Advisor advisor;

}

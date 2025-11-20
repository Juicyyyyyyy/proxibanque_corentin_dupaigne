package org.formation.proxibanque_corentin_dupaigne.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Advisor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;
    @ManyToOne
    private Agency agency;
    private String name;
    private String email;
    private String password;
    // ca devrait etre un enum ou un objet Role mais j'ai un peu la flemme
    private String role;
}

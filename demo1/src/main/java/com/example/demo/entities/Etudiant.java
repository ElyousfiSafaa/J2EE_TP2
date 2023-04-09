package com.example.demo.entities;
import jakarta.persistence.*;
import lombok.*; /* Lombok:C'est un pluggin: à chaque enregistrement du fichier,le compilateur
Java compile avec lombok */
import java.util.Date;
@Entity //entité jpa
@Table(name="Etudiant") @Data @NoArgsConstructor @AllArgsConstructor
/* @Data:Pour ajouter les getters et les setters
   @NoArgsConstructor: Constructeur sans paramètre
   @AllArgsConstructor:Constructeur avec paramètre
   @Id:Champ clé primaire
*/
@Setter @Getter
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="Registration_number",unique = true)
    private String RegistrationNumber;
    @Column(name = "Name",length = 30,nullable = false)
    private String fullName;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    private Boolean stillActive;
}

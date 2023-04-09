package com.example.demo;
import com.example.demo.entities.Etudiant;
import com.example.demo.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;
import java.util.List;
@SpringBootApplication
/* configurer automatiquement Spring, et automatiquement scanner
 (Scan) le projet intégral afin de découvrir des composants de Spring */
public class Demo1Application implements CommandLineRunner {
    @Autowired
    //activer l'injection automatique de dépendance
    private EtudiantRepository etudiantRepository;
    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        //Create (Insertion)
        /*L'id est null car elle s'incrémente automatiquement */
        System.out.println("******************** Insert **********************");
        etudiantRepository.save(new Etudiant(null,"A1","EL YOUSFI Safaa",new Date(),true));
        etudiantRepository.save(new Etudiant(null,"A2","EL YOUSFI Ali",new Date(),true));
        System.out.println("***********************************************");
        System.out.println("Count:"+etudiantRepository.count());
        List<Etudiant> etudiantList=etudiantRepository.findAll();
        etudiantList.forEach(e-> {
                    System.out.println("====================================");
                    System.out.println(e.getId());
                    System.out.println(e.getRegistrationNumber());
                    System.out.println(e.getFullName());
        });
            System.out.println("********************** Read ************************");
            Etudiant etudiant=etudiantRepository.findById(1).orElse(null);
            System.out.println(etudiant.toString());
            System.out.println("********************** Update ************************");
            etudiant.setRegistrationNumber("S2");
            etudiantRepository.save(etudiant);
            System.out.println(etudiant.toString());
            System.out.println("********************** Delete ************************");
            etudiantRepository.deleteById(1);
            System.out.println("Count:" +etudiantRepository.count());


    }
}
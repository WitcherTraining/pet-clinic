package kz.springcourse.petclinic.bootstrap;

import kz.springcourse.petclinic.model.Owner;
import kz.springcourse.petclinic.model.Vet;
import kz.springcourse.petclinic.services.OwnerService;
import kz.springcourse.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Zhenya");
        owner1.setLastName("Protas");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Lera");
        owner1.setLastName("Akimova");

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner1.setId(3L);
        owner1.setFirstName("Lev");
        owner1.setLastName("Rasputin");

        ownerService.save(owner3);

        System.out.println("Owners data loaded...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Darya");
        vet1.setLastName("Mironova");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Zarina");
        vet2.setLastName("Esimova");

        vetService.save(vet2);

        System.out.println("Vets data loaded...");
    }
}

package kz.springcourse.petclinic.bootstrap;

import kz.springcourse.petclinic.model.*;
import kz.springcourse.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService,
                      SpecialtiesService specialtiesService,
                      VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtiesService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtiesService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtiesService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Zhenya");
        owner1.setLastName("Protas");
        owner1.setAddress("Krylova 58");
        owner1.setCity("Karaganda");
        owner1.setTelephone("87002222222");

        Pet zhenyasPet = new Pet();
        zhenyasPet.setName("Lisa");
        zhenyasPet.setPetType(savedCatPetType);
        zhenyasPet.setBirthDate(LocalDate.now());
        zhenyasPet.setOwner(owner1);
        owner1.getPets().add(zhenyasPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Lera");
        owner2.setLastName("Akimova");
        owner2.setAddress("Krivoguza 44");
        owner2.setCity("Karaganda");
        owner2.setTelephone("870034234234");

        Pet lerasPet = new Pet();
        lerasPet.setName("Samsa");
        lerasPet.setPetType(savedCatPetType);
        lerasPet.setBirthDate(LocalDate.now());
        lerasPet.setOwner(owner2);
        owner2.getPets().add(lerasPet);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(lerasPet);
        catVisit.setDescription("Cat fever");
        catVisit.setDate(LocalDate.now());

        visitService.save(catVisit);

        Owner owner3 = new Owner();
        owner3.setFirstName("Lev");
        owner3.setLastName("Rasputin");
        owner3.setAddress("Prospect Mira 8");
        owner3.setCity("Temirtau");
        owner3.setTelephone("870532594551");

        Pet levsPet = new Pet();
        levsPet.setName("Chernysh");
        levsPet.setPetType(savedDogPetType);
        levsPet.setBirthDate(LocalDate.now());
        levsPet.setOwner(owner3);
        owner3.getPets().add(levsPet);

        ownerService.save(owner3);

        System.out.println("Owners data loaded...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Darya");
        vet1.setLastName("Mironova");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Zarina");
        vet2.setLastName("Esimova");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Vets data loaded...");
    }
}

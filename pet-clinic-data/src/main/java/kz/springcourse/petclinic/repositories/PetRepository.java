package kz.springcourse.petclinic.repositories;

import kz.springcourse.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}

package kz.springcourse.petclinic.repositories;

import kz.springcourse.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}

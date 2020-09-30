package kz.springcourse.petclinic.repositories;

import kz.springcourse.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}

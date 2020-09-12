package kz.springcourse.petclinic.services;

import kz.springcourse.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}

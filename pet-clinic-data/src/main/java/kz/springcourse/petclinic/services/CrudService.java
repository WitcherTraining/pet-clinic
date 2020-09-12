package kz.springcourse.petclinic.services;

import java.util.Set;

// This interface is mimick to CrudRepository<T, ID>
public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}

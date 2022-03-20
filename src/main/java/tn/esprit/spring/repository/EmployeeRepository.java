package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
@Repository
public interface EmployeeRepository extends CrudRepository<Employe, Long>  {

}

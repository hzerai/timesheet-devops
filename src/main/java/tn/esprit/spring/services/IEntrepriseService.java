package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Entreprise;


public interface IEntrepriseService {
	
	List<Entreprise> retrieveAllEntreprises(); 
	Entreprise addEntreprise(Entreprise en);
	void deleteEntreprise(Long id);
	Entreprise updateEntreprise(Entreprise en);
	Entreprise retrieveEntreprise(Long id);

}

package tn.esprit.spring.services;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {
	
	@Autowired
	EntrepriseRepository entrepriseRepository;
	
	private static final Logger l = LogManager.getLogger(EntrepriseServiceImpl.class);


	@Override
	public List<Entreprise> retrieveAllEntreprises() {
		
		List<Entreprise> entreprises = null; 
		try {
			
			l.info("In Method retrieveAllEntreprises");
			entreprises = (List<Entreprise>) entrepriseRepository.findAll(); 
			l.debug("connexion à la DB Ok :"); 
			for (Entreprise entreprise : entreprises) {
				l.debug("entreprise :" + entreprise.getName()); 
			} 
			l.info("Out of Method retrieveAllEntreprises with Success : " + entreprises.size());
		}catch (Exception e) {
			l.error("Out of Method retrieveAllEntreprises with Errors : " + e); 
		}

		return entreprises;		
	}

	@Override
	public Entreprise addEntreprise(Entreprise en) {
		 
       Entreprise e_saved = null; 
		
		try {
			l.info("In Method addEntreprise");			
			e_saved = entrepriseRepository.save(en); 
			l.info("Out of Method addEntreprise with Success : " + e_saved.getName());
			
		} catch (Exception e) {
			l.error("Out of Method addEntreprise with Errors : " + e); 
		}
		
		return e_saved; 
	
	}

	@Override
	public void deleteEntreprise(Long id) {

		try {
			l.info("In Method deleteEntreprise");	
			entrepriseRepository.deleteById(id); 
			l.info("Out of Method deleteEntreprise with Success");
			
		} catch (Exception e) {
			l.error("Out of Method deleteEntreprise with Errors : " + e);		}	
		
	}

	@Override
	public Entreprise updateEntreprise(Entreprise en) {

        Entreprise entrepriseUpdated = null; 
		
		try {
			l.info("In Method entrepriseUpdated");	
			entrepriseUpdated = entrepriseRepository.save(en); 
			l.info("Out of Method entrepriseUpdated with Success : " + entrepriseUpdated.getName());
			
		} catch (Exception e) {
			l.error("Out of Method entrepriseUpdated with Errors : " + e);		}
		
		return entrepriseUpdated; 
		
	}

	@Override
	public Entreprise retrieveEntreprise(Long id) {
		Entreprise en = null; 
		try {
			l.info("In Method retrieveEntreprise");	
			en =  entrepriseRepository.findById(id).get(); 
			l.info("Out of Method retrieveEntreprise with Success : " + en.getName());
			
		} catch (Exception e) {
			l.error("Out of Method retrieveEntreprise with Errors : " + e);		}

		return en; 
	}

}

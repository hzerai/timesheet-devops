package tn.esprit.spring.control;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;

//entrepriseRestControl
@RestController // = @Controller + @ResponseBody 
//@Scope("session") 
//singleton c'est par défaut 
//prototype 
//request 
public class EntrepriseRestControl {
	
	// Couplage Faible 
		@Autowired 
		IEntrepriseService entrepriseService; 
	 
		// URL : http://localhost:????/????/retrieve-all-entreprises
		@GetMapping("/retrieve-all-entreprises")
		public List<Entreprise> retrieveAllEntreprises() {
			List<Entreprise> list = entrepriseService.retrieveAllEntreprises();
			return list;
		}
	 
		// http://localhost:????/timesheet-devops/retrieve-entreprise/{entreprise-id}
		@GetMapping("/retrieve-entreprise/{entreprise-id}")
		public Entreprise retrieveEntreprise(@PathVariable("entreprise-id") Long entrepriseId) {
			return entrepriseService.retrieveEntreprise(entrepriseId);
		}

		// Ajouter entreprise : http://localhost:????/timesheet-devops/add-entreprise 
		@PostMapping("/add-entreprise")
		public Entreprise addEntreprise(@RequestBody Entreprise en) {
			Entreprise entreprise = entrepriseService.addEntreprise(en); 
			return entreprise;
		}

		
		// Supprimer entreprise : 
		// http://localhost:????/timesheet-devops/remove-entreprise/{entreprise-id}
		@DeleteMapping("/remove-entreprise/{entreprise-id}") 
		public void removeEntreprise(@PathVariable("entreprise-id") Long entrepriseId) { 
			entrepriseService.deleteEntreprise(entrepriseId);
		} 

		// Modifier entreprise 
		// http://localhost:????/timesheet-devops/modify-entreprise 
		@PutMapping("/modify-entreprise") 
		public Entreprise updateEntreprise(@RequestBody Entreprise entreprise) {
			return entrepriseService.updateEntreprise(entreprise);
		}
		 
}

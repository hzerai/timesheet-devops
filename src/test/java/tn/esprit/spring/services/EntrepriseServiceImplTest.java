package tn.esprit.spring.services;

import java.text.ParseException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Entreprise;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class EntrepriseServiceImplTest {
	
	
	@Autowired
	private IEntrepriseService entrepriseService;
	
	
	@Test
	@Order(1)
	public void testRetrieveAllEntreprises() {
		List<Entreprise> listEntreprises = entrepriseService.retrieveAllEntreprises();
		Assertions.assertEquals(0, listEntreprises.size());		
		
	}
	
	@Test
	@Order(2)
	public void testAddEntreprise() throws ParseException {
		Entreprise entreprise = new Entreprise("Vermeg", "Raison Sociale");
		Entreprise entrepriseAdded = entrepriseService.addEntreprise(entreprise);
		Assertions.assertEquals(entreprise.getName(), entrepriseAdded.getName());
		}
	
	@Test
	@Order(3)
	public void testUpdateEntreprise () throws ParseException {
		Entreprise entreprise = new Entreprise(1L,"Vermeg2","Raison Sociale 2");
		Entreprise entrepriseUpdated = entrepriseService.updateEntreprise(entreprise);
		Assertions.assertEquals(entreprise.getName(), entrepriseUpdated.getName());
	}
		
	@Test
	@Order(4)
	public void testRetrieveEntreprise() {
		Entreprise entrepriseRetreived = entrepriseService.retrieveEntreprise(1L);
		Assertions.assertEquals(1L, entrepriseRetreived.getId());
	}
	
	@Test
	@Order(5)
    public void testDeleteEntreprise() {
		entrepriseService.deleteEntreprise(1L);
		Assertions.assertEquals(0, entrepriseService.retrieveAllEntreprises().size());		

	}	
}


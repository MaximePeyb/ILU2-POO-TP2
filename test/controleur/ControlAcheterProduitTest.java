package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private ControlAcheterProduit ctrl;
	private ControlTrouverEtalVendeur ctrlEtal;
	private ControlVerifierIdentite ctrlVerif;
	private Chef chef;
	
	@BeforeEach
	private void reset() {
		village = new Village("JKLM",15,5);
		chef = new Chef("chef", 354, village);
		village.setChef(chef);
		ctrlEtal = new ControlTrouverEtalVendeur(village);
		ctrlVerif = new ControlVerifierIdentite(village);
		ctrl = new ControlAcheterProduit(ctrlVerif, ctrlEtal, village);
	}
	
	
	@Test
	void testControlAcheterProduit() {
		assertNotNull(ctrl);
	}

	@Test
	void testTrouverEtalProduit() { 
		assertNull(ctrl.trouverEtalProduit("e"));
		Gaulois marchand = new Gaulois("marchand", 5161);
		village.ajouterHabitant(marchand);
		village.installerVendeur(marchand, "e", 8);
		assertEquals(ctrl.trouverEtalProduit("e")[0],"marchand");
		assertEquals(ctrl.trouverEtalProduit("e").length,1);
	}

	@Test
	void testAcheterProduits() {
		Gaulois marchand = new Gaulois("marchand", 5161);
		village.ajouterHabitant(marchand);
		village.installerVendeur(marchand, "e", 8);
		Gaulois client = new Gaulois("client",12);
		assertEquals(ctrl.acheterProduits(marchand.getNom(),3), 3);
		assertEquals(ctrl.acheterProduits(marchand.getNom(),7), 5);
		
	}

}

package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	private Village village;
	private ControlAfficherMarche ctrl;
	private Chef chef;
	
	
	@BeforeEach
	private void reset() {
		village = new Village("papope", 3,3);
		ctrl = new ControlAfficherMarche(village);
		chef = new Chef("capichef", 12, village);
		village.setChef(chef);
	}
	
	
	@Test
	void testControlAfficherMarche() {
		assertNotNull(ctrl);
	}

	@Test
	void testDonnerInfosMarche() {
		String[] infos = ctrl.donnerInfosMarche();
		
		assertEquals(0, infos.length);
		
		Gaulois g = new Gaulois("g", 35);
		village.ajouterHabitant(g);
		village.installerVendeur(g, "Prod", 3);
		infos = ctrl.donnerInfosMarche();
		assertEquals(3, infos.length);
	}

}

package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private ControlPrendreEtal ctrl;
	private ControlVerifierIdentite ctrlVerif;
	private Chef chef;
	
	
	@BeforeEach
	private void reset() {
		village = new Village("papope", 3,3);
		ctrlVerif = new ControlVerifierIdentite(village);
		ctrl = new ControlPrendreEtal(ctrlVerif, village);
		chef = new Chef("capichef", 12, village);
		village.setChef(chef);
	}
	
	@Test
	void testControlPrendreEtal() {
		assertNotNull(ctrl);
	}

	@Test
	void testResteEtals() {
		// Teste aussi prendreEtal par nécessité
		assert(ctrl.resteEtals());
		Gaulois g1 = new Gaulois("g1", 2);village.ajouterHabitant(g1);
		Druide g2 = new Druide("g2", 2,3,5);village.ajouterHabitant(g2);
		Gaulois g3 = new Gaulois("g3", 2);village.ajouterHabitant(g3);
		
		ctrl.prendreEtal(g1.getNom(), "Prod7", 3);
		ctrl.prendreEtal(g2.getNom(), "Prod8", 3);
		ctrl.prendreEtal(g3.getNom(), "Prod9", 3);

		assert(!ctrl.resteEtals());
	}

	@Test
	void testVerifierIdentite() {
		assert(!ctrl.verifierIdentite("e"));
		village.ajouterHabitant(new Gaulois("e", 12));
		assert(ctrl.verifierIdentite("e"));
	}

}

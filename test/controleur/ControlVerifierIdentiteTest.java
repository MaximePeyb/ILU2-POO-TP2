package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private ControlVerifierIdentite ctrlVerif;
	private Village village;
	private Chef chef;
	
	@BeforeEach
	private void reset() {
		village = new Village("plop", 57, 2);
		ctrlVerif = new ControlVerifierIdentite(village);
		chef = new Chef("heheheha", 45, village);
		village.setChef(chef);
	}
	
	@Test
	void testControlVerifierIdentite() {
		assertNotNull(ctrlVerif);
	}

	@Test
	void testVerifierIdentite() {
		assert(!ctrlVerif.verifierIdentite("e"));
		village.ajouterHabitant(new Gaulois("e", 12));
		assert(ctrlVerif.verifierIdentite("e"));
	}
}

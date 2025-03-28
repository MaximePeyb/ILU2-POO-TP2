package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
	private Chef chef;
	private ControlEmmenager ctrl;
	
	
	@BeforeEach
	private void reset() {
		village = new Village("On est là", 30, 5);
		chef = new Chef("capichef",348,village);
		village.setChef(chef);
		ctrl = new ControlEmmenager(village);
	}
	
	
	@Test
	void testControlEmmenager() {
		assertNotNull(ctrl,"Constructeur ne renvoie pas null");
	}
	
	@Test
	void testIsHabitant(){
		assertFalse(ctrl.isHabitant("Bonemine"));
		ctrl.ajouterGaulois("Bonemine", 10);
		assertTrue(ctrl.isHabitant("Bonemine"));
		assertFalse(ctrl.isHabitant("Pferde signifie cheval en allemand"));
	}
	
	@Test
	void testAjouterDruide(){
		assertFalse(ctrl.isHabitant("Panoramix"));
		ctrl.ajouterDruide("Panoramix", 5, 2, 8);
		assert(ctrl.isHabitant("Panoramix"));
	}
}

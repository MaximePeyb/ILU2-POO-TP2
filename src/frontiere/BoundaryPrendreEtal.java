package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolé "+ nomVendeur+" mais il faut être un habitant de notre village pour commercer ici.");
		} else {
			System.out.println("Bonjour "+nomVendeur+", je vais regarder si je peux vous trouver un étal.");
			if(!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolé, je n'ai plus d'étal libre.");
			} else {
				installerVendeur(nomVendeur);
			}
		}
		
		
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("J'ai un étal pour vous !");
		String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?");
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
		
		int numEtal = controlPrendreEtal.prendreEtal(nomVendeur,produit,nbProduit);
		if(numEtal!=-1)
			System.out.println("Le vendeur "+nomVendeur+" s'est installé à l'étal n°"+numEtal);
	}
}

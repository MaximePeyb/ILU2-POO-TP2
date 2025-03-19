package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis d�sol� "+ nomVendeur+" mais il faut �tre un habitant de notre village pour commercer ici.");
		} else {
			System.out.println("Bonjour "+nomVendeur+", je vais regarder si je peux vous trouver un �tal.");
			if(!controlPrendreEtal.resteEtals()) {
				System.out.println("D�sol�, je n'ai plus d'�tal libre.");
			} else {
				installerVendeur(nomVendeur);
			}
		}
		
		
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("J'ai un �tal pour vous !");
		String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?");
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
		
		int numEtal = controlPrendreEtal.prendreEtal(nomVendeur,produit,nbProduit);
		if(numEtal!=-1)
			System.out.println("Le vendeur "+nomVendeur+" s'est install� � l'�tal n�"+numEtal);
	}
}

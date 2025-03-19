package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if(!controlLibererEtal.isVendeur(nomVendeur))
			System.out.println("Mais vous n'êtes pas sur notre marché aujourd'hui !");
		else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			if(donneesEtal[0].equals("true")) {
				String produit = donneesEtal[2]; 
				String qtInit = donneesEtal[3];
				String qtVendu = donneesEtal[4];
				System.out.println("Vous avez vendu "+qtVendu+" sur "+qtInit+" "+produit+".");
				System.out.println("AU revoir "+nomVendeur+", passez une bonne soirée.");
			}
		}
	}

}

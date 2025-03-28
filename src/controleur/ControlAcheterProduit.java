package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public String[] trouverEtalProduit(String produit) {
		Gaulois[] tabGaulois = village.rechercherVendeursProduit(produit);
		if(tabGaulois==null)
			return null;
		String[] tabVendeurs = new String[tabGaulois.length];
		
		for(int i=0;i<tabVendeurs.length;i++) {
			tabVendeurs[i] = tabGaulois[i].getNom();
		}
		
		return tabVendeurs;
	}
	
	public int acheterProduits(String nomVendeur, int nbProduits) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return etal.acheterProduit(nbProduits);
	}
}

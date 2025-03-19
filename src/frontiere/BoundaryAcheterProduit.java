package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
		String[] vendeurs = controlAcheterProduit.trouverEtalProduit(produit);
		
		if(vendeurs.length<1) 
			System.out.println("Personne ne vend ça ici !");
		else {
			StringBuilder question = new StringBuilder();
			question.append("Chez qui voulez-vous acheter ?\n");
			for(int i=0;i<vendeurs.length;i++) {
				question.append(i+1+" - "+vendeurs[i]+"\n");
			}
			String nomVendeur = vendeurs[Clavier.entrerEntier(question.toString())-1];                                            // Pas de contrôle flemme ^^'
			int nbProduits = Clavier.entrerEntier("Combien voulez-vous en acheter ?");
			int nbAchetes = controlAcheterProduit.acheterProduits(nomVendeur, nbProduits);
			System.out.println(nomAcheteur+" achète "+nbAchetes+" "+ produit+" à "+nomVendeur);
		}
	}
}

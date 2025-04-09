package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if(!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Vous ne faites pas partie du village !");
		} else {
		
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
			String[] vendeurs = controlAcheterProduit.trouverEtalProduit(produit);
			
			if(vendeurs == null) 
				System.out.println("Personne ne vend ça ici !");
			else {
				StringBuilder question = new StringBuilder();
				question.append("Chez qui voulez-vous acheter ?\n");
				for(int i=0;i<vendeurs.length;i++) {
					question.append(i+1+" - "+vendeurs[i]+"");
				}
				int nVendeur = Clavier.entrerEntier(question.toString())-1;
				while(nVendeur>=vendeurs.length || nVendeur<0) {
					System.out.println("Choisissez un nombre dans la liste !");
					nVendeur = Clavier.entrerEntier(question.toString())-1;
				}
				String nomVendeur = vendeurs[nVendeur];
				int nbProduits = Clavier.entrerEntier("Combien voulez-vous en acheter ?");
				while(nbProduits<0) {
					System.out.println("Choisissez un nombre supperieur à 0 !");
					nbProduits = Clavier.entrerEntier("Combien voulez-vous en acheter ?");
				}
				int nbAchetes = controlAcheterProduit.acheterProduits(nomVendeur, nbProduits);
				System.out.println(nomAcheteur+" achète "+nbAchetes+" "+ produit+" à "+nomVendeur);
				if (nbAchetes > nbProduits) {
					System.out.println("Bonemine est en rupture de stock !");
				}
			}
		}
	}
}

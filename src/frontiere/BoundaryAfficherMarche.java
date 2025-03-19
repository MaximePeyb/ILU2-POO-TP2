package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] dataMarche = controlAfficherMarche.donnerInfosMarche();
		if (dataMarche.length==0) 
			System.out.println("Le marché est vide, revenez plus tard.");
		else {
			System.out.println(nomAcheteur+", vous trouverez au marché :");
			for(int i=0;i<dataMarche.length;) {
				String vendeur = dataMarche[i++];
				String qt = dataMarche[i++];
				String produit = dataMarche[i++];
				
				System.out.println("- "+vendeur+" qui vend "+ qt+ " "+produit);
			}
		}
	}
}

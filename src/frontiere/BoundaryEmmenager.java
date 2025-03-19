package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà  un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("ÃŠtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bienvenue villageois "+nomVisiteur);
					controlEmmenager.ajouterGaulois(nomVisiteur, Clavier.entrerEntier("Quelle est votre force ?"));
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue, druide "+nomVisiteur);
		int forceDruide = Clavier.entrerEntier("Quelle est votre force ?");
		
		int effetPotMax=-1; int effetPotMin=0;
		while(effetPotMax<effetPotMin) {
			effetPotMax = Clavier.entrerEntier("Quelle est la force de votre potion la plus forte ?");
			effetPotMin = Clavier.entrerEntier("Quelle est la force de votre potion la plus faible ?");
			if(effetPotMax<effetPotMin)
				System.out.println("Attention, vous vous êtes trompé entre la meilleure et la pire potion !");
		}
		
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotMin, effetPotMax);
	}
}

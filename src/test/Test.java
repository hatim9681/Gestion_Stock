package test;

import java.util.Date;

import entities.Client;
import entities.Commande;
import entities.LigneCommande;
import entities.Produit;
import services.ClientService;
import services.CommandeService;
import services.ProduitService;

public class Test {

	public static void main(String[] args) {
		ClientService cs = new ClientService();
		cs.create(new Client("Rami", "0254879555", "rami@gmail.com"));
		cs.create(new Client("Safi", "0865784554", "safi@gmail.com"));

		ProduitService ps = new ProduitService();
		ps.create(new Produit("P21", 20));
		ps.create(new Produit("P55", 60));
		ps.create(new Produit("P27", 220));
		ps.create(new Produit("P28", 29));

		CommandeService cms = new CommandeService();
		cms.create(new Commande(101, new Date(), cs.findById(1)));
		cms.findById(101).getLigneCommandes().add(new LigneCommande(cms.findById(101), ps.findById(1), 2, 22));
		cms.findById(101).getLigneCommandes().add(new LigneCommande(cms.findById(101), ps.findById(2), 10, 70));

		
		
		cms.create(new Commande(103, new Date(), cs.findById(1)));
		cms.findById(103).getLigneCommandes().add(new LigneCommande(cms.findById(103), ps.findById(3), 2, 25));
		cms.findById(103).getLigneCommandes().add(new LigneCommande(cms.findById(103), ps.findById(2), 9, 74));

		
		cms.create(new Commande(102, new Date(), cs.findById(2)));

		cms.findById(102).getLigneCommandes().add(new LigneCommande(cms.findById(102), ps.findById(3), 21, 226));
		cms.findById(102).getLigneCommandes().add(new LigneCommande(cms.findById(102), ps.findById(4), 3, 70));

		for (Client c : cs.findAll()) {
			System.out.println(c);
			for (Commande cmd : cms.findAll()) {
				if (cmd.getClient().getId() == c.getId()) {
					System.out.println("\t" + cmd);
					for(LigneCommande lcs : cmd.getLigneCommandes())
						System.out.println("\t - "+lcs);
					System.out.println("### Total : " + cms.getTotalPrix(cmd.getCode()));
					
				}
			}
		}

	}

}

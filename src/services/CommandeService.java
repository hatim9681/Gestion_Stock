package services;

import java.util.ArrayList;
import java.util.List;

import dao.IDao;
import entities.Commande;
import entities.LigneCommande;

public class CommandeService implements IDao<Commande> {

	private List<Commande> commandes;

	public CommandeService() {
		commandes = new ArrayList<Commande>();
	}

	@Override
	public boolean create(Commande o) {
		return commandes.add(o);
	}

	@Override
	public boolean delete(Commande o) {
		// TODO Auto-generated method stub
		return commandes.remove(o);
	}

	@Override
	public boolean update(Commande newCommande) {
//		Commande oldCommande = findById(newCommande.getId());
//		oldCommande.setCode(newCommande.getCode());
//		oldCommande.setLibelle(newCommande.getLibelle());
		return true;
	}

	@Override
	public Commande findById(int code) {
		for (Commande s : commandes)
			if (s.getCode() == code)
				return s;
		return null;
	}

	@Override
	public List<Commande> findAll() {
		return commandes;
	}

	public double getTotalPrix(int code) {
		double total = 0;
		for(LigneCommande lc : findById(code).getLigneCommandes()) {
			total += lc.getPrixVente() * lc.getQuantite();
		}
		return total;
	}
}

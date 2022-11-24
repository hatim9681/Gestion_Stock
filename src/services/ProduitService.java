package services;

import java.util.ArrayList;
import java.util.List;

import dao.IDao;
import entities.Produit;

public class ProduitService implements IDao<Produit> {

	private List<Produit> produits;

	public ProduitService() {
		produits = new ArrayList<Produit>();
	}

	@Override
	public boolean create(Produit o) {
		return produits.add(o);
	}

	@Override
	public boolean delete(Produit o) {
		// TODO Auto-generated method stub
		return produits.remove(o);
	}

	@Override
	public boolean update(Produit newProduit) {
//		Produit oldProduit = findById(newProduit.getId());
//		oldProduit.setCode(newProduit.getCode());
//		oldProduit.setLibelle(newProduit.getLibelle());
		return true;
	}

	@Override
	public Produit findById(int id) {
		for (Produit s : produits)
			if (s.getId() == id)
				return s;
		return null;
	}

	@Override
	public List<Produit> findAll() {
		return produits;
	}

}

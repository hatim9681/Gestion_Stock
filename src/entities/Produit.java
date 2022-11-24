package entities;

public class Produit {
	private int id;
	private String designation;
	private double prixAchat;
	private static int comp;

	public Produit(String designation, double prixAchat) {
		this.id = ++comp;
		this.designation = designation;
		this.prixAchat = prixAchat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}

	@Override
	public String toString() {
		return "Produit : " + designation;
	}

}

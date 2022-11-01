package web;

import java.util.ArrayList;
import java.util.List;

import metier.entite.Produit;




//////permet de stocker les donnees qu'on va saisir a partir de jsp (html)
public class ModelProduit {
	
	
	private String motRechercher;
	private List<Produit> produits= new ArrayList<Produit>();
	
	public String getMotRechercher() {
		return motRechercher;
	}
	public void setMotRechercher(String motRechercher) {
		this.motRechercher = motRechercher;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	

}

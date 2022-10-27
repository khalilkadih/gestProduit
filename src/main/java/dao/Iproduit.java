package dao;

import java.util.List;

import metier.entite.Produit;

public interface Iproduit {

	public  Produit save(Produit produit);
	public List<Produit> produitChercher(String motchercher);
	public Produit getProduit(long idProduit);
	public Produit update(Produit produit);
	public void deleteProduit(long idProduit);
	
}

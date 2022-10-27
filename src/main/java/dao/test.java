package dao;

import metier.entite.*;
public class test {

	public static void main(String[] args) {

		ImplimentatioProduit produit = new ImplimentatioProduit();
		 Produit p1=produit.save(new Produit("HP 2002",2000,30));
		 Produit p2=produit.save(new Produit("phone",2000,300));
		 
		 System.out.println(p1.toString());
		 System.out.println(p2.toString());
		 
	}

}

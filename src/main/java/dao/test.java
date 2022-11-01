package dao;

import java.util.List;

import metier.entite.*;
public class test {

	public static void main(String[] args) {

		ImplimentatioProduit produit = new ImplimentatioProduit();
		
		 Produit p1=produit.save(new Produit("DELL 2002",2000,30));
		 Produit p2=produit.save(new Produit("SAMSUNG",2000,300));
		 
		 //System.out.println(p1.toString());
		 //System.out.println(p2.toString());
		 
		 System.out.println("\n Chercher ===>");
		 
//		 List<Produit> pd=produit.showAllProduit();
//		System.out.print(pd.size());		
//		 for(Produit p : pd ) {
//			 System.out.println(p.toString());
//		 }
		 
		 
		 List<Produit>prods=produit.produitChercher("%D%");
		 System.out.print(prods.size());	
		 
		 for(Produit p : prods ) {
			 
			 System.out.println(p.toString());
			 
		 	}
	}

}

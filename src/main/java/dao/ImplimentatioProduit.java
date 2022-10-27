package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import metier.entite.Produit;

public class ImplimentatioProduit implements Iproduit {

	@Override
	public Produit save(Produit produit) {
		Connection conection =SingeltonConnection.getConnection();
		
		try {
			PreparedStatement ps = conection.prepareStatement("INSERT INTO produit(DESIGNATION,PRIX,QUANTITE) VALUES (?,?,?)");
			ps.setString(1,produit.getDesignation());
			ps.setDouble(2, produit.getPrix());
			ps.setInt(3, produit.getQuantite());
			ps.executeUpdate();
			PreparedStatement ps1=conection.prepareStatement("SELECT MAX(ID) AS MAX_ID FROM PRODUIT");
			ResultSet rs=ps1.executeQuery();
			if(rs.next()) {
				produit.setId(rs.getLong("MAX_ID"));
				
			}
			
			
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return produit;
	
	}

	@Override
	public List<Produit> produitChercher(String motchercher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit getProduit(long idProduit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit update(Produit produit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void  deleteProduit(long idProduit) {
		// TODO Auto-generated method stub
	}

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.ResultsetRows;

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
		//System.out.print("hello ==>Start");		
		List<Produit> produits= new ArrayList<Produit>();

		Connection connection =SingeltonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM produit WHERE DESIGNATION LIKE ?");
			ps.setString(1,motchercher);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Produit p= new Produit();
				p.setId(rs.getLong("ID"));
				//je prend la valeur de la colone id et je vous le met dans id 
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
				produits.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		System.out.print(produits.size());	
		
		return produits;
	}

	@Override
	public Produit getProduit(long idProduit) {

		Produit p=null;
		Connection connection=SingeltonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("Select * from produit where id=?");
			ps.setLong(1,idProduit);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				p= new Produit();
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
		}

	@Override
	public Produit update(Produit produit) {
	
	return null;
	}

	@Override
	public void  deleteProduit(long idProduit) {
		Connection connection=SingeltonConnection.getConnection();
		try {
					PreparedStatement  ps=connection.prepareStatement("DELETE FROM produit WHERE id=?");
					ps.setLong(1,idProduit);
					ps.executeUpdate();
					ps.close();
					

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public List<Produit> showAllProduit(){
		List<Produit> produits= new ArrayList<Produit>();

		Connection connection =SingeltonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM produit");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Produit p= new Produit();
				p.setId(rs.getLong("ID"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
				produits.add(p);
			}
		} catch (SQLException e) {
			System.out.print("hello ==>from catch");		
			e.printStackTrace();
		}			
		return produits;
		
	}

}

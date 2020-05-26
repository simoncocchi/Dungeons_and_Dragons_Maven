package fr.campus.warriors.engine;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO extends DAO<Player>{

	public PlayerDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Player obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Player obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Player obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Player find(int id) {      
	      
	    try {
	      ResultSet result = this.connect.createStatement().executeQuery("SELECT Type,Nom,Image,NiveauVie,NiveauForce,MaxVie,MaxForce FROM hero WHERE id = " + id);
	      if(result.first()) {
	      if (result.getString("Type").equals("Guerrier")) {
	    	  Warrior player = new Warrior( 
	    			  result.getString("Nom"),
	    	          result.getString("Image"),
	    	          result.getInt("NiveauVie"),
	    	          result.getInt("MaxVie"),
	    	          result.getInt("NiveauForce"),
	    	          result.getInt("MaxVie")
	    	        );   
	    	  return player;
	      		} else if (result.getString("Type").equals("Mage")) {
	  	    	  Wizard player = new Wizard( 
		    			  result.getString("Nom"),
		    	          result.getString("Image"),
		    	          result.getInt("NiveauVie"),
		    	          result.getInt("MaxVie"),
		    	          result.getInt("NiveauForce"),
		    	          result.getInt("MaxForce")
		    	        );   
		    	  return player;
	      		} else {
	      			return null;
	      		}
	        }
	      
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
		return null;
	  }

	@Override
	public List<Player> findAll() {
		List<Player> playerList = new ArrayList<Player>();
		   try {
			      ResultSet result = this.connect.createStatement().executeQuery("SELECT Type,Nom,Image,NiveauVie,NiveauForce,MaxVie,MaxForce FROM hero");
			      while (result.next()) {
				      if (result.getString("Type").equals("Guerrier")) {
				    	  Warrior player = new Warrior( 
				    			  result.getString("Nom"),
				    	          result.getString("Image"),
				    	          result.getInt("NiveauVie"),
				    	          result.getInt("MaxVie"),
				    	          result.getInt("NiveauForce"),
				    	          result.getInt("MaxVie")
				    	        ); 
				    	  playerList.add(player);
			      } else if (result.getString("Type").equals("Mage")) {
		  	    	  Wizard player = new Wizard( 
			    			  result.getString("Nom"),
			    	          result.getString("Image"),
			    	          result.getInt("NiveauVie"),
			    	          result.getInt("MaxVie"),
			    	          result.getInt("NiveauForce"),
			    	          result.getInt("MaxForce")
			    	        );  
		  	    	  playerList.add(player);
			      }
			      }
		   		} catch (SQLException e) {
		  	      e.printStackTrace();
			    }
		return playerList;
		
	}
	

}

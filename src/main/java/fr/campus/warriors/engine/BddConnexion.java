package fr.campus.warriors.engine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BddConnexion {
	
	  private static String url = "jdbc:mariadb://localhost/D&D_DB";
	  private static String user = "simoncocchi";
	  private static String passwd = "sangoten";
	  private static Connection connect;
	  
	  public static Connection getInstance(){
		    if(connect == null){
		    	
		      try {
		        connect = DriverManager.getConnection(url, user, passwd);
		      } catch (SQLException e) {
		        e.printStackTrace();
		      }
		    } else {
		    	
		    }
		    return connect;
		  }   

}

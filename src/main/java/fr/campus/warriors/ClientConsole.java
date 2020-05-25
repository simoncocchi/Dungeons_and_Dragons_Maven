package fr.campus.warriors;

import java.io.File;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.campus.warriors.contracts.GameState;
import fr.campus.warriors.contracts.GameStatus;
import fr.campus.warriors.contracts.Hero;
import fr.campus.warriors.contracts.Map;
import fr.campus.warriors.contracts.WarriorsAPI;
import fr.campus.warriors.engine.BddConnexion;
import fr.campus.warriors.engine.Dice;
import fr.campus.warriors.engine.DiceCsv;
import fr.campus.warriors.engine.Warriors;

public class ClientConsole {
	
	private static String MENU_COMMENCER_PARTIE = "1";
	private static String MENU_QUITTER = "2";

	public static void main(String[] args) {
		
//        //create connection for a server installed in localhost, with a user "root" with no password
//        try (Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost/D&D_DB", "simoncocchi", "sangoten")) {
//            // create a Statement
//        	System.out.println("Ca ce connecte ?");
//                      
//                    Statement state = conn.createStatement();
//                    
//                    ResultSet result = state.executeQuery("SELECT * FROM hero");
//                    //On récupère les MetaData
//                    ResultSetMetaData resultMeta = result.getMetaData();
//                    
//                    //On affiche le nom des colonnes
//                    for(int i = 1; i <= resultMeta.getColumnCount(); i++)
//                      System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t");
// 
//                       
//                    while(result.next()){         
//                      for(int i = 1; i <= resultMeta.getColumnCount(); i++)
//                        System.out.print("\t" + result.getObject(i).toString() + "\t");
//                    }
//                
//        } catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		try {
			Connection conn = BddConnexion.getInstance();
		
			Statement state = conn.createStatement();
			
			ResultSet result = state.executeQuery("SELECT Nom, NiveauVie, NiveauForce FROM hero");
			
			ResultSetMetaData resultMeta = result.getMetaData();
			
			
			
			while(result.next()){   
//				Hero h = new Hero(result.getString("Nom"), result.getInt("Attack"), etc.);
		        System.out.println(result.getString("Nom"));
		        
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	
        
		
		System.out.println(args[0]);
		WarriorsAPI warriors;
		
		if(args[0].equals("DEBUG")) {
			warriors = new Warriors(true);
		} else {
			warriors = new Warriors(false);
		}
		
		Scanner sc = new Scanner(System.in);
		String menuChoice = "";
		do {
			menuChoice = displayMenu(sc);
			if(menuChoice.equals(MENU_COMMENCER_PARTIE)) {					
				startGame(warriors, sc);
			}			
		}while(!menuChoice.equals(MENU_QUITTER));
		sc.close();
		System.out.println("A bientôt");
	}

	private static void startGame(WarriorsAPI warriors, Scanner sc) {
		System.out.println();
		System.out.println("Entrez votre nom:");
		String playerName = sc.nextLine();
		
		System.out.println("Choisissez votre héro:");
		for(int i = 0; i < warriors.getHeroes().size(); i++) {
			Hero heroe = warriors.getHeroes().get(i);
			System.out.println(i+1 + " - " + heroe.getName());
			System.out.println("    Force d'attaque : " + heroe.getAttackLevel());
			System.out.println("    Niveau de vie : " + heroe.getLife());
		}
		Hero chosenHeroe = warriors.getHeroes().get(Integer.parseInt(sc.nextLine()) - 1);
		
		System.out.println("Choisissez votre map:");
		for(int i = 0; i < warriors.getMaps().size(); i++) {
			Map map = warriors.getMaps().get(i);
			System.out.println(i+1 + " - " + map.getName());
		}
		Map choosenMap = warriors.getMaps().get(Integer.parseInt(sc.nextLine()) - 1);

		GameState gameState = warriors.createGame(playerName, chosenHeroe, choosenMap);
		String gameId = gameState.getGameId();
		while (gameState.getGameStatus() == GameStatus.IN_PROGRESS) {
			System.out.println(gameState.getLastLog());
			System.out.println("\nAppuyer sur une touche pour lancer le dé"); 
			if(sc.hasNext()) {
				sc.nextLine();
				gameState = warriors.nextTurn(gameId);
			}									
		}
		
		System.out.println(gameState.getLastLog());
	}

	private static String displayMenu(Scanner sc) {
		System.out.println();
		System.out.println("================== Java Warriors ==================");
		System.out.println("1 - Commencer une partie");
		System.out.println("2 - Quitter"); 
		if(sc.hasNext()) {
			String choice = sc.nextLine();
			return choice;
		}		
		
		return "";
	}
}


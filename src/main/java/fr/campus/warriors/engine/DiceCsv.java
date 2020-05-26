package fr.campus.warriors.engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class DiceCsv extends Dice {
	
	
	
	List<Integer> csvDiveValue;
	private int index = 0;
	
	public DiceCsv(String path) {
		File file = new File("src/main/resources/dice.csv"); // chemin vers le fichier csv de ta machine src/main/resources/dice.csv
		System.out.println(file);
//		this.csvDiveValue = file.toInteger();
	}
/**
 * 
 * @param i
 * @return
 */
	public int diceThrow() {
		return index;
//		return this.csvDiveValue[index++];
		
	}
	
	

}
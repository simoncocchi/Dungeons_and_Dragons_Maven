package fr.campus.warriors.engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class DiceCsv extends Dice {
	
	
	
	List<Integer> csvDiveValue;
	private int index = 0;
	
	public DiceCsv() {
		File file = new File("src/main/resources/dice.csv"); // chemin vers le fichier csv de ta machine src/main/resources/dice.csv
		System.out.println(file);
//		this.csvDiveValue = file.toInteger();
	}

	public void next() {
//		return this.csvDiveValue[index++];
		
	}
	
	

}
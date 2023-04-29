package Task4;

import java.util.LinkedList;

import Task3.Cow;
import Task3.readFile;

public class Main {
	
	public static void main(String[] args) {
		String file = "C:/Users/Andrés/eclipse-workspace/Programming Methodology 22-23/src/";
		LinkedList<Cow> cows = new LinkedList<>();
		String separator = ",";
		
		cows = readFile.readCSV(file, separator);
		
		
	}
}

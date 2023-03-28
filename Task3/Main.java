package Task3;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		String file = "C:/Users/Andrés/eclipse-workspace/Programming Methodology 22-23/src/";
		LinkedList<Cow> cows = new LinkedList<>();
        String separator = ",";
        int squareMetters, numberOfCowsToSell;
        
        
        cows = readFile.readCSV(file, separator);
        numberOfCowsToSell = askNumberOfCowsToSell(cows);
        squareMetters = askMetters();
       
        
        
        for(Cow cow : cows) {
        	System.out.println("code: " + cow.getCode() + " neccesarySpace: " + cow.getNeccesarySpace() + " food: " + cow.getFoodConsumption() + " milk: " + cow.getMilkProduced());
        }

	}

	
	public static int askMetters() {
		Scanner scanner = new Scanner(System.in);
		int numMetters = 0;
		
		 boolean entradaValida = false;
	        while (!entradaValida) {
	            try {
	                System.out.print("Introduce the number of square metters of the new farm: ");
	                numMetters = scanner.nextInt();
	                entradaValida = true;
	            } catch (InputMismatchException e) {
	                System.out.println("Not valid entry. Please introduce a integer value.");
	                scanner.next();
	            }
	        }
	        scanner.close();
		
		return numMetters;
	}
	
	public static int askNumberOfCowsToSell(LinkedList<Cow> cows) {
		int numberOfCowsToSell=0;
		int numberOfCowsAvailable = cows.size();
		Scanner scanner = new Scanner(System.in);
		
		while(numberOfCowsToSell < 1 || numberOfCowsToSell > numberOfCowsAvailable) {
			System.out.println("How many cows do you want to sell? (Maximun %d): " + numberOfCowsAvailable);
			try {
				numberOfCowsToSell = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Not valid entry. Please introduce a integer value .");
                scanner.next();
            }
			
			if(numberOfCowsToSell > numberOfCowsAvailable) {
				System.out.println("The number of cows you want to sell is bigger than the cows you have available");
			}
		}
		return numberOfCowsToSell;
	}
	
	public static LinkedList<Cow> greedyMilkProduction(int numberOfCowsToSell, int squareMetters, LinkedList<Cow> cows){
		LinkedList<Cow> selectedCows = new LinkedList<Cow>();
		
		
		return selectedCows;
	}
}

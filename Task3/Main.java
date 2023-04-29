package Task3;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		String file = "C:/Users/Andrés/eclipse-workspace/Programming Methodology 22-23/src/";
		LinkedList<Cow> cows = new LinkedList<>();
		LinkedList<Cow> cowsDescendant = new LinkedList<>();
		LinkedList<Cow> cowsAscendant = new LinkedList<>();
		LinkedList<Cow> selectedCowsMilk = new LinkedList<Cow>();
		LinkedList<Cow> selectedCowsFood = new LinkedList<Cow>();
        String separator = ",";
        int squareMetters, numberOfCowsToSell;
        
        
        cows = readFile.readCSV(file, separator);
        numberOfCowsToSell = askNumberOfCowsToSell(cows);
        squareMetters = askMetters();
        cowsDescendant = quicksortAscendant(cows);
        
        selectedCowsMilk = greedy(numberOfCowsToSell, squareMetters, cowsDescendant);
        System.out.println("\nSelected Cows for maximize the milk production: ");
        for(Cow cow : selectedCowsMilk) {
        	System.out.println("code: " + cow.getCode() + " neccesarySpace: " + cow.getNeccesarySpace() + " food: " + cow.getFoodConsumption() + " milk: " + cow.getMilkProduced());
        }
        
        cowsAscendant = quicksortDescendant(cows);
        selectedCowsFood = greedy(numberOfCowsToSell, squareMetters, cowsAscendant);
        System.out.println("\nSelected Cows for minimize the food consumption: ");
        for(Cow cow : selectedCowsFood) {
        	System.out.println("code: " + cow.getCode() + " neccesarySpace: " + cow.getNeccesarySpace() + " food: " + cow.getFoodConsumption() + " milk: " + cow.getMilkProduced());
        }
        
	}

	public static int askMetters() {
		Scanner scanner = new Scanner(System.in);
		int numMetters = 0;
		
		 boolean entradaValida = false;
	        while (!entradaValida) {
	            try {
	                System.out.print("Introduce the number of square decimetters of the new farm: ");
	                numMetters = scanner.nextInt();
	                entradaValida = true;
	            } catch (InputMismatchException e) {
	                System.out.println("Not valid entry. Please introduce a integer value.");
	                scanner.next();
	            }
	        }
	        
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
	
	public static LinkedList<Cow> quicksortDescendant(LinkedList<Cow> cows) {
		if(cows.size()<=1) {
			return cows;
		}
		Cow pivot = cows.getFirst();
		LinkedList<Cow> less = new LinkedList<>();
	    LinkedList<Cow> greater = new LinkedList<>();
	    
	    for (int i = 1; i < cows.size(); i++) {
	    	Cow current = cows.get(i);
	        if (current.getFoodConsumption() <= pivot.getFoodConsumption()) {
	            less.add(current);
	        } else {
	            greater.add(current);
	        }
	    }
	    LinkedList<Cow> sortedLess = quicksortDescendant(less);
	    LinkedList<Cow> sortedGreater = quicksortDescendant(greater);
	    
	    sortedLess.add(pivot);
	    sortedLess.addAll(sortedGreater);
	    
		return sortedLess;
	}
	
	public static LinkedList<Cow> quicksortAscendant(LinkedList<Cow> cows) {
		if(cows.size()<=1) {
			return cows;
		}
		Cow pivot = cows.getFirst();
		LinkedList<Cow> less = new LinkedList<>();
	    LinkedList<Cow> greater = new LinkedList<>();
	    
	    for (int i = 1; i < cows.size(); i++) {
	    	Cow current = cows.get(i);
	        if (current.compareTo(pivot) == -1 || current.compareTo(pivot) == 0) {
	            less.add(current);
	        } else {
	            greater.add(current);
	        }
	    }
	    LinkedList<Cow> sortedLess = quicksortAscendant(less);
	    LinkedList<Cow> sortedGreater = quicksortAscendant(greater);
	    
	    sortedLess.add(pivot);
	    sortedLess.addAll(sortedGreater);
	    
		return sortedLess;
	}
		
	public static LinkedList<Cow> greedy(int numberOfCowsToSell, int squareMetters, LinkedList<Cow> cows){
		LinkedList<Cow> selectedCows = new LinkedList<Cow>();
		
		for(Cow cow : cows) {
			if(squareMetters <= 0 || numberOfCowsToSell == 0) {
				break;
			}else if(squareMetters >= cow.getNeccesarySpace()){
				selectedCows.add(cow);
				squareMetters -= cow.getNeccesarySpace();
				numberOfCowsToSell -= 1;
			}
		}
		return selectedCows;
	}
}
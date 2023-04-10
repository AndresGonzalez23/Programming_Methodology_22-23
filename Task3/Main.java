package Task3;

import java.util.*;

import Task2.Car;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		String file = "C:/Users/Andres/eclipse-workspace/Programming Methodology 22-23/src/";
		LinkedList<Cow> cows = new LinkedList<>();
		LinkedList<Cow> selectedCows = new LinkedList<Cow>();
        String separator = ",";
        int squareMetters, numberOfCowsToSell;
        
        
        cows = readFile.readCSV(file, separator);
        numberOfCowsToSell = askNumberOfCowsToSell(cows);
        squareMetters = askMetters();
        cows = quicksort(cows);
        
        selectedCows = greedyMilkProduction(numberOfCowsToSell, squareMetters, cows);
        for(Cow cow : selectedCows) {
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
	
	
	public static LinkedList<Cow> quicksort(LinkedList<Cow> cows) {
		if(cows.size()<=1) {
			return cows;
		}
		Cow pivot = cows.getFirst();
		LinkedList<Cow> less = new LinkedList<>();
	    LinkedList<Cow> greater = new LinkedList<>();
	    
	    for (int i = 1; i < cows.size(); i++) {
	    	Cow current = cows.get(i);
	        if (current.getMilkProduced() >= pivot.getMilkProduced()) {
	            less.add(current);
	        } else {
	            greater.add(current);
	        }
	    }
	    LinkedList<Cow> sortedLess = quicksort(less);
	    LinkedList<Cow> sortedGreater = quicksort(greater);
	    
	    sortedLess.add(pivot);
	    sortedLess.addAll(sortedGreater);
	    
		return sortedLess;
	}
		
	
	public static LinkedList<Cow> greedyMilkProduction(int numberOfCowsToSell, int squareMetters, LinkedList<Cow> cows){
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
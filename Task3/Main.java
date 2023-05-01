package Task3;

import java.util.*;
import java.io.*;

public class Main {

	/**********************************************************************************************************************************************************************************
	 * Class name: Main
	 * 
	 * Class description: Main class of the Task 3, here we have some methods as the
	 * ascending order and descending order Quicksort,the greedy strategy, the
	 * metters and number of cows we want to work with. In order to make the program
	 * work in other computers just change the file variable with the location of
	 * the .csv file without the name of the file As long as it is called
	 * cars_dataset.csv it will work
	 **********************************************************************************************************************************************************************************/

	public static void main(String[] args) {
		String file = "C:/Users/Andres/eclipse-workspace/Programming Methodology 22-23/src/";
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
		for (Cow cow : selectedCowsMilk) {
			System.out.println("code: " + cow.getCode() + " neccesarySpace: " + cow.getNeccesarySpace() + " food: "
					+ cow.getFoodConsumption() + " milk: " + cow.getMilkProduced());
		}

		cowsAscendant = quicksortDescendant(cows);
		selectedCowsFood = greedy(numberOfCowsToSell, squareMetters, cowsAscendant);
		System.out.println("\nSelected Cows for minimize the food consumption: ");
		for (Cow cow : selectedCowsFood) {
			System.out.println("code: " + cow.getCode() + " neccesarySpace: " + cow.getNeccesarySpace() + " food: "
					+ cow.getFoodConsumption() + " milk: " + cow.getMilkProduced());
		}

	}

	
	/**********************************************************************************************************************************************************************************
	 * Method name: askMetters
	 * 
	 * Description of the method: This method will ask the user how many metters we have available on the new farm.
	 *
	 **********************************************************************************************************************************************************************************/	
	
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

	/**********************************************************************************************************************************************************************************
	 * Method name: askNumberOfCowsToSell
	 * 
	 * Description of the method: This method will ask the user how many cows the farmer wants to sell as maximum.
	 *
	 **********************************************************************************************************************************************************************************/	
	
	public static int askNumberOfCowsToSell(LinkedList<Cow> cows) {
		int numberOfCowsToSell = 0;
		int numberOfCowsAvailable = cows.size();
		Scanner scanner = new Scanner(System.in);

		while (numberOfCowsToSell < 1 || numberOfCowsToSell > numberOfCowsAvailable) {
			System.out.println("How many cows do you want to sell? (Maximun %d): " + numberOfCowsAvailable);
			try {
				numberOfCowsToSell = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Not valid entry. Please introduce a integer value .");
				scanner.next();
			}

			if (numberOfCowsToSell > numberOfCowsAvailable) {
				System.out.println("The number of cows you want to sell is bigger than the cows you have available");
			}
		}

		return numberOfCowsToSell;

	}

	/**********************************************************************************************************************************************************************************
	 * Method name: quicksortDescendant
	 * 
	 * Description of the method: This method will do a quicksort algorithm on the list of cows to order them for the one that consumes less food to the one that produces more. 
	 *
	 **********************************************************************************************************************************************************************************/
	
	public static LinkedList<Cow> quicksortDescendant(LinkedList<Cow> cows) {
		if (cows.size() <= 1) {
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

	/**********************************************************************************************************************************************************************************
	 * Method name: quicksortAscendant
	 * 
	 * Description of the method: This method will do a quicksort algorithm on the list of cows to order them for the one that produces more milk to the one that produces less. 
	 *
	 **********************************************************************************************************************************************************************************/
	
	public static LinkedList<Cow> quicksortAscendant(LinkedList<Cow> cows) {
		if (cows.size() <= 1) {
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

	/**********************************************************************************************************************************************************************************
	 * Method name: greedy
	 * 
	 * Description of the method: This method performs the greedy stategy. It will iterates the cows list and check if every cow it tries fits in the metters that are left.
	 * If the algorithm fits all the possible space it will stops checking. 
	 *
	 **********************************************************************************************************************************************************************************/
	
	public static LinkedList<Cow> greedy(int numberOfCowsToSell, int squareMetters, LinkedList<Cow> cows) {
		LinkedList<Cow> selectedCows = new LinkedList<Cow>();

		for (Cow cow : cows) {
			if (squareMetters <= 0 || numberOfCowsToSell == 0) {
				break;
			} else if (squareMetters >= cow.getNeccesarySpace()) {
				selectedCows.add(cow);
				squareMetters -= cow.getNeccesarySpace();
				numberOfCowsToSell -= 1;
			}
		}
		return selectedCows;
	}
}
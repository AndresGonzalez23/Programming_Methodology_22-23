package Task2;

import java.io.*;
import java.util.*;

public class Main {

	/**********************************************************************************************************************************************************************************
	* Class name: Main 
	* 
	* Class description: Main class of the Task 2, here we have some methods as the ascending order Quicksort, the generation of POI's, the random generation 
	* between POI's, calculate the completation of the trip and the print of the final result of cars that can complet the tree and the ones that 
	* cannot do it. In order to make the program work in other computers just change the file variable with the location of the .csv file without the name of the file
	* As long as it is called cars_dataset.csv it will work
	**********************************************************************************************************************************************************************************/
	
	public static void main(String[] args) {
		
		String file = "C:/Users/Andres/eclipse-workspace/Programming Methodology 22-23/src/";
		LinkedList<Car> cars = new LinkedList<>();
        String separator = ",";
        int numPOI;
        
        numPOI = askPOI();
        System.out.println("Distances (in kms) among numbered POIs:  \n");
        int [] distances = generateDistancesBetweenPOI(numPOI);
        cars = readFile.readCSV(file, separator);
        calculateCompletationOfTrip(cars, distances);
        cars = quickSort(cars);
        printListOrdered(cars);
	}
	
	public static int askPOI() {
		
	/**********************************************************************************************************************************************************************************
	 * Method name: askPOI
	 * 
	 * Description of the method: This method will ask the user how many POI's he wants to create
	 *
	 **********************************************************************************************************************************************************************************/	
		
		Scanner scanner = new Scanner(System.in);
        int numPOI = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.print("Introduce the number of Points of Interes: ");
                numPOI = scanner.nextInt();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Not valid entry. Please introduce a integer value.");
                scanner.next();
            }
        }
        scanner.close();
        return numPOI;
    }
	
	public static int[] generateDistancesBetweenPOI(int numPOI) {
		/**********************************************************************************************************************************************************************************
		 * Method name: generateDistanceBetweenPOI
		 * 
		 * Description of the method: This method generates a random number of kilometers between 1 and 150 between every point.
		 *
		 **********************************************************************************************************************************************************************************/		
        Random random = new Random();
        int[] distances = new int[numPOI - 1];
        
        for (int i = 0; i < numPOI - 1; i++) {
            distances[i] = random.nextInt(150) + 1;
            System.out.println("[" +(i) + " ---> " + (i + 1) + "]: " + distances[i] + " km");
        }
        System.out.println("\n");
        return distances;
    }
	
	public static void calculateCompletationOfTrip(LinkedList<Car> cars, int [] distances) {
		
		/**********************************************************************************************************************************************************************************
		 * Method name: calculateCompletationOfTrip
		 * 
		 * Description of the method: This method will calculate the total distance of the whole trip and after that it will check car by car, which ones
		 * can complete the trip (dividing the total distance of the trip by 100 and multiply by the fuel Consumption of that model and of those that can 
		 * complete it will set the variable Completed to true, and the ConsumptionOnTrip to the number of Liters that the car will waste. 
		 *
		 **********************************************************************************************************************************************************************************/	
		int totalDistance = 0;
		
		for(int i = 0; i<distances.length;i++) {
			totalDistance = totalDistance + distances[i];
		}
		
		for(Car car : cars) {
			double consumptionOnTrip = (totalDistance/100)*car.getFuel_Consumption();
			if(consumptionOnTrip <= car.getTank_Capacity()) {
				car.setCompleted(true);
				car.setConsumptionOnTrip(consumptionOnTrip);
			}
		}
	}
	
	public static LinkedList<Car> quickSort(LinkedList<Car> cars) {
		
		/**********************************************************************************************************************************************************************************
		 * Method name: quickSory
		 * 
		 * Description of the method: This is the method that performs the Divide&Conquer algorithm, in this case we use a Quicksort. The idea is to
		 * take a pivot element, and with that one we will go sorting it. the method is recursive so it will be dividing all the divided parts until
		 * there is only one element in the list and then it will go back and ends the method sorting the list in ascending order. 
		 *
		 **********************************************************************************************************************************************************************************/	
		if(cars.size()<=1) {
			return cars;
		}
		Car pivot = cars.getFirst();
		LinkedList<Car> less = new LinkedList<>();
	    LinkedList<Car> greater = new LinkedList<>();
	    
	    for (int i = 1; i < cars.size(); i++) {
	    	Car current = cars.get(i);
	        if (current.getConsumptionOnTrip() <= pivot.getConsumptionOnTrip()) {
	            less.add(current);
	        } else {
	            greater.add(current);
	        }
	    }
	    LinkedList<Car> sortedLess = quickSort(less);
	    LinkedList<Car> sortedGreater = quickSort(greater);
	    
	    sortedLess.add(pivot);
	    sortedLess.addAll(sortedGreater);
	    
		return sortedLess;
	}
	
	public static void printListOrdered(LinkedList<Car> cars) {
		
		/**********************************************************************************************************************************************************************************
		 * Method name: printListOrdered
		 * 
		 * Description of the method: this methods prints all the cars that can complete the travel in ascending order with its total consumption, 
		 * and after that, all the cars that cannot complete the travel 
		 *
		 **********************************************************************************************************************************************************************************/	
		for(Car car : cars) {
			if(car.isCompleted()==true) {
				System.out.println("Total consumption for the car " + car.getModel() + ": " + car.getConsumptionOnTrip() + "(Tank capacity: " + car.getTank_Capacity() + ")");
			}else {
				System.out.println("The car " + car.getModel() + " will not complet the trip. Tank capacity: " + car.getTank_Capacity());
			}
		}
	}
	
}
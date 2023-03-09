package Task2;

import java.io.*;
import java.util.*;

public class Main {

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
		for(Car car : cars) {
			if(car.isCompleted()==true) {
				System.out.println("Total consumption for the car " + car.getModel() + ": " + car.getConsumptionOnTrip() + "(Tank capacity: " + car.getTank_Capacity() + ")");
			}else {
				System.out.println("The car " + car.getModel() + " will not complet the trip. Tank capacity: " + car.getTank_Capacity());
			}
		}
	}
	
}
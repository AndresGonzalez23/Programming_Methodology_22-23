package Task2;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		String file = "C:/Users/Andrés/eclipse-workspace/Programming Methodology 22-23/src/";
        String separator = ",";
        int numPOI;
        
        numPOI = askPOI();
        System.out.println("Distances (in kms) among numbered POIs:  \n");
        int [] distances = generateDistancesBetweenPOI(numPOI);
        System.out.println("\nProcessing cars dataset...\n############### CARS ###############");
        readFile.readCSV(file, separator);
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
        return distances;
    }
	
	

}

package Task4;

import java.util.*;
import java.util.stream.IntStream;
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
		String separator = ",";
		cows = readFile.readCSV(file, separator);
		int metters = askMetters();
		double litters = askLitters();
		int [] vaca_index = new int[cows.size()];
		int [] best_sol = new int[cows.size()];
		int [] primera_solucion = new int[cows.size()];
		int [] num = {0};
		case1Backtracking(cows, metters, litters, 0, vaca_index, best_sol, num, primera_solucion);
		
		double litros = 0.0;
		System.out.println("\nCows that are part of the first solution: \n");
		for (int i=0; i<primera_solucion.length ; i++) {
			if(primera_solucion[i] == 1){
				System.out.println("Cow: "+cows.get(i).getCode()+ " Number of litters it produces: " + cows.get(i).getMilkProduced());
				
			}
		}
		
		System.out.println("\nMaximum number of solutions: " + num[0] + "\n");
		
		System.out.println("Cows that are part of the best solution: \n");
		
		for (int i=0; i<best_sol.length ; i++) {
			if(best_sol[i] == 1){
				System.out.println("Cow: "+cows.get(i).getCode()+ " Number of litters it produces: " + cows.get(i).getMilkProduced());
				litros += cows.get(i).getMilkProduced();
			}
		}
		System.out.println("\nTotal number of litters of the best solution: " + litros);
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
	 * Method name: askLitters
	 * 
	 * Description of the method: This method will ask the user how many litters he want to achieve as minimum of production.
	 *
	 **********************************************************************************************************************************************************************************/	
	
	public static double askLitters() {
		Scanner scanner = new Scanner(System.in);
		double numberLitters = 0.0;

		boolean entradaValida = false;
		while (!entradaValida) {
			try {
				System.out.print("Introduce the number of minimum litters you want to achieve: ");
				numberLitters = scanner.nextDouble();
				entradaValida = true;
			} catch (InputMismatchException e) {
				System.out.println("Not valid entry. Please introduce a integer value.");
				scanner.next();
			}
		}
		return numberLitters;
	}

	/**********************************************************************************************************************************************************************************
	 * Method name: case1Backtracking
	 * 
	 * Description of the method: This method will perform the backtracking algorithm. The maximum height of the tree will be the size of the cows list. I used a Heuristic to 
	 * check if the cow still fits on the farm. I also created a method that will be used called getMinimumLitters to check if the solution of that branch of the tree reaches the 
	 * total amount of litters demanded. I also use a method call isBetter to check if the new solution is the best one we found to the moment. 
	 *
	 **********************************************************************************************************************************************************************************/	
	
	public static void case1Backtracking(LinkedList<Cow> cows, int metters, double litters, int puntero, int[] solucion_index, int[] better_sol, int[] num, int[] primera_solucion) {

		if (cows.size() == puntero)
		{	
			if (getMinimumLitters(cows, solucion_index, litters)) {
				num[0]++;
				// Primera solucion
				if (!IntStream.of(primera_solucion).anyMatch(x -> x == 1)){
					System.arraycopy(solucion_index, 0, primera_solucion, 0, solucion_index.length);
				}
				
				if(isBetter(cows, solucion_index, better_sol))  System.arraycopy(solucion_index, 0, better_sol, 0, solucion_index.length);
	
			}
		}
		else {
			// 0 == la vaca no pertenece a la solucion
			Cow current_vaca = cows.get(puntero);
			
			if(getHeuristic(current_vaca, metters, litters)) {
				// vaca solucion
				solucion_index[puntero] = 1;
				case1Backtracking(cows, metters-current_vaca.getNeccesarySpace(), litters, puntero+1, solucion_index, better_sol, num, primera_solucion);
			}
			solucion_index[puntero] = 0;
			case1Backtracking(cows, metters, litters, puntero+1, solucion_index, better_sol, num, primera_solucion);
		}
	}

	/**********************************************************************************************************************************************************************************
	 * Method name: getMinimunLitters
	 * 
	 * Description of the method: This method will check if the solution reached in a branch of the tree fits the litters of milk goal.
	 *
	 **********************************************************************************************************************************************************************************/	
	
	public static boolean getMinimumLitters(LinkedList<Cow> cows, int[] solucion_index, double litters) {
		double solution_litters = 0.0;

		for (int i=0; i<solucion_index.length ; i++) {
			if(solucion_index[i] == 1){
				solution_litters += cows.get(i).getMilkProduced();
			}	
		}	

		return (solution_litters>=litters)? true:false;
	}
	
	/**********************************************************************************************************************************************************************************
	 * Method name: getHeuristic
	 * 
	 * Description of the method: This method has the heuristic for checking if the actual cow we are checking on the backtracking fits in the space that we have left in each "iteration"
	 * of the tree.
	 *
	 **********************************************************************************************************************************************************************************/	
	
	public static boolean getHeuristic(Cow vaca,int metters, double litters) {
		if(metters-vaca.getNeccesarySpace() >= 0) {
			return true;
		}else {
			return false;
		}
	}

	/**********************************************************************************************************************************************************************************
	 * Method name: isBetter
	 * 
	 * Description of the method: This method checks if the new solution is the best solution reached to the moment. If it is the best solution, we will store it.
	 *
	 **********************************************************************************************************************************************************************************/	
	
	public static boolean isBetter(LinkedList<Cow> cows, int[] possible, int[] better) {
		int litters_current_better = 0;
		int litters_possible_better = 0;
		
		for (int i=0; i<possible.length ; i++) {
			if(possible[i] == 1){
				litters_possible_better += cows.get(i).getMilkProduced();
			}	
			if(better[i] == 1){
				litters_current_better += cows.get(i).getMilkProduced();
			}
		}
		return (litters_current_better>litters_possible_better)? false:true;
	}
}
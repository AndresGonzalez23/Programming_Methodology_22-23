package Task2;

import java.io.*;
import java.util.*;

public class readFile {
	
	/**********************************************************************************************************************************************************************************
	* Class name: Main 
	* 
	* Class description: Class that we use to read the .csv file with the method down below
	**********************************************************************************************************************************************************************************/
	
	public static LinkedList<Car> readCSV(String route, String separador) {
		
		/**********************************************************************************************************************************************************************************
		 * Method name: readCSV
		 * 
		 * Description of the method: This method is used to read all the data from the given .csv file and storing each car element in a Linked List
		 *
		 **********************************************************************************************************************************************************************************/	
		
		LinkedList<Car> cars = new LinkedList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(route + "cars_dataset.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(separador);
                Car car = new Car(datos[0], datos[1], Double.parseDouble(datos[2]), datos[3], Double.parseDouble(datos[4]), Double.parseDouble(datos[5]));
                cars.add(car);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return cars;
    }
}
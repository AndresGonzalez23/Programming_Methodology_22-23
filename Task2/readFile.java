package Task2;

import java.io.*;
import java.util.*;

public class readFile {
	
	public static LinkedList<Car> readCSV(String route, String separador) {
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
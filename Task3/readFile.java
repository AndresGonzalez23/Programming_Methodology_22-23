package Task3;
import java.io.*;
import java.util.*;

public class readFile {
	
	/**********************************************************************************************************************************************************************************
	* Class name: readFile 
	* 
	* Class description: Class that we use to read the .csv file with the method down below
	**********************************************************************************************************************************************************************************/
	
	
	/**********************************************************************************************************************************************************************************
	 * Method name: readCSV
	 * 
	 * Description of the method: This method is used to read all the data from the given .csv file and storing each car element in a Linked List
	 *
	 **********************************************************************************************************************************************************************************/	
	public static LinkedList<Cow> readCSV(String route, String separador) {
		
		LinkedList<Cow> cows = new LinkedList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(route + "CowsInformation.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(separador);
                Cow cow = new Cow(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]), Double.parseDouble(datos[2]), Double.parseDouble(datos[3]));
                cows.add(cow);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return cows;
    }
}
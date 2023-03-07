package Task2;

import java.io.*;

public class readFile {
	
	public static void readCSV(String route, String separador) {
        try (BufferedReader br = new BufferedReader(new FileReader(route + "cars_dataset.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(separador);
                // aquí puedes hacer lo que quieras con los datos de cada fila
                // por ejemplo, imprimirlos en la consola
                for (String dato : datos) {
                    System.out.print(dato + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

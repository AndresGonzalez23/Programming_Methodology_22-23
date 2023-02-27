package Task1;

import java.io.*;
import java.util.*;

public class Main {

	private static final String COMMA_DELIMITER = ";";
	private static final String NEW_LINE_SEPARATOR = "\n";
	private static FileWriter csvWriter;
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
	String route = "C:/Users/Andres/eclipse-workspace/Programming Methodology 22-23/src/Imagenes/";
	File csvFile = new File(route + "result.csv");
	String []listImages = {"320x214", "640x360", "640x427", "1024x1024", "1536x1536"};
	String[] headers = {"","Greyscale Conversion", "Generate Histogram", "Bubble Conversion", "Quicksort Conversion"};
	String[] elections;
	long initTime;
	long endTime;
	csvWriter = new FileWriter(csvFile);
	
	elections = chooseMilliorNano();
	
	writeCSV(headers, csvFile);
	
		for (int i = 0; i<listImages.length; i++) {
			String input = route + listImages[i];
			
			System.out.println("--- Procesing image " + listImages[i] + " ---");
			initTime=System.currentTimeMillis()*Long.parseLong(elections[1]);
			Auxiliar.GenerarImagenGrises(input + ".png", input + "_g.png");
			endTime=System.currentTimeMillis()*Long.parseLong(elections[1]);
			String differenceGrey = Long.toString(endTime - initTime);
			System.out.println("Greyscale image generated");
			
			initTime=System.currentTimeMillis()*Long.parseLong(elections[1]);
			int []histogram = Auxiliar.HistogramaImagen(input + "_g.png");
			endTime=System.currentTimeMillis()*Long.parseLong(elections[1]);
			String differenceHist = Long.toString(endTime - initTime);
			System.out.println("Histogram generated");
			
			initTime=System.currentTimeMillis()*Long.parseLong(elections[1]);
			Auxiliar.ImprimeHistograma(histogram);
			endTime=System.currentTimeMillis()*Long.parseLong(elections[1]);
			
			initTime=System.currentTimeMillis()*Long.parseLong(elections[1]);
			Auxiliar.GenerarImagenOrdenandoColumnas(input + ".png", input + "_b.png", 0);
			endTime=System.currentTimeMillis()*Long.parseLong(elections[1]);
			String differenceBubble = Long.toString(endTime - initTime);
			System.out.println("Columns ordered with bubble");
			
			initTime=System.currentTimeMillis()*Long.parseLong(elections[1]);
			Auxiliar.GenerarImagenOrdenandoColumnas(input + ".png", input + "_q.png", 1);
			endTime=System.currentTimeMillis()*Long.parseLong(elections[1]);
			String differenceQuick = Long.toString(endTime - initTime);
			System.out.println("Columns ordered with quicksort \n");
			
			String[] data = {listImages[i], differenceGrey + elections[0] , differenceHist + elections[0], differenceBubble + elections[0], differenceQuick + elections[0]};
			
			for(int j = 0; j < data.length; j++) {
				csvWriter.append(data[j]);
				if(j != data.length - 1) {
					csvWriter.append(COMMA_DELIMITER);	
				}
			}
			csvWriter.append(NEW_LINE_SEPARATOR);
			
		}
		csvWriter.close();
	}
	
	public static void writeCSV(String[] data, File csvFile) throws IOException {
		csvWriter = new FileWriter(csvFile);
		
		for(int i = 0; i < data.length; i++) {
			csvWriter.append(data[i]);
			if(i != data.length - 1) {
				csvWriter.append(COMMA_DELIMITER);	
			}
		}
		csvWriter.append(NEW_LINE_SEPARATOR);
	}
	
	public static String[] chooseMilliorNano() {
		String[] elections = {"",""};
		int option;
			System.out.println("Choose if you want to calculate the times in milliseconds of nanoseconds \n 1. Calculate in milliseconds"
					+ "\n 2. Calculate in nanoseconds\n");
			while (true) {
	            System.out.println("Ingresa una opción (1 o 2): ");
	            String entrada = scan.nextLine();

	            if (entrada.equals("1")) {
	                option = 1;
	                break;
	            } else if (entrada.equals("2")) {
	                option = 2;
	                break;
	            } else {
	                System.out.println("Entrada inválida. Solo se aceptan 1 o 2 como entrada.");
	            }
	        }
			switch(option) {
            case 1:
                elections[0] = "ms";
                elections[1] = "1";
                break;
            case 2:     
                elections[0] = "ns";
                elections[1] = "1000000";
                break;
			}
		scan.close();
		return elections;
	}
}
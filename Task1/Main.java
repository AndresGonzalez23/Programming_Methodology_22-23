package Task1;

import java.io.*;

public class Main {

	private static final String COMMA_DELIMITER = ";";
	private static final String NEW_LINE_SEPARATOR = "\n";
	private static FileWriter csvWriter;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
	String route = "C:/Users/Andres/eclipse-workspace/Programming Methodology 22-23/src/Imagenes/";
	File csvFile = new File(route + "result.csv");
	String []listImages = {"320x214", "640x360", "640x427", "1024x1024", "1536x1536"};
	String[] headers = {"","Greyscale Conversion", "Generate Histogram", "Bubble Conversion", "Quicksort Conversion"};
	long initTime;
	long endTime;
	csvWriter = new FileWriter(csvFile);
	
	writeCSV(headers, csvFile);
	
		for (int i = 0; i<listImages.length; i++) {
			String input = route + listImages[i];
			
			System.out.println("--- Procesing image " + listImages[i] + " ---");
			initTime=System.currentTimeMillis();
			Auxiliar.GenerarImagenGrises(input + ".png", input + "_g.png");
			endTime=System.currentTimeMillis();
			String differenceGrey = Long.toString(endTime - initTime);
			System.out.println("Greyscale image generated");
			
			initTime=System.currentTimeMillis();
			int []histogram = Auxiliar.HistogramaImagen(input + "_g.png");
			endTime=System.currentTimeMillis();
			String differenceHist = Long.toString(endTime - initTime);
			System.out.println("Histogram generated");
			
			initTime=System.currentTimeMillis();
			Auxiliar.ImprimeHistograma(histogram);
			endTime=System.currentTimeMillis();
			
			initTime=System.currentTimeMillis();
			Auxiliar.GenerarImagenOrdenandoColumnas(input + ".png", input + "_b.png", 0);
			endTime=System.currentTimeMillis();
			String differenceBubble = Long.toString(endTime - initTime);
			System.out.println("Columns ordered with bubble");
			
			initTime=System.currentTimeMillis();
			Auxiliar.GenerarImagenOrdenandoColumnas(input + ".png", input + "_q.png", 1);
			endTime=System.currentTimeMillis();
			String differenceQuick = Long.toString(endTime - initTime);
			System.out.println("Columns ordered with quicksort \n");
			
			String[] data = {listImages[i], differenceGrey + " ms" , differenceHist + " ms", differenceBubble + " ms", differenceQuick + " ms"};
			
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
	
	public static void writeNewLineCSV(String[] data, File csvFile) throws IOException{
		csvWriter = new FileWriter(csvFile);
		csvWriter.append(NEW_LINE_SEPARATOR);
		
		for(int i = 0; i < data.length; i++) {
			csvWriter.append(data[i]);
			if(i != data.length - 1) {
				csvWriter.append(COMMA_DELIMITER);	
			}
		}
		csvWriter.close();
	}
}
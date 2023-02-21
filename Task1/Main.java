package Task1;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		
	String route = "C:/Users/Andrés/eclipse-workspace/Programming Methodology 22-23/src/Imagenes/";
	String []listImages = {"320x214", "640x360", "640x427", "1024x1024", "1536x1536"};
	long initTime;
	long endTime;
	long difference;
	
		for (int i = 0; i<listImages.length; i++) {
			String input = route + listImages[i];
		
			initTime=System.currentTimeMillis();
			Auxiliar.GenerarImagenGrises(input + ".png", input + "_g.png");
			endTime=System.currentTimeMillis();
			System.out.println("Miliseconds generating greyscale of " + listImages[i] + " = " + (difference=endTime-initTime));
			initTime=System.currentTimeMillis();
			int []histogram = Auxiliar.HistogramaImagen(input + "_g.png");
			endTime=System.currentTimeMillis();
			//initTime=System.currentTimeMillis();
			//Auxiliar.ImprimeHistograma(histogram);
			//endTime=System.currentTimeMillis();
			initTime=System.currentTimeMillis();
			Auxiliar.GenerarImagenOrdenandoColumnas(input + ".png", input + "_b.png", 0);
			endTime=System.currentTimeMillis();
			initTime=System.currentTimeMillis();
			Auxiliar.GenerarImagenOrdenandoColumnas(input + ".png", input + "_q.png", 1);
			endTime=System.currentTimeMillis();
			
		}
	
	}
	
	public static void transformRelative(String[] listImages, String route) throws IOException, InterruptedException {
		String input;
		String output;
		int [] histogram;
		for (int i = 0; i<listImages.length; i++) {
			input = route + listImages[i] + ".png";
			output = route + listImages[i] + "_g.png";
			Auxiliar.GenerarImagenGrises(input,output);
			histogram = Auxiliar.HistogramaImagen(input + "_g.png");
			Auxiliar.ImprimeHistograma(histogram);
		}
		
	}
}

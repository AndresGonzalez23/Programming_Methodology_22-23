package Task1;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		
	String []listImages = {"../Programming Methodology 22-23/src/Task1/Imagenes/320x214.png", "../Programming Methodology 22-23/src/Task1/Imagenes/640x360.png", 
			"../Programming Methodology 22-23/src/Task1/Imagenes/640x427.png", "../Programming Methodology 22-23/src/Task1/Imagenes/1024x1024.png", 
			"../Programming Methodology 22-23/src/Task1/Imagenes/1536x1536.png"};
	
	String[] listTransformed = transformRelative(listImages);
	histogram(listTransformed);
	ordenarColumnas(listImages);
	}
	
	public static String[] transformRelative(String[] listImages) throws IOException, InterruptedException {
		String []listTransformed = {"../Programming Methodology 22-23/src/Task1/Imagenes/320x214_g.png", "../Programming Methodology 22-23/src/Task1/Imagenes/640x360_g.png", 
				"../Programming Methodology 22-23/src/Task1/Imagenes/640x427_g.png", "../Programming Methodology 22-23/src/Task1/Imagenes/1024x1024_g.png", 
				"../Programming Methodology 22-23/src/Task1/Imagenes/1536x1536_g.png"};
		for (int i = 0; i<listImages.length; i++) {
			File file = new File(listImages[i]);
			File fileT = new File(listTransformed[i]);	
			Auxiliar.GenerarImagenGrises(file.getPath(), fileT.getPath());
		}
		return listTransformed;
	}
	
	public static void histogram (String[] images) throws IOException, InterruptedException {
		for(int i = 0; i < images.length; i++) {
			int [] histogram = Auxiliar.HistogramaImagen(images[i]);
			Auxiliar.ImprimeHistograma(histogram);
		}
	}
	
	public static void ordenarColumnas(String[] images) throws IOException, InterruptedException {
		String []listBubble = {"../Programming Methodology 22-23/src/Task1/Imagenes/320x214_b.png", "../Programming Methodology 22-23/src/Task1/Imagenes/640x360_b.png", 
				"../Programming Methodology 22-23/src/Task1/Imagenes/640x427_b.png", "../Programming Methodology 22-23/src/Task1/Imagenes/1024x1024_b.png", 
				"../Programming Methodology 22-23/src/Task1/Imagenes/1536x1536_b.png"};
		String []listQuick = {"../Programming Methodology 22-23/src/Task1/Imagenes/320x214_q.png", "../Programming Methodology 22-23/src/Task1/Imagenes/640x360_q.png", 
				"../Programming Methodology 22-23/src/Task1/Imagenes/640x427_q.png", "../Programming Methodology 22-23/src/Task1/Imagenes/1024x1024_q.png", 
				"../Programming Methodology 22-23/src/Task1/Imagenes/1536x1536_q.png"};
		
		for(int i = 0; i < images.length; i++) {
			Auxiliar.GenerarImagenOrdenandoColumnas(images[i], listBubble[i], 0);
			Auxiliar.GenerarImagenOrdenandoColumnas(images[i], listQuick[i], 1);
		}
	}
}

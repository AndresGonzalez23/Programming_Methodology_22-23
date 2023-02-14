package Task1;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		
	String images = "C://Users//Andrés//eclipse-workspace//Programming Methodology 22-23//src//Task1//Imagenes//320X214.png";
	String imagesB = "C://Users//Andrés//eclipse-workspace//Programming Methodology 22-23//src//Task1//Imagenes//320X214_b.png";
	String imagesQ = "C://Users//Andrés//eclipse-workspace//Programming Methodology 22-23//src//Task1//Imagenes//320X214_q.png";
	String imageOut;
	imageOut=transform(images);
	int [] histogram = Auxiliar.HistogramaImagen(imageOut);
	Auxiliar.ImprimeHistograma(histogram);
	Auxiliar.GenerarImagenOrdenandoColumnas(images, imagesB, 0);
	Auxiliar.GenerarImagenOrdenandoColumnas(images, imagesQ, 1);
	
	}

	public static String transform(String image) throws IOException, InterruptedException {
		String imageOut = "C://Users//Andrés//eclipse-workspace//Programming Methodology 22-23//src//Task1//Imagenes//320X214_g.png";
		Auxiliar.GenerarImagenGrises(image, imageOut);
		return imageOut;
	}
}

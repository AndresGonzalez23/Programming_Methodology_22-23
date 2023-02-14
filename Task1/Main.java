package Task1;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		
	String images = "C://Users//Andrés//OneDrive - Universidad de Castilla-La Mancha//Escritorio//Universidad//2022-2023//Segundo Cuatrimestre//Programming Methodology//Lab//Task 1//Imagenes//320x214.png";
	String imagesB = "C://Users//Andrés//OneDrive - Universidad de Castilla-La Mancha//Escritorio//Universidad//2022-2023//Segundo Cuatrimestre//Programming Methodology//Lab//Task 1//Imagenes//320x214_b.png";
	String imagesQ = "C://Users//Andrés//OneDrive - Universidad de Castilla-La Mancha//Escritorio//Universidad//2022-2023//Segundo Cuatrimestre//Programming Methodology//Lab//Task 1//Imagenes//320x214_q.png";
	String imageOut;
	imageOut=transform(images);
	int [] histogram = Auxiliar.HistogramaImagen(imageOut);
	Auxiliar.ImprimeHistograma(histogram);
	Auxiliar.GenerarImagenOrdenandoColumnas(images, imagesB, 0);
	Auxiliar.GenerarImagenOrdenandoColumnas(images, imagesQ, 1);
	
	}

	public static String transform(String image) throws IOException, InterruptedException {
		String imageOut = "C://Users//Andrés//OneDrive - Universidad de Castilla-La Mancha//Escritorio//Universidad//2022-2023//Segundo Cuatrimestre//Programming Methodology//Lab//Task 1//Imagenes//320x214_g.png";
		Auxiliar.GenerarImagenGrises(image, imageOut);
		return imageOut;
	}
}

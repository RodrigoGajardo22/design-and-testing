package implementaciones;

import java.io.File;
import java.io.FileWriter;

import ejercicio1.Registrar;

public class RegistrarVentaEnArchivo implements Registrar {

	private String ruta;

	public RegistrarVentaEnArchivo(String ruta) {
		this.ruta = ruta;
	}

	@Override
	public void registrar(String dato) {

		try {

			File       archivo  = new File(ruta);
			FileWriter escribir = new FileWriter(archivo, true);

			escribir.write(dato);
			escribir.write("\r\n");
			escribir.close();
		} // Si existe un problema al escribir cae aqui
		catch (Exception e) {
			System.out.println("Error al escribir");
		}

	}

}

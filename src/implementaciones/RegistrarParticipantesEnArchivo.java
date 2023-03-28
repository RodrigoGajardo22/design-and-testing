package implementaciones;

import java.io.File;
import java.io.FileWriter;

import ejercicio1.Registrar;

public class RegistrarParticipantesEnArchivo implements Registrar {

	private String ruta;

	public RegistrarParticipantesEnArchivo(String ruta) {

		this.ruta = ruta;

	}

	public void registrar(String dato) {

		try {

			File       archivo  = new File(ruta);
			FileWriter escribir = new FileWriter(archivo, true);

			escribir.write(dato);
			escribir.write("\r\n");
			escribir.close();
		} // Si existe un problema al escribir cae aqui
		catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}

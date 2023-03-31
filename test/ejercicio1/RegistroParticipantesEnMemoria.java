package ejercicio1;

public class RegistroParticipantesEnMemoria implements Registrar {

	private String datos;

	public void registrar(String datos) {

		this.datos = datos;
	}

	boolean correcto(String datosRecibidos) {

		return this.datos.equals(datosRecibidos);
	}

}

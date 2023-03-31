package implementaciones;

import ejercicio1.Notificacion;

public class CorreoFake implements Notificacion {

	@Override
	public boolean enviar(String destino, String fuente, String mensaje) {

		return "Inscripcion realizada con exito." == mensaje;

	}

}

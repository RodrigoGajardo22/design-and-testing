package implementaciones;

import ejercicio1.Notificacion;
import emails.Email;

public class CorreoElectronico implements Notificacion {

	private Email email;

	public CorreoElectronico(Email email) {

		this.email = email;

	}

	public boolean enviar(String destino, String fuente, String mensaje) {

		return email.enviarCorreo(destino, fuente, mensaje);

	}

}

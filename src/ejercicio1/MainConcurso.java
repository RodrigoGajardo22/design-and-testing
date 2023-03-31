package ejercicio1;

import java.time.LocalDate;

import emails.Email;
import implementaciones.CorreoElectronico;
import implementaciones.RegistrarParticipantesEnArchivo;

public class MainConcurso {

	public static void main(String[] args) {

		Registrar    registro = new RegistrarParticipantesEnArchivo(
				"C:\\Users\\Usuario\\Documents\\2 - UNIVERSIDAD RODRI\\Orientacion a Objetos 2\\Registro De Participantes.txt");

		Participante p1       = new Participante("Juan Fuentes", 38635211, "juanFuentes@gail.com");
		Participante p2       = new Participante("Florencia Techeira", 40635211, "florenciaTecheira@gmail.com");
		Participante p3       = new Participante("Rodrigo Gajardo", 26987123, "rodrigoGajardo@gmail.com");
		Participante p4       = new Participante("Marta fuentes", 31123765, "martaFuentes@gmail.com");
		Participante p5       = new Participante("Ezequiel Perez", 15386983, "ezequielPerez@gmail.com");

		Notificacion correo   = new CorreoElectronico(new Email());

		Concurso     c1       = new Concurso(LocalDate.now().minusDays(3), LocalDate.now().plusDays(10), registro, 1,
				correo);
		Concurso     c2       = new Concurso(LocalDate.now().plusDays(3), LocalDate.now().plusDays(10), registro, 5,
				correo);

		c1.inscribirParticipante(p1);
		c1.inscribirParticipante(p2);
		c1.inscribirParticipante(p3);
		c1.inscribirParticipante(p4);
		c1.inscribirParticipante(p5);

		c2.inscribirParticipante(p1);

	}

}

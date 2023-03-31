package ejercicio1;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import implementaciones.CorreoFake;

class ConcursoTest {

	private Participante           p1           = new Participante("Juan Fuentes", 40635211, "juanFuentes@gmail.com"); // Puede
																														// inscrirbirse
	private Participante           p2           = new Participante("Alberto Garcia", 36849859,
			"albertoGarcia@gmail.com");                                                                                // Se
																														// iscrirbirse
																														// ysuma
	private Participante           p3           = new Participante("Cristina Entraigas", 17647852,
			"cristinaEntraigas@gmail.com");                                                                            // No
																														// puede

	RegistroParticipantesEnMemoria registro     = new RegistroParticipantesEnMemoria();
	Notificacion                   notificacion = new CorreoFake();

	@Test
	public void testInscripcion() { // concurso abierto hace 3 dias y finaliza en 10

		Concurso c1                  = new Concurso(LocalDate.now().minusDays(3), LocalDate.now().plusDays(10),
				registro, 3, notificacion);

		boolean  notificacionEnviada = notificacion.enviar("juanFuentes@gmail.com", "miCorreo@gmail.com",
				"Inscripcion realizada con exito.");

		assertTrue(c1.inscribirParticipante(p1));
		assertTrue(notificacionEnviada);
		assertTrue(registro.correcto("" + LocalDate.now() + "|" + 1 + "|" + 3));

	}

	@Test
	public void testInscripcionHoy() {// Concurso abrió hoy

		Concurso c                   = new Concurso(LocalDate.now(), LocalDate.now().plusDays(7), registro, 4,
				notificacion);

		boolean  notificacionEnviada = notificacion.enviar("albertoGarcia@gmail.com", "miCorreo@gmail.com",
				"Inscripcion realizada con exito.");

		assertTrue(c.inscribirParticipante(p2));
		assertTrue(notificacionEnviada);
	}

	@Test
	public void testInscripcionFueraTermino() { // No puede inscribirse

		Concurso c                   = new Concurso(LocalDate.now().plusDays(2), LocalDate.now().plusDays(12), registro,
				5, notificacion);

		boolean  notificacionEnviada = notificacion.enviar("juanFuentes@gmail.com", "miCorreo@gmail.com", null);

		assertTrue(!c.inscribirParticipante(p3));
		assertTrue(!notificacionEnviada);
	}

	@Test
	public void testPuntos() { // verifica si suma puntos o no.

		Participante p4 = new Participante("Juan", 40635211, "juan@gmail.com");
		Participante p5 = new Participante("Pablo", 40635211, "pablo@gmail.com");

		Concurso     c4 = new Concurso(LocalDate.now(), LocalDate.now().plusDays(7), registro, 6, notificacion); // abrio
																													// hoy
		Concurso     c5 = new Concurso(LocalDate.now().plusDays(2), LocalDate.now().plusDays(12), registro, 7,
				notificacion);                                                                                   // todavia
																													// no

		c4.inscribirParticipante(p4);
		c5.inscribirParticipante(p5);

		assertEquals(10, p4.puntos()); // SUMA

		assertEquals(0, p5.puntos()); // NO SUMA

	}

}

package ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {

	private List<Participante> listParticipantes;
	private LocalDate          fechaInicio, fechaFin;
	private Registrar          planillaDeRegistro;
	private int                ID_Concurso;
	private Notificacion       notificacion;

	public Concurso(LocalDate fechaIni, LocalDate fechaFin, Registrar planilla, int idConcurso,
			Notificacion notificacion) {
		this.fechaInicio        = fechaIni;
		this.fechaFin           = fechaFin;
		this.listParticipantes  = new ArrayList<Participante>();
		this.planillaDeRegistro = planilla;
		this.ID_Concurso        = idConcurso;
		this.notificacion       = notificacion;
	}

	public boolean inscribirParticipante(Participante p) {

		if (puedeInscribirse()) {
			verificarFechaYsumarPuntos(p);
			listParticipantes.add(p);
			planillaDeRegistro.registrar(" " + LocalDate.now() + " - idParticipante: " + listParticipantes.size()
					+ " -  idConcurso: " + ID_Concurso);
			notificacion.enviar(p.email(), "concursos@gmail.com", "Inscripcion realizada con exito.");
			return true;
		}
		return false;

	}

	private void verificarFechaYsumarPuntos(Participante p) {

		LocalDate fechaDeHoy = LocalDate.now();

		if (fechaInicio.equals(fechaDeHoy)) {
			p.sumarPuntos();
		}
	}

	private boolean puedeInscribirse() {// si la fecha es valida, entonces True;

		LocalDate fechaHoy = LocalDate.now();

		if (fechaHoy.equals(fechaInicio))
			return true;
		if (fechaHoy.isAfter(fechaInicio) && fechaHoy.isBefore(fechaFin))
			return true;

		return false;
	}

	public void mostrarParticipantes() {

		int i = 1;
		if (listParticipantes.size() > 0)
			for (Participante p : listParticipantes) {
				System.out.println(i + " - " + p.mostrarDatos());
				i++;
			}
	}

}

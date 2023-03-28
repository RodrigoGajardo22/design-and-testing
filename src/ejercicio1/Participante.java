package ejercicio1;

public class Participante {

	private int    puntos;
	private String nombreYApellido;
	private int    dni;

	// Atributo Concurso (id)
	public Participante(String nombreYApellido, int dni) {

		this.nombreYApellido = nombreYApellido; // Separar
		this.dni             = dni;
		puntos               = 0;
	}

	public int puntos() {
		return puntos;
	}

	public void sumarPuntos() {
		puntos = +10;
	}

	public String mostrarDatos() {
		if (nombreYApellido != null)
			return "Nombre y Apellido: " + nombreYApellido + " DNI: " + dni + " Puntos: " + puntos;
		else
			return "No se encontraron datos.";
	}

	// Agregar Gets
	public String nombreYApellido() {

		return nombreYApellido;
	}
}

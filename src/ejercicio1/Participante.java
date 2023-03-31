package ejercicio1;

public class Participante {

	private int    puntos;
	private String nombreYApellido;
	private int    dni;
	private String email;

	// Atributo Concurso (id)
	public Participante(String nombreYApellido, int dni, String email) {

		this.nombreYApellido = nombreYApellido; // Separar
		this.dni             = dni;
		this.puntos          = 0;
		this.email           = email;

	}

	public int puntos() {
		return puntos;
	}

	public String email() {
		return email;
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

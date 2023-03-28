package ejercicio2;

public class Plato {

	private String nombre;
	private float  valor;

	public Plato(String n, float v) {
		this.nombre = n;
		this.valor  = v;
	}

	public float costoTotal(int cantidadDePlatos) {
		return valor * cantidadDePlatos;
	}

	public String mostrarDatos() {
		return "Nombre: " + nombre + " Valor: $" + valor;
	}
}

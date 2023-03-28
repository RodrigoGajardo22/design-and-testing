package ejercicio2;

public class Bebida {
	private String nombre;
	private float  valor;

	public Bebida(String n, float v) {
		this.nombre = n;
		this.valor  = v;
	}

	public float costoTotal(int cantidadDeBebidas) {
		return valor * cantidadDeBebidas;
	}

	public String mostrarDatos() {
		return "Nombre: " + nombre + " Valor: $" + valor;
	}

}

package ejercicio2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ejercicio1.Registrar;

public class Dispositivo {

	private Tarjeta      tarjeta;
	private List<Bebida> listaBebidas;
	private List<Plato>  listaPlatos;
	private float        montoBebida, montoPlatos;
	private Registrar    registro;

	public Dispositivo(Tarjeta t, Registrar registro) {
		this.tarjeta  = t;
		montoBebida   = 0;
		montoPlatos   = 0;

		listaBebidas  = new ArrayList<>();
		listaPlatos   = new ArrayList<>();

		this.registro = registro;

	}

	public void seleccionarTarjeta(Tarjeta t) {
		this.tarjeta = t;
	}

	public void agregarBebida(Bebida b, int cantidad) {

		listaBebidas.add(b);
		montoBebida += b.costoTotal(cantidad); // --> montoBebida += cantidad * b.costo() ?? es como un get?

	}

	public void agregarPlato(Plato p, int cantidad) {

		listaPlatos.add(p);
		montoPlatos = montoPlatos + p.costoTotal(cantidad);

	}

	public float calculo() {

		float monto = tarjeta.calculo(montoBebida, montoPlatos);
		procesarPago(LocalDate.now(), monto);
		return monto;

	}

	private void procesarPago(LocalDate fecha, float monto) {

		registro.registrar(" " + fecha + " $" + monto);

	}

}

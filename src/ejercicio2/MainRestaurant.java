package ejercicio2;

import ejercicio1.Registrar;
import implementaciones.RegistrarVentaEnArchivo;

public class MainRestaurant {

	public static void main(String[] args) {
		Bebida      coca           = new Bebida("Coca", 200);
		Bebida      fanta          = new Bebida("Fanta", 150);
		Bebida      sprite         = new Bebida("Sprite", 150);

		Plato       milanesas      = new Plato("Milanesas con papas", 500);
		Plato       pollo          = new Plato("Pollo a la parrilla", 600);
		Plato       empanadas      = new Plato("Empanadas", 500);

		Registrar   registroPedido = new RegistrarVentaEnArchivo(
				"C:\\Users\\Usuario\\Documents\\2 - UNIVERSIDAD RODRI\\Orientacion a Objetos 2\\Registro De Ventas.txt");

		Tarjeta     visa           = new Visa(5);
		Dispositivo dispositivo    = new Dispositivo(visa, registroPedido);

		dispositivo.agregarBebida(coca, 2);
		dispositivo.agregarPlato(milanesas, 1);
		dispositivo.agregarPlato(pollo, 1);

		dispositivo.calculo();

	}

}

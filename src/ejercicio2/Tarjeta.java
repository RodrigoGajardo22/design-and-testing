package ejercicio2;

public class Tarjeta {
//Atributos

	protected int propina;

	public Tarjeta(int propina) {

		this.propina = propina;
	}

	public float calculo(float montoBebidas, float montoPlatos) {

		float monto = montoBebidas + montoPlatos;
		return monto + monto * propina / 100;

	}
}

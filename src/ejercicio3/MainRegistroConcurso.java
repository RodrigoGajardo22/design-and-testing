package ejercicio3;

import java.time.LocalDate;
import java.util.Scanner;

import ejercicio1.Concurso;
import ejercicio1.Participante;
import ejercicio1.Registrar;
import implementaciones.RegistrarParticipanteEnBD;

public class MainRegistroConcurso {

	public static void main(String[] args) {
		System.out.println("\n");
		System.out.println(" Menú concurso X: ");
		System.out.println("\n");

		Registrar registro = new RegistrarParticipanteEnBD();
		Concurso  concurso = new Concurso(LocalDate.now(), LocalDate.now().plusDays(10), registro, 1);

		Scanner   leer;
		String    datos;
		int       dni;
		int       opcion   = 1;

		while (opcion != 0) {
			leer = new Scanner(System.in);
			System.out.println("Ingrese nombre y apellido: ");
			datos = leer.nextLine();
			System.out.println("DNI: ");
			dni = leer.nextInt();
			System.out.println("\n");
			Participante participante = new Participante(datos, dni);
			concurso.inscribirParticipante(participante);
			System.out.println("\n");
			System.out.println("Registro completo.");
			System.out.println("\n");

			System.out.println("¿Nuevo participante?");
			System.out.println("\n Precion un numero o 0 para finalizar: ");
			opcion = leer.nextInt();

		}

		System.out.println("Sistema finalizado");

	}

}

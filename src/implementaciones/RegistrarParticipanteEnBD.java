package implementaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ejercicio1.Registrar;

public class RegistrarParticipanteEnBD implements Registrar {

	private static String       DRIVER = "com.mysql.jdbc.Driver";
	private static String       URL_DB = "jdbc:mysql://localhost:3306/";
	protected static String     DB     = "participantes2";              // nombre de mi BD
	protected static String     user   = "root";
	protected static String     pass   = "";
	protected static Connection conn   = null;

//-----------------------------------------------------------------------
	private void connect() {
		try {
			conn = DriverManager.getConnection(URL_DB + DB + "?useSSL=false", user, pass);
		} catch (SQLException sqlEx) {
			System.out.println("No se ha podido conectar a " + URL_DB + DB + ". " + sqlEx.getMessage());
			System.out.println("Error al cargar el driver");
		}
	}

	private void disconnect() {
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

//----------------------------------------------------------------------- 
	@Override
	public void registrar(String datos) { // recibiría una persona para los gets

		this.connect();

		try {
			PreparedStatement statement = conn // "INSERT INTO participante(Nombre,id_part,DNI,Puntos)--> van los campos
												// de la tabla
					.prepareStatement("INSERT INTO participante(informacion) " + "VALUES (?)");
			statement.setString(1, datos); // campos
			// statement.setString(2, datos);
			// statement.setString(3, datos);
			// statement.setString(4, datos);
			// System.out.println("Se conecto");
			statement.executeUpdate(); //

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.disconnect();
		}

	}
}
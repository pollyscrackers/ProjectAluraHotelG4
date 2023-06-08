package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.modelo.Huespedes;

public class HuespedesDao {

	private Connection con;

	public HuespedesDao(Connection con) {
		this.con = con;
	}

	public void guardar(Huespedes nuevoHuespedes) {

		try {
			String sql = "INSERT INTO huespedes (NOMBRE, APELLIDO, FECHA_NACIMIENTO, NACIONALIDAD, TELEFONO, ID_RESERVA)"
					+ "VALUES (?,?,?,?,?,?)";

			final PreparedStatement statement = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
			try (statement) {
				statement.setString(1, nuevoHuespedes.getNombre());
				statement.setString(2, nuevoHuespedes.getApellido());
				statement.setDate(3, nuevoHuespedes.getFecha_nacimiento());
				statement.setString(4, nuevoHuespedes.getNacionalidad());
				statement.setString(5, nuevoHuespedes.getTelefono());
				statement.setInt(6, nuevoHuespedes.getId_reserva());

				statement.executeUpdate();

				final ResultSet resultset = statement.getGeneratedKeys();

				try (resultset) {
					while (resultset.next()) {
						nuevoHuespedes.setId(resultset.getInt(1));

						System.out.println(String.format("Fue guardada la reserva: %s", nuevoHuespedes));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Huespedes> listar() {
		List<Huespedes> huespedes = new ArrayList<Huespedes>();

		try {
			String sql = "SELECT id, nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva FROM HUESPEDES";

			System.out.println(sql);

			try (PreparedStatement statement = con.prepareStatement(sql)) {
				statement.execute();
				tranformarResultado(huespedes, statement);
			}
			return huespedes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Huespedes> buscarId(String id) {
		List<Huespedes> huespedes = new ArrayList<Huespedes>();

		try {
			String sql = "SELECT id, nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva FROM HUESPEDES WHERE id = ? OR apellido LIKE ?";

			System.out.println(sql);

			try (PreparedStatement statement = con.prepareStatement(sql)) {

				statement.setString(1, id);
				statement.setString(2, id);
				statement.execute();
				tranformarResultado(huespedes, statement);
			}
			return huespedes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void tranformarResultado(List<Huespedes> huespedes, PreparedStatement statement) throws SQLException {

		try (ResultSet resultSet = statement.getResultSet()) {

			while (resultSet.next()) {

				Huespedes nuevoHuesped = new Huespedes(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getDate(4), resultSet.getString(5), resultSet.getString(6),
						resultSet.getInt(7));
				huespedes.add(nuevoHuesped);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void Eliminar(Integer id) {

		try {
			String sql = "DELETE FROM huespedes WHERE id = ?";
			// try (statement) {
			java.sql.Statement state = con.createStatement();
			state.execute("SET FOREIGN_KEY_CHECKS=0");
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			statement.execute();
			state.execute("SET FOREIGN_KEY_CHECKS=1");
			System.out.println("entrando a la base huesped");

			// }
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}

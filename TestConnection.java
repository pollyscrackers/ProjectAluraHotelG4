package jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import jdbc.dao.ReservaDao;
import jdbc.modelo.Reserva;

public class TestConnection {

	final DataSource dataSource = null;

	public static void main(String[] args) throws SQLException {

		DataSource datasource;

		var pooledDataSource = new ComboPooledDataSource();
		pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel?useTimeZone=true&ServerTimeZone=UTC ");
		pooledDataSource.setUser("root");
		pooledDataSource.setPassword("guaricela123");
		pooledDataSource.setMaxPoolSize(10);

		datasource = (DataSource) pooledDataSource;

		System.out.println("Cerrando la conexion");
	}

	public Connection recuperaConexion() {
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}

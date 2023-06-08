package jdbc.controler;

import java.time.LocalDate;
import java.util.List;

import jdbc.dao.ReservaDao;
import jdbc.factory.ConnectionFactory;
import jdbc.modelo.Reserva;

public class ReservaControler {

	private ReservaDao reservaDao;

	public ReservaControler() {
		ConnectionFactory factory = new ConnectionFactory();
		this.reservaDao = new ReservaDao(factory.recuperaConexion());
	}

	public void guardar(Reserva nuevaReserva) {

		this.reservaDao.guardar(nuevaReserva);

	}

	public List<Reserva> listar() {
		return this.reservaDao.listar();
	}

	public List<Reserva> buscarId(String id) {

		return this.reservaDao.buscarId(id);
	}

	public void actualizarReserva(LocalDate fechaEntrada, LocalDate fechaSalida, String valor, String formaPago,
			Integer id) {
		this.reservaDao.Actualizar(fechaEntrada, fechaSalida, valor, formaPago, id);
	}

	public void Eliminar(Integer id) {
		this.reservaDao.Eliminar(id);
	}

}

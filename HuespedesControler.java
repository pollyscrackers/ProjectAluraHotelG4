package jdbc.controler;

import java.time.LocalDate;
import java.util.List;

import jdbc.dao.HuespedesDao;
import jdbc.factory.ConnectionFactory;
import jdbc.modelo.Huespedes;

public class HuespedesControler {

	private HuespedesDao huespedesDao;
	private Object reservaDao;

	public HuespedesControler() {
		ConnectionFactory factory = new ConnectionFactory();
		this.huespedesDao = new HuespedesDao(factory.recuperaConexion());
	}

	public void guardar(Huespedes nuevoHuesped) {

		this.huespedesDao.guardar(nuevoHuesped);

	}

	public void actualizarH(String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad,
			String telefono, Integer idReserva, Integer id) {
		// TODO Auto-generated method stub

	}

	public List<Huespedes> listar() {
		return this.huespedesDao.listar();
	}

	public List<Huespedes> buscarId(String id) {
		return this.huespedesDao.buscarId(id);
	}

	public void Eliminar(Integer id) {
		this.huespedesDao.Eliminar(id);
	}

	public Object getReservaDao() {
		return reservaDao;
	}

	public void setReservaDao(Object reservaDao) {
		this.reservaDao = reservaDao;
	}

}

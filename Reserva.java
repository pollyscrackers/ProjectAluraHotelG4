package jdbc.modelo;

import java.sql.Date;
import java.time.LocalDate;

public class Reserva {

	private Integer id;
	private Date fechaE;
	private Date fechaS;
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	private String valor;
	private String formaPago;

	public Reserva(Integer id, Date fechaE, Date fechaS, LocalDate fechaEntrada, LocalDate fechaSalida, String valor,
			String formaPago) {
		super();
		this.id = id;
		this.fechaE = fechaE;
		this.fechaS = fechaS;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
	}

	//public Reserva(int int1, Date date, Date date2, String string, String string2) {
		// TODO Auto-generated constructor stub
	//}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaE() {
		return fechaE;
	}

	public void setFechaE(Date fechaE) {
		this.fechaE = fechaE;
	}

	public Date getFechaS() {
		return fechaS;
	}

	public void setFechaS(Date fechaS) {
		this.fechaS = fechaS;
	}

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	
	@Override
	public String toString() {
		return String.format(
				"{id: %s, fecha entrada: %s, fecha salida: %s, valor: %s, forma de pago: %s}",
				this.id,
				this.fechaE,
				this.fechaS,
				this.valor,
				this.formaPago);
	}

}

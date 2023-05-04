package model;

import java.sql.Date;

public class Reservas {
	private int id;
	private Date fechaIn;
	private Date fechaOut;
	private double valor;
	private String formaPago;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaIn() {
		return fechaIn;
	}

	public void setFechaIn(Date fechaIn) {
		this.fechaIn = fechaIn;
	}

	public Date getFechaOut() {
		return fechaOut;
	}

	public void setFechaOut(Date fechaOut) {
		this.fechaOut = fechaOut;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	

	public Reservas(int id, Date fechaIn, Date fechaOut, double valor, String formaPago) {
		super();
		this.id = id;
		this.fechaIn = fechaIn;
		this.fechaOut = fechaOut;
		this.valor = valor;
		this.formaPago = formaPago;
	}

	public Reservas(Date fechaIn, Date fechaOut, double valor, String formaPago) {
		this.fechaIn = fechaIn;
		this.fechaOut = fechaOut;
		this.valor = valor;
		this.formaPago = formaPago;
	}

	public Reservas() {
		// TODO Auto-generated constructor stub
	}

}

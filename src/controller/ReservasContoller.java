package controller;

import java.sql.Date;
import java.util.List;

import dao.ReservasDao;
import factory.ConexionFactory;
import model.Reservas;

public class ReservasContoller {
	
	private ReservasDao reservasDao;	

	public ReservasContoller() {
		
		// TODO Auto-generated constructor stub
		ConexionFactory con = new ConexionFactory();
		this.reservasDao = new ReservasDao(con.getConnection());
	}



	public void guardar(Reservas reservas) {
		this.reservasDao.guardar(reservas);
	}
	
	public List<Reservas> listar(){
		return reservasDao.listar();
	}
	
	public int modificar(Integer id, Date fechaIn, Date fechaOut, Double valor, String formaPago) {
		return reservasDao.modificar(id, fechaIn, fechaOut, valor, formaPago);
		
	}
	public int eliminar(Integer id) {
		return reservasDao.eliminar(id);
	}
	
	public List<Reservas> buscar(Reservas reservas){
		return reservasDao.buscar(reservas);
	}
	
}

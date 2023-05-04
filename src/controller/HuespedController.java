package controller;

import java.sql.Date;
import java.util.List;

import dao.HuespedDao;
import factory.ConexionFactory;
import model.Huespedes;

public class HuespedController {

	private HuespedDao huespedesDao;

	public HuespedController() {
		// TODO Auto-generated constructor stub
		ConexionFactory con = new ConexionFactory();
		this.huespedesDao = new HuespedDao(con.getConnection());
	}

	public List<Huespedes> lista() {
		return huespedesDao.listar();

	}
	
	public void guardar(Huespedes huespedes) {
		huespedesDao.guardar(huespedes);
	}
	
	
	public List<Huespedes>buscar(Huespedes huespedes) {
		return huespedesDao.buscar(huespedes);
	}
	
	public  int modificar( Integer  id, String nombre, String apellido, Date fecha, String nacionalidad, String telefono  ) {
		return huespedesDao.modificar(id ,nombre, apellido, fecha, nacionalidad, telefono);
		
	}
	
	public int eliminar (Integer id) {
		return huespedesDao.eliminar(id);
	}

}

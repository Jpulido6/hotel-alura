package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Huespedes;

public class HuespedDao {

	private Connection con;
	

	public HuespedDao(Connection con) {
		this.con = con;
		// TODO Auto-generated constructor stub
	}

	public List<Huespedes> listar() {
		List<Huespedes> listaHuespedes = new ArrayList<>();

		try {
			final PreparedStatement ps;
			ps = con.prepareStatement("SELECT * FROM HUESPEDES");
			try (ps) {
				ps.execute();

				final ResultSet rs = ps.getResultSet();
				try (rs) {
					while (rs.next()) {
						listaHuespedes.add(new Huespedes(rs.getInt("id"), rs.getString("nombre"),
								rs.getString("apellido"), rs.getDate("fecha_nacimiento"), rs.getString("nacionalidad"),
								rs.getString("telefono"), rs.getInt("id_reserva")));
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}

		return listaHuespedes;
	}

	public void guardar(Huespedes huespedes) {

		try {
			PreparedStatement ps;
			ps = con.prepareStatement("INSERT INTO HUESPEDES (nombre, apellido, fecha_nacimiento,"
					+ "nacionalidad, telefono, id_reserva)" + "VALUES(?,?,?,?,?,?)");
			ps.setString(1, huespedes.getNombre());
			ps.setString(2, huespedes.getApellido());
			ps.setDate(3, huespedes.getFechaNacimiento());
			ps.setString(4, huespedes.getNacionalidad());
			ps.setString(5, huespedes.getTelefono());
			ps.setInt(6, huespedes.getIdReserva());

			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}

	}

	public List<Huespedes> buscar(Huespedes huespedes) {

		List<Huespedes> listarHuespedes = new ArrayList<>();

		try {
			final PreparedStatement ps;
			ps = con.prepareStatement("SELECT * FROM HUESPEDES WHERE apellido=?");
			ps.setString(1, huespedes.getApellido());

			try (ps) {

				ps.execute();

				final ResultSet rs = ps.getResultSet();

				try (rs) {

					while (rs.next()) {

						listarHuespedes.add(new Huespedes(rs.getInt("id"), rs.getString("nombre"),
								rs.getString("apellido"), rs.getDate("fecha_nacimiento"), rs.getString("nacionalidad"),
								rs.getString("telefono"), rs.getInt("id_reserva")));

					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception}
			
			throw new RuntimeException(e);

		}
		return listarHuespedes;
	}
	
	
	public int modificar( Integer id, String nombre, String apellido, Date fecha, String nacionalidad, String telefono  ) {
		try {
			final PreparedStatement ps= con.prepareStatement(
					"UPDATE HUESPEDES SET "
					+ "nombre=?,"
					+ "apellido=?,"
					+ "fecha_nacimiento=?,"
					+ "nacionalidad=?,"
					+ "telefono=?"
					+ "WHERE id=? ");
			
			try(ps){
			ps.setString(1, nombre);
			ps.setString(2, apellido);
			ps.setDate(3, fecha);
			ps.setString(4,nacionalidad);
			ps.setString(5, telefono);
			ps.setInt(6, id);
			
			ps.execute();
			int filasModificadas = ps.getUpdateCount();
			
			return filasModificadas;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public int eliminar(Integer id) {
		
		try {
			final PreparedStatement ps = con.prepareStatement("DELETE FROM HUESPEDES WHERE id=?");
			
			try(ps){
				ps.setInt(1, id);
				ps.execute();
				
				int updateCount = ps.getUpdateCount();
				
				return updateCount;
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
}

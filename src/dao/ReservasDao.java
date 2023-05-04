package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Huespedes;
import model.Reservas;

public class ReservasDao {

	private Connection con;

	public ReservasDao(Connection con) {
		// TODO Auto-generated constructor stub
		this.con = con;

	}

	public void guardar(Reservas reservas) {

		try {
			final PreparedStatement ps = con.prepareStatement(
					"INSERT INTO RESERVAS (fecha_in, fecha_out,valor,forma_pago)" + "VALUES(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			try (ps) {
				ps.setDate(1, reservas.getFechaIn());
				ps.setDate(2, reservas.getFechaOut());
				ps.setDouble(3, reservas.getValor());
				ps.setString(4, reservas.getFormaPago());

				ps.execute();

				final ResultSet rs = ps.getGeneratedKeys();
				try (rs) {
					while (rs.next()) {
						reservas.setId(rs.getInt(1));
					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}

	}

	public List<Reservas> listar() {
		List<Reservas> listaReservas = new ArrayList<>();

		try {
			final PreparedStatement ps;
			ps = con.prepareStatement("SELECT * FROM RESERVAS");

			try (ps) {
				ps.execute();

				final ResultSet rs = ps.getResultSet();
				try (rs) {
					while (rs.next()) {

						listaReservas.add(new Reservas(rs.getInt("id"), rs.getDate("fecha_in"), rs.getDate("fecha_out"),
								rs.getDouble("valor"), rs.getString("forma_pago")));
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		return listaReservas;
	}

	public int modificar(Integer id, Date fechaIn, Date fechaOut, Double valor, String formaPago) {
		try {
			final PreparedStatement ps = con.prepareStatement("UPDATE RESERVAS SET " + "fecha_in=?," + "fecha_out=?,"
					+ "valor=?," + "forma_pago=?" + "WHERE id=?");
			try (ps) {
				ps.setDate(1, fechaIn);
				ps.setDate(2, fechaOut);
				ps.setDouble(3, valor);
				ps.setString(4, formaPago);
				ps.setInt(5, id);

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
			final PreparedStatement ps = con.prepareStatement("DELETE FROM RESERVAS WHERE id=?");
			try (ps) {
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

	public List<Reservas> buscar(Reservas reservas) {

		List<Reservas> listarReservas = new ArrayList<Reservas>();

		try {
			final PreparedStatement ps;
			ps = con.prepareStatement("SELECT * FROM RESERVAS WHERE id=?");
			ps.setInt(1, reservas.getId());

			try (ps) {

				ps.execute();

				final ResultSet rs = ps.getResultSet();

				try (rs) {

					while (rs.next()) {

						Reservas reserva = new Reservas(rs.getInt("id"), rs.getDate("fecha_in"),
								rs.getDate("fecha_out"), rs.getDouble("valor"), rs.getString("forma_pago"));
						
						listarReservas.add(reserva);

					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception}
		
			throw new RuntimeException(e);

		}
		return listarReservas;
	}

}

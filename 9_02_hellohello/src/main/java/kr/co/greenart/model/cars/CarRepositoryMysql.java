package kr.co.greenart.model.cars;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class CarRepositoryMysql implements CarRepository {
	
	@Autowired
	private JdbcTemplate jdbc;
	private CarRowMapper mapper = new CarRowMapper();
	
	private class CarRowMapper implements RowMapper<Car> {

		@Override
		public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id = rs.getInt("id");
			String model = rs.getString("model");
			int price = rs.getInt("price");
			
			return new Car(id, model, price);
		}	
}
	
	@Override
	public List<Car> getAll() {
		return jdbc.query("select * from cars", mapper);
	}

	@Override
	public Car getById(int id) {
		String sql = "select * from cars where id ="+id;
		return jdbc.queryForObject(sql, mapper);
	}

	@Override
	public int add(Car car) {
		return jdbc.update("insert into cars(model, price) values(?, ?)",
				car.getModel(), 
				car.getPrice());
	}

	@Override
	public int update(Car car) {
		return jdbc.update("update cars set model = ?, price = ? where id = ?",
				car.getModel(),
				car.getPrice(),
				car.getId());
	}

	@Override
	public int delete(int id) {
		return jdbc.update("delete from cars where id = ?", id);
	}

	@Override
	public int[] batchInsert(List<Car> list) {
		return jdbc.batchUpdate("insert into cars(model, price) values (?,?)",
				new BatchPreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						Car car = list.get(i);
						ps.setString(1, car.getModel());
						ps.setInt(2, car.getPrice());
						
					}

					@Override
					public int getBatchSize() {
						return list.size();
					}
			
		});
	}
}

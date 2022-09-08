package kr.co.greenart.model.car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class CarRepositoryNamed implements CarRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	@Override
	public List<Car> getAll() {
		return jdbc.query("SELECT * FROM cars", new BeanPropertyRowMapper<Car>(Car.class));
	}

	@Override
	public Car getById(int id) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id", id);
		return jdbc.queryForObject("SELECT * FROM cars WHERE id=:id"
				, map
				, new BeanPropertyRowMapper<Car>(Car.class));
	}

	@Override
	public int add(Car car) {
		return jdbc.update("INSERT INTO cars (model, price) VALUES (:model, :price)"
				, new BeanPropertySqlParameterSource(car));
	}

	@Override
	public int[] batchInsert(List<Car> list) {
		return jdbc.batchUpdate("INSERT INTO cars (model, price) VALUES (:model, :price)"
				, SqlParameterSourceUtils.createBatch(list));
	}

	@Override
	public int update(Car car) {
		return jdbc.update("UPDATE cars SET model=:model, price=:price WHERE id=:id"
				, new BeanPropertySqlParameterSource(car));
	}

	@Override
	public int delete(int id) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id", id);
		return jdbc.update("DELETE FROM cars WHERE id=:id", map);
	}

}








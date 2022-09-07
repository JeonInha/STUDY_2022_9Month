package kr.co.greentart;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.greenart.config.RootConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class JdbcTemplateTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void test() {
		int result = jdbcTemplate.queryForObject("select 1", int.class);
		
		assertEquals(1, result);
				
	}
	
	@Test
	public void update() {
		int result = jdbcTemplate.update("update users SET name=?, age=? where id =?", 
				"새이름", 
				22, 
				1);
	
		assertNotEquals(0, result);
	}
	
// 테스트하면 사라지니께... 트랜젝션 필요!! ! ! 	
//	@Test
//	public void delete() {
//		int result = jdbcTemplate.update("delete from users where id=?", 2); 
//		assertEquals(1, result);
//	}
	
	@Test
	public void queryForList() {
		String sql = "select * from users";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		assertEquals(1, list.size());
		assertEquals("새이름", list.get(0).get("name"));
	}


}

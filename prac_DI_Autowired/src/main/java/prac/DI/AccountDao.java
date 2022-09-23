package prac.DI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private AccountRowMapper accMapper = new AccountRowMapper();
	// resultMapping 작업을 하는 RowMapper인터페이스를 구현한 객체.
	private class AccountRowMapper implements RowMapper<Account> {
		@Override
		public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
			String id = rs.getString("id");
			String pw = rs.getString("pw");

			return new Account(id, pw);
		}
	}

	// select: query() 사용. 파라미터는 sql문과 mapper.
	public List<Account> readAllAcc() {
		return jdbcTemplate.query("select * from account", accMapper);
	}

	// sql문에 인자를 부여할 수 있음. 부여한 인자는 query 메소드에 파라미터로 기입.
	public Account readByID(String id) {
		String sql = "select * from account where id = ?";
		List<Account> result = jdbcTemplate.query(sql, accMapper, id);
		if (result.isEmpty()) {
			return null;
		} else {
			return result.get(0);
		}
	}
	
	// 결과가 1행일 때: queryForObject 사용. 파라미터로는 sql문과 반환값 타입 클래스를 받음.
	public Integer countAccountNum() {
		String sql = "select count(*) from account";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}
	
	// C
	// 변경 쿼리 (insert, update, Delete)는 update() 메소드 사용. 실행결과로 변경된 행 갯수를 리턴.
	public boolean addAccount(Account acc) {
		
// 		insert 쿼리 실행 시 auto_Increment 컬럼의 자동생성 키 값을 구해주는 객체.
//		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		String sql = "insert into account (id, pw) values (?, ?)";
// 		keyHolder를 쓰고 싶다면, update 파라미터의 끝에 keyHolder 넣기! 
//		int check = jdbcTemplate.update(sql, acc.getId(), acc.getPw(), keyHolder);
		int check = jdbcTemplate.update(sql, acc.getId(), acc.getPw());

//		Number key = keyHolder.getKey();
//		System.out.println("키값은? "+key);
		if (check > 0)
			return true;
		else
			return false;
	}
}

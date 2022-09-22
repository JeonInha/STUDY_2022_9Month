package prac.DI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	@Autowired
	AccountDao accountDao;
	
	public boolean login(Account inputAcc) {

		Account acc = accountDao.readByID(inputAcc.getId());
		
		// 아이디가 DB에 존재
		if (acc != null) {
			// PW가 부합하는지.
			if (acc.getPw().equals(inputAcc.getPw())) {
				return true;
			}
		}
		return false;
	}
}

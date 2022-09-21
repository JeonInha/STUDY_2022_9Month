package prac.DI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {
	
	@Autowired
	AccountDao accountDao;
	
	public boolean signUp(Account inputAcc) {
		Account acc = accountDao.readByID(inputAcc.getId());
		
		// 아이디가 DB에 없음
		if (acc == null) {
			accountDao.addAccount(inputAcc);
			// TODO Loging
			System.out.println(accountDao.readAllAcc());
			return true;
			
		// 아이디가 DB에 있음 - 중복가입불가처리
		} else {
			return false;
		}
	}
}

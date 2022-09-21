package prac.DI;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDao {

	private Set<Account> accountRepository = new HashSet<Account>();
	
	public Set<Account> getAccountRepository() {
		return accountRepository;
	}

	public void setAccountRepository(Set<Account> accountRepository) {
		this.accountRepository = accountRepository;
	}
	

	// R
	public Set<Account> readAllAcc() {
		return accountRepository;
	}
	
	public Account readByID(String id) {
		for (Account acc : accountRepository) {
			if (acc.getId().equals(id)) {
				return acc;
			} 
		}
		return null;
	}
	
	// C
	public boolean addAccount(Account acc) {
		boolean a = accountRepository.add(acc);
		return a;
	}
	
}

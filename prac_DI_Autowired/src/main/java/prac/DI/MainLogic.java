package prac.DI;

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainLogic {

	@Autowired
	LoginService loginService;
	
	@Autowired
	SignUpService signUpService;
	
	@Autowired
	Scanner scanner;

	// 메뉴 출력하는 메소드
	public void printMenu(Account user) {
		
		System.out.println("====================");
		if (user != null) {
			// 로그인상태일때 메뉴
			System.out.println(user.getId() + "님, 환영합니다.");
			System.out.println("메뉴: [3. 로그아웃] [0. 프로그램 종료]");
		} else {
			// 로그아웃상태일때 메뉴
			System.out.println("메뉴: [1. 로그인] [2. 가입] [0. 프로그램 종료]");
		}
	}
	
	// id, pw 입력받아 Account 객체 반환하는 메소드
	public Account inputAccount() {
		System.out.print("id, pw 차례로 입력: ");
		String inputId = scanner.next();
		String inputPw = scanner.next();
		return new Account(inputId, inputPw);
	}

	// 로직을 간편하게 콘솔입출력으로만 구현.
	public void mainLogic() {
		
		// 로그인
		Account user = null;
		
		// 메뉴조작에 사용하는 변수: 숫자 당 메뉴기능을 할당.
		int systemNum = 9;

		System.out.println("☆★로그인 연습 서비스★☆");

		while (true) {
			// 로그인
			if (systemNum == 1) {

				Account loginAcc = inputAccount();
				boolean ifLogin = loginService.login(loginAcc);
				if (ifLogin) {
					user = loginAcc;
					System.out.println("로그인 되었습니다.");
				} else {
					user = null;
					System.out.println("로그인 실패. 로그인 정보를 확인하세요.");
				}
				systemNum = 9;

			// 회원가입
			} else if (systemNum == 2) {
				System.out.println("[회원가입]");
				Account signUpAcc = inputAccount();
				boolean ifSignUp = signUpService.signUp(signUpAcc);
				if (ifSignUp) {
					System.out.println("가입 완료");
				} else {
					System.out.println("존재하는 아이디입니다.");
				}
				systemNum = 9;

			// 로그아웃
			} else if (systemNum == 3) {
				System.out.println("[로그아웃]");
				user = null;
				System.out.println("로그아웃 되었습니다.");
				systemNum = 9;

			} else if (systemNum == 9) {
				printMenu(user);
				System.out.println("--------------------");
				System.out.print("입력: ");
				systemNum = scanner.nextInt();

			} else if (systemNum == 0) {

				System.out.println("프로그램 종료");
				break;
			} else {
				System.out.println("잘못된 입력");
				systemNum = 9;
			}
		}
	}

}

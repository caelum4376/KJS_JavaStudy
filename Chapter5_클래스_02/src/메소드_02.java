import java.util.Scanner;

// ID/PWD를 받아서 로그인 처리
public class 메소드_02 {

	static String isLogin(String id, String pwd) {
		String[] ids = { "hong", "park", "shim", "lee", "kang" };
		String[] pwds = { "1234", "3456", "4567", "5678", "6789"};
		String[] names = {};

		int index = 0;
		boolean bCheck = false;
		for (int i = 0; i < ids.length; i++) {
			if (id.equals(ids[i])) {
				bCheck = true;
				index = i;
				break;
			}
		}
		String result = "";

		if (bCheck == true) {
			// id가 존재
			// 비밀번호 검색
			if (pwd.equals(pwds[index])) {
				result = names[index]; // 로그인된 상태
			} else {
				result = "NOPWD"; // 비밀번호가 틀리다
			}
		} else {
			// id가 없는 상태
			result = "NOID";
		}

		return result;

	}

	static void process() {
		Scanner scan = new Scanner(System.in);

		System.out.print("ID 입력 : ");
		String id = scan.next();

		System.out.print("Password 입력 : ");
		String pwd = scan.next();

		// 검증 (로그인 처리)
		String result = isLogin(id, pwd);

		if (result.equals("NOID")) { // 아이디가 없는 상태

			System.out.println("아이디가 존재하지 않습니다!!");
		} else if (result.equals("NOPWD")) { // 비밀번호가 틀린 상태
			System.out.println("비밀번호가 틀립니다");
		} else {
			System.out.println(result + "님이 로그인된 상태입니다.");
		}

	}

	public static void main(String[] args) {
		process();
	}

}

import java.util.Scanner;

/*
 * 컴퓨터 / 사용자 => 가위바위보
 * => 가정 0-가위, 1-바위, 2-보
 */
public class 삼항연산자_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int com = (int) (Math.random() * 3); // 0, 1, 2
		Scanner scan = new Scanner(System.in);

		System.out.print("가위바위보를 입력해주세요 (0-가위, 1-바위, 2-보) : ");
		int user = scan.nextInt();

		// 확인
		System.out.print(com == 0?"컴퓨터 : 가위\n":"");
		System.out.print(com == 1?"컴퓨터 : 바위\n":"");
		System.out.print(com == 2?"컴퓨터 : 보\n":"");
		
		System.out.print(user == 0?"플레이어 : 가위\n":"");
		System.out.print(user == 1?"플레이어 : 바위\n":"");
		System.out.print(user == 2?"플레이어 : 보\n":"");

		System.out.println("=====결과=====");
//		System.out.print(com==0 && user==0?"Same":"");
//		System.out.print(com==0 && user==1?"User Win":"");
//		System.out.print(com==0 && user==2?"Com Win":"");
//		
//		System.out.print(com==1 && user==0?"Com Win":"");
//		System.out.print(com==1 && user==1?"Same":"");
//		System.out.print(com==1 && user==2?"User Win":"");
//		
//		System.out.print(com==2 && user==0?"User Win":"");
//		System.out.print(com==2 && user==1?"Com Win":"");
//		System.out.print(com==2 && user==2?"Same":"");
		
		int res = com-user;
		System.out.print(res == 0?"Same":"");
		System.out.print(res == -1 || res == 2?"User Win":"");
		System.out.print(res == 1 || res == -2?"Com Win":"");
		
		/* 결과값
		 * com      user
		 * 0(가위)	0(가위)	=> draw
		 * 			1(바위)	=> win
		 * 			2(보)	=> lose
		 * 1(바위)	0(가위)	=> lose
		 * 			1(바위)	=> draw
		 * 			2(보)	=> win
		 * 2(보)		0(가위)	=> win
		 * 			1(바위)	=> lose
		 * 			2(보)	=> draw
		 * 
		 */
		System.out.println();
	}

}

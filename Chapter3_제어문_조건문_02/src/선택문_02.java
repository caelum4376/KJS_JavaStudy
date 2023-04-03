import java.util.Scanner;

// 성적 계산
public class 선택문_02 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("세개의 정수 입력 : ");
		int kor = scan.nextInt();
		int eng = scan.nextInt();
		int math = scan.nextInt();
		int avg = (kor+eng+math);
		
		// 학점 출력
		char score = 'A';
		switch(avg/10) {
		case 10:
			score = 'A';
			break;
		case 9:
			score = 'A';
			break;
		case 8:
			score = 'B';
			break;
		case 7:
			score = 'C';
			break;
		case 6:
			score = 'D';
			break;
		default:
			score = 'F';
			break;
		}
	}
	

}

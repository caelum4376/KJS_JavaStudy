package question;

public class 문제_02_01 {

	public static void main(String[] args) {
		
		for (int i=1; i<=3; i++) {
			for (int j=1; j<=3; j++) {
				// i=1 j=1,2,3
				// i=2 j=1,2,3
				// i=3 j=1,2,3
				if(j==2) {
					continue;
				}
				System.out.println("1="+i+", j="+j);
			}
		}
	}

}

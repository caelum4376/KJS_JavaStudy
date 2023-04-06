import java.util.Arrays;

// 선택정렬 => 문자
/*
 *    B C A E D => ASC(ABCDE)/DESC(EDCBA)
 */
public class 배열응용_알고리즘_02 {

	public static void main(String[] args) {
		char[] arr = new char[10];
		
		for (int i=0; i<arr.length; i++) {
			arr[i] = (char)((int)(Math.random()*26)+65);
		}
		
		for (int i=0; i<arr.length-1; i++) {
			for (int j=i+1; j<arr.length; j++) {
				
				if (arr[i] < arr[j]) {
					char temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		
		for (int i=0; i<arr.length-1; i++) {
			for (int j=i+1; j<arr.length; j++) {
				
				if (arr[i] > arr[j]) {
					char temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}

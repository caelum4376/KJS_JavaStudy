import java.util.Arrays;

public class 메소드재사용 {

	public static void main(String[] args) {
		int[] arr = {40, 50, 10, 20, 30};
		메소드조립법_01.sort(arr, 1);
		System.out.println(Arrays.toString(arr));
	}

}

import java.util.Arrays;

/*
 * 정렬 : ASC(올림차순) / DESC(내림차순)
 * --------------------------------------
 * 선택정렬 / 버블정렬
 * 선택정렬 (select sort)
 * 
 * 10 30 50 20 40 => 10 20 30 40 50, 50 40 30 20 10
 * -- --
 * 30 10
 * --    --
 * 50    30
 * --       --
 * 50       20
 * --          --
 * 50          40
 * --------------- 1round
 * 50 10 30 20 40
 *    -- --
 *    30 10
 *    --    --
 *    30    20
 *    --       --
 *    40       30
 *    ------------ 2round
 * 50 40 10 20 30 
 *       -- --
 *       20 10   
 *       --    --
 *       30    20
 *       --------- 3round
 * 50 40 30 10 20
 *          -- --
 *          20 10
 *          ------ 4round
 * 50 40 30 20 10        
 * 
 *      i       j
 *    start    횟수
 *      0       4
 *      1       3
 *      2       2
 *      3       1
 *    ------------- i+j=4 => j=4-1
 *                              -length-1
 * 
 *       
 */
public class 배열응용_알고리즘_01 {

	public static void main(String[] args) {
		int[] arr = new int[5];
		for (int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*100)+1;
		}
		System.out.println("==== 정렬전 =====");
		System.out.println(Arrays.toString(arr));
		
		System.out.println("==== 정렬전(DESC) =====");
		for (int i=0; i<arr.length-1; i++) {
			for (int j=i+1; j<arr.length; j++) {
				
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		
		System.out.println("==== 정렬전(ASC) =====");
		for (int i=0; i<arr.length-1; i++) {
			for (int j=i+1; j<arr.length; j++) {
				
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}

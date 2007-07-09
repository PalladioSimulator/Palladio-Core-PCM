
public class ArrayTesterClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] test = new int[2][];
		int[] test2 = new int[] {1,2,3,4,5};
		
		test[0] = test2;
		test[0][0] = 2;
		
		System.out.println("test2: "); printArray(test2);
		System.out.println("test[0]: "); printArray(test[0]);
	}

	public static void printArray(int[] a){
		for (int i=0; i<a.length; i++){
			System.out.print(" " + a[i] + " ");
		}
		System.out.println();
	}
}

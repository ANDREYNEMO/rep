//
public class InsertionSort {

	public static int[] sort(int[] array) {
		int key = 0, i = 0;
		for (int j = 1; j < array.length; j++) {
			key = array[j];
			i = j - 1;
			while (i >= 0 && array[i] > key) {
				array[i + 1] = array[i];
				i = i - 1;
			}
			array[i + 1] = key;
		}
		return array;
	}

	public static void main(String[] args) {
		int[] mas = { 3, 2, 4, 1, 9, 5 };
		int[] mas2 = InsertionSort.sort(mas);
		for (int i = 0; i < mas2.length; i++) {
			System.out.println(mas[i]);
		}
	}
}

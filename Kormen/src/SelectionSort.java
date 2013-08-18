
public class SelectionSort {

	public static int [] sort(int []array){
		for(int i=0;i<array.length-1;i++){
			int key=i;
			int j=i;
			for(;j<array.length;j++){
				if(array[key]>array[j])
					key=j;
			}
			int temp=array[i];
			array[i]=array[key];
			array[key]=temp;
		}
		return array;
	}
	public static void main(String[] args) {
		int[] mas = { 3, 2, 4, 1, 9, 5 };
		int[] mas2 = SelectionSort.sort(mas);
		for (int i = 0; i < mas2.length; i++) {
			System.out.println(mas[i]);
		}
	}
}

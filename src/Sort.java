
/*
 * @Author Jaroslaw Pogoda
 * @parameters work 
 * @function sorting function
 * Description: Sorting functions and counts work collectively 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
	
public class Sort {
	private static int IWork=0, SWork=0, HWork=0, QWork=0, Ie=0,Ic=0, Se=0, Sc=0,He=0, Hc=0, Qe=0, Qc=0;
	
	public static void zeroWork(){
		Ie=0;Ic=0; Se=0; Sc=0;He=0; Hc=0; Qe=0; Qc=0;
	}
	public static int getIwork(){
		return (Ie*3)+Ic;
	}
	public static int getSwork(){
		return (Se*3)+Sc;
	}
	public static int getHwork(){
		return (He*3)+Hc;
	}
	public static int getQwork(){
		return (Qe*3)+Qc;
	}
	public static String intoAFile(int sizes) throws IOException{
		String st = "At Size:"+sizes+"\n";
		
	IWork=(Ie*3)+Ic;
	SWork=(Se*3)+Sc;
	HWork=(He*3)+Hc;
	QWork=(Qe*3)+Qc;
	st+=" Insertion Sort" + "  Work" +IWork+"  Selection Sort"+"  Work "+SWork+" Heap Sort"+"  Work "+HWork+" Quick Sort"+"  Work "+QWork;
	IWork=0;
	SWork=0;
	HWork=0;
	QWork=0;
	
	return st;
	}
	
	public static int[] copy(int[] arr) {
		
		int ans[] = new int[arr.length];
		for (int h = 0; h < arr.length; h++)
			ans[h] = arr[h];
		return ans;
	}

	public static void selectionSort(int[] arr) {
		
		int i, j, minIndex, tmp;
		int n = arr.length;

		for (i = 0; i < n - 1; i++) {
			minIndex = i;
			for (j = i + 1; j < n; j++){
				if (arr[j] < arr[minIndex])
					
					minIndex = j;
				Sc++;
				;}
			
			if (minIndex != i) {
				tmp = arr[i];
				arr[i] = arr[minIndex];
				Se++;
				arr[minIndex] = tmp;
			}
		}
	}

	public static void insertionSort(int[] arr) {
		
		int i, j, newValue;
		for (i = 1; i < arr.length; i++) {
			newValue = arr[i];
			j = i;
			while (j > 0 && arr[j - 1] > newValue) {
				arr[j] = arr[j - 1];
				Ie++;
				Ic++;
				j--;
			}
			arr[j] = newValue;
			Ie++;
		}
	}

	public static int partition(int arr[], int left, int right) {
		int i = left, j = right;
		int tmp;
		int pivot = arr[(left + right) / 2];
		Qe++;
		while (i <= j) {
			while (arr[i] < pivot){
				Qc++;
				i++;
			}
			while (arr[j] > pivot){
				Qc++;
				j--;
			}
			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				Qe++;
				i++;
				j--;
			}
		}
		;

		return i;
	}

	public static void quickSort(int arr[], int left, int right) {
		int index = partition(arr, left, right);
		if (left < index - 1)
			quickSort(arr, left, index - 1);
		if (index < right)
			quickSort(arr, index, right);
	}

	public static void heapSort(int[] arr) {

		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, i, n);
		}
		for (int i = n - 1; i > 0; i--) {
			swap(arr, 0, i);
			heapify(arr, 0, i);

		}
	}

	// heapify funciton for heapSort
	public static void heapify(int[] arr, int i, int j) {
		int ai = arr[i];
		while (2 * i + 1 < j) {
			int k = 2 * i + 1;
			if (k + 1 < j && arr[k + 1] > arr[k]) {
				++k;
			}
			Hc++;
			if (ai >= arr[k]){
				Hc++;
				break;
			}
			arr[i] = arr[k];
			He++;
			i = k;
		}
		arr[i] = ai;
		He++;
	}

	// swap within the array
	public static void swap(int[] arr, int i, int j) {
		if (i == j)
			return;
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
		He++;
	}

	// swap only 2 digits
	public static void swap(int i, int j) {
		int temp = i;
		i = j;
		j = i;
	}
}

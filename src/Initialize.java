
/*
 * @Author
 * reads in and generates random array and iniciates array
 */

public class Initialize extends Sort {
	private RandomNumbers rans;
	private int[] array;
	private int size;
	public Initialize(int s){
		rans= new RandomNumbers();
		array= new int[s];
		size= s;
		getRandArray();
		
	}
	public void print(){
		for(int i=0;i<size;i++)System.out.println(array[i]+","+getSSort(getArray())[i]+"/"+getISort(getArray())[i]+"."+getQSort(getArray())[i]+"_"+getHSort(getArray())[i]);
	}
	public int[] getSSort(int[] arr){
		Sort.selectionSort(arr);
		return arr;
	}
	public int[] getISort(int[] arr){
		Sort.insertionSort(arr);
		return arr;
	}
	public int[] getQSort(int[] arr){
		Sort.quickSort(arr, 0, arr.length-1);;
		return arr;
	}
	public int[] getHSort(int[] arr){
		Sort.heapSort(arr);
		return arr;
	}
	public int[] getArray(){
		int [] arr= new int[size];
		for(int i=0;i<size;i++){
			arr[i]=array[i];
		}
		return arr;
	}
	public int getNext(){
		return rans.getNextRandomNumber();
	}
	public void getRandArray(){
		for(int num=0; num<size;num++){
			array[num]=rans.getNextRandomNumber();
		}
	}
}

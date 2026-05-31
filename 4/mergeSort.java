import java.util.Arrays;
public class mergeSort{
	//----merge two sorted lists into a single list
	public static void main(String[] args){
		
		int[] A = {1,3,5,7,8,9};
		int[] B = {2,4,6,8,10};
		int[] C = new int [(A.length+B.length)];
			
		int apoint = 0;
		int bpoint = 0;
		int cpoint = 0;

		while (apoint < A.length && bpoint < B.length) {
			if (A[apoint] <= B[bpoint]) {
				C[cpoint] = A[apoint];
				apoint++; }
			else {
				C[cpoint] = B[bpoint];
				bpoint++; }
				cpoint++; }
				 
			if (apoint < A.length) {
				for (int p = apoint; p < A.length; p++) {
					C[cpoint] = A[p];
					cpoint++; } }
			else {
				for (int p = bpoint; p < B.length; p++) {
					C[cpoint] = B[p];
					cpoint++; }			
					System.out.println(Arrays.toString(C)); // prints the merged array
  }  } }
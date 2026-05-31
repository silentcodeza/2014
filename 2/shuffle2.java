import java.util.Arrays;
import java.lang.Math.*;
//-----shuffling efficient method------
public class shuffle2{
	public static void main(String[] args){
		int n=52;
		int[] shuffled = new int[n+1];
		
		for(int i=0; i<n+1; i++){
			shuffled[i] = i; }
			
		int temp1;
		int temp2;
		
		for(int j=0; j<n+1; j++){
			int r = 1+(int)(Math.random()*n);
			temp1 = shuffled[j];
			temp2 = shuffled[r];
			shuffled[r] = temp1;
			shuffled[j] = temp2;
			}
		System.out.println(Arrays.toString(shuffled)); }}
		//----end of shuffle2----
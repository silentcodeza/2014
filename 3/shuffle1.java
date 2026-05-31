import java.lang.Math.*;
import java.util.Arrays;
//------shuffling for improved very bad method-----
public class shuffle1{
	public static void main(String[] args){
		int n = 52;
		int[] shuffled = new int[n+1];
		int[] isPresent = new int[n+1];
		int r=0, i=0;
		int count=0;
		
		while(i < n){
			if (isPresent[r] == 0){
				shuffled[i] = r;
				isPresent[r] = 1;
				i++; } 
			else{
				r = 1 + (int)(Math.random()*n);
				count++; } }
		for(int j=0; j<isPresent.length; j++){
			if(isPresent[j] == 0){
				shuffled[isPresent.length-1] = j; } }
		System.out.println(Arrays.toString(shuffled));		//prints the shuffled array
			}}
			//------End of shuffling------
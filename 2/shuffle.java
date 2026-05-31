import java.lang.Math.*;   
import java.io.*;   
import java.text.*;
import java.util.Arrays;

public class shuffle{ 
   public static int N = 52*1;
   public static void main(String args[]){

      DecimalFormat twoD = new DecimalFormat("0.00");
      DecimalFormat fourD = new DecimalFormat("0.0000");
      DecimalFormat fiveD = new DecimalFormat("0.00000");

      long start, finish;
      double runTime = 0, runTime2 = 0, time;
      double totalTime = 0.0;
      int n = N;
      int repetition, repetitions = 1000;

      runTime = 0;
      for(repetition = 0; repetition < repetitions; repetition++) {
         start = System.currentTimeMillis();

         // call the procedure to time here:
		 
		 //shuffling for improved very bad method
         shuffle(n);

         finish = System.currentTimeMillis();

         time = (double)(finish - start);
         runTime += time;
         runTime2 += (time*time); }
      
      double aveRuntime = runTime/repetitions;
      double stdDeviation = 
            Math.sqrt(runTime2 - repetitions*aveRuntime*aveRuntime)/(repetitions-1);

      System.out.printf("\n\n\fStatistics for improved very bad method\n");
      System.out.println("________________________________________________");
      System.out.println("Total time   =           " + runTime/1000 + "s.");
      System.out.println("Total time\u00b2  =           " + runTime2);
      System.out.println("Average time =           " + fiveD.format(aveRuntime/1000)
            + "s. " + '\u00B1' + " " + fourD.format(stdDeviation) + "ms.");
      System.out.println("Standard deviation =     " + fourD.format(stdDeviation));
      System.out.println("n            =           " + n);
      System.out.println("Average time / run =     " + fiveD.format(aveRuntime/n*1000) 
            + '\u00B5' + "s. "); 

      System.out.println("Repetitions  =             " + repetitions);
      System.out.println("________________________________________________");
      System.out.println();
      System.out.println();
      
      runTime = 0;
      for(repetition = 0; repetition < repetitions; repetition++) {
         start = System.currentTimeMillis();

         // call the procedure to time here:
		 
		 //shuffling for efficient method
         shuffle2(n);

         finish = System.currentTimeMillis();

         time = (double)(finish - start);
         runTime += time;
         runTime2 += (time*time); }

      System.out.printf("\n\n\fStatistics for efficient shuffle\n");
      System.out.println("________________________________________________");
      System.out.println("Total time   =           " + runTime/1000 + "s.");
      System.out.println("Total time\u00b2  =           " + runTime2);
      System.out.println("Average time =           " + fiveD.format(aveRuntime/1000)
            + "s. " + '\u00B1' + " " + fourD.format(stdDeviation) + "ms.");
      System.out.println("Standard deviation =     " + fourD.format(stdDeviation));
      System.out.println("n            =           " + n);
      System.out.println("Average time / run =     " + fiveD.format(aveRuntime/n*1000) 
            + '\u00B5' + "s. "); 

      System.out.println("Repetitions  =             " + repetitions);
      System.out.println("________________________________________________");
      System.out.println();
      System.out.println(); 
      
      runTime = 0;
      for(repetition = 0; repetition < repetitions; repetition++) {
         start = System.currentTimeMillis();

         // call the procedure to time here:
		 
		 //merge sort two sorted arrays
         merge();

         finish = System.currentTimeMillis();

         time = (double)(finish - start);
         runTime += time;
         runTime2 += (time*time); }
      
      System.out.printf("\n\n\fStatistics for simple merging\n");
      System.out.println("________________________________________________");
      System.out.println("Total time   =           " + runTime/1000 + "s.");
      System.out.println("Total time\u00b2  =           " + runTime2);
      System.out.println("Average time =           " + fiveD.format(aveRuntime/1000)
            + "s. " + '\u00B1' + " " + fourD.format(stdDeviation) + "ms.");
      System.out.println("Standard deviation =     " + fourD.format(stdDeviation));
      System.out.println("n            =           " + n);
      System.out.println("Average time / run =     " + fiveD.format(aveRuntime/n*1000) 
            + '\u00B5' + "s. "); 

      System.out.println("Repetitions  =             " + repetitions);
      System.out.println("________________________________________________");
      System.out.println();
      System.out.println(); }

   // The declarations 
   // The body of your method 
   // Last statement of code.  
   
   
   public static void merge (){
      int[] A = {1,3,5,7,8,9};
      int[] B = {2,4,6,8,10,12,35,75};
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
            cpoint++; }}}
         // System.out.println(Arrays.toString(C)); // prints the merged array
      
   

   public static void shuffle (int n){
      int[] shuffled = new int[n+1];
      int[] isPresent = new int[n+1];
      int r = 0 , i = 0;
      int count = 0;

      while (i < n){
         if (isPresent[r] == 0){
            shuffled[i] = r;
            isPresent[r] = 1 ; 
            i++;  } 
         
         else{
            r = 1+ (int)(Math.random()*n);
            count++; } }
      
     for (int w =0 ; w < isPresent.length ; w++){
         if(isPresent[w] == 0){
            shuffled[isPresent.length-1] = w; } } }
		//System.out.println(Arrays.toString(shuffled)); //Prints the shuffled array
		//end shuffle

   public static void shuffle2 (int n){
      int[] shuffled = new int[n+1];
      
      for (int i=0 ; i< n+1 ; i++){
         shuffled[i] = i; }
      
      int tmp1;
      int tmp2;
               
      for (int j=0 ; j < n+1 ; j++){
          int r = 1+ (int)(Math.random()*n);
          tmp1 = shuffled [j];
          tmp2 = shuffled [r];
          shuffled[r] = tmp1;
          shuffled[j] = tmp2; } } }
		//System.out.println(Arrays.toString(shuffled));
        //ends shuffle2 

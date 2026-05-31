import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TimeTable {
	String[][] table;
	
	public void table(){
		table = new String[10][5];
	}
	private int dayCheck(String day){
		int n=0;
		if(day.equals("MON"))n=0;
		else if(day.equals("TUE"))n=1;
		else if(day.equals("WED"))n=2;
		else if(day.equals("THU"))n=3;
		else if(day.equals("FRI"))n=4;
		return n;
	}
	public void readFile(String file){
		//File run.
		String fileName1 = file;
		String dayS;
		int dayI, period;
        try
        {
			Scanner classT = new Scanner(new File(fileName1));
            // Read the header line

            // Read the rest of the file line by line
			int o=0;
            while (classT.hasNextLine())
            {
				String lineT = classT.nextLine();
            	if(o==0)o++;
            	else{
            	
            	String[] listT = lineT.split(",");
            	
				dayS = listT[7].trim();
				period = Integer.parseInt(listT[8].trim());
				dayI = dayCheck(dayS);
				table[period-1][dayI] = table[period-1][dayI]+"," +listT[3]+"."+listT[6]+" "+listT[5]+" "+listT[4]+" "+listT[11];
            	}
				
    		}
			System.out.println("Done reading data...");
			classT.close();
   
        }                                    
        catch(FileNotFoundException e)
        {
            System.out.println("Cannot find file: "+ file);
			System.exit(0);
        }
						
	}
	private String tabStopL(String str, int tab){
		String noS = "_";
		int no = tab - str.length();
		for(int i=0; i<no;i++){
			noS = "_" + noS;
		}
		return str + noS;
	}
	
	private String tabStop(String str, int tab){
		String noS = " ";
		int no = tab - str.length();
		for(int i=0; i<no;i++){
			noS = " " + noS;
		}
		return str + noS;
	}
	public void design(int per){
		String[] list1_1 = table[per][0].split(",");
		String[] list1_2 = table[per][1].split(",");
		String[] list1_3 = table[per][2].split(",");
		String[] list1_4 = table[per][3].split(",");
		String[] list1_5 = table[per][4].split(",");

		int a=1,b=1,c=1,d=1,e=1;
		int p=0;
		for(int i=0;i<100;i++){
			p=0;
			System.out.print(tabStop("|",20));
			//System.out.println(tabStop("1", 30)+ tabStop(list1_1[a],30) + "|" + tabStop(list1_2[b],30) + "|" + tabStop(list1_3[c],30));
			if(list1_1.length>a){
				System.out.print(tabStop(list1_1[a],35));
				a++;
			}
			else{
				System.out.print(tabStop(".",35));
				p++;}
				
			if(list1_2.length>b){
				System.out.print("|"+tabStop(list1_2[b],35));
				b++;}
			else{
				System.out.print(tabStop(".",35));
				p++;}
				
			if(list1_3.length>c){
				System.out.print("|"+tabStop(list1_3[c],35));
				c++;}
			else{
				System.out.print(tabStop(".",35));
				p++;}
			
			if(list1_4.length>d){
				System.out.print("|"+tabStop(list1_4[d],35));
				d++;}
			else{
				System.out.print(tabStop(".",35));
				p++;}
			
			if(list1_5.length>e){
				System.out.println("|"+tabStop(list1_5[e],40)+"|");
				e++;}
			else{
				System.out.println(tabStop(".",40)+"|");
				p++;}
			if(p==5)break;
		}
	}
	public void run(){
		table();
		readFile("TimeTableSlots.csv");
		System.out.println(tabStopL("",200));
		System.out.println(tabStop("Period",30)+tabStop("Mon",35)+tabStop("Tue", 35)+tabStop("Wed", 35)+tabStop("Thu",35)+tabStop("Fri",35));
		System.out.println(tabStopL("",200));
		for(int i=1;i<7;i++){
			System.out.println("Period " + i);
			System.out.println(tabStopL("",200));
			design(i-1);
			if(i==4){
				System.out.println(tabStopL("",200));
				System.out.println(tabStop("",30)+tabStop("L",35)+tabStop("U", 35)+tabStop("N", 35)+tabStop("C",35)+tabStop("H",35));
				System.out.println(tabStopL("",200));}
		}
	}
	public static void main(String[] args) {
		TimeTable test = new TimeTable();
		test.run();
	}

}

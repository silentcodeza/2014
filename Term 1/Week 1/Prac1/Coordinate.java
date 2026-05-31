import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Coordinate {
	
	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public Coordinate() {
		super();
		this.x = 0;
		this.y = 0;
	}

	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	

	@Override
	public String toString() {
		return "Coordinate (" + x + ", " + y + ")";
	}
	
	public int compareTo(Coordinate otherCoordinate){
		if ((x < otherCoordinate.x) || ((x == otherCoordinate.x) && (y < otherCoordinate.y))){
			return -1;
		}
		else if ((x == otherCoordinate.x) && (y == otherCoordinate.y)){
			return 0;
		}
		return 1;
	}
	
	public double  distanceBetween(Coordinate c1, Coordinate c2){
		double d = Math.sqrt(Math.pow(c1.getX() - c2.getX(), 2) + Math.pow(c1.getY() - c2.getY(), 2));
		return d;
	}
	public double[] storing(String file){	
		int x_coor;
		int y_coor;
		Coordinate[] store = new Coordinate[30];
		
		//File run.
		String fileName1 = file;
		int m =0, z =0;
        try
        {
			Scanner coor = new Scanner(new File(fileName1));
            // Read the header line

            // Read the rest of the file line by line

			
			/*
			while (coor.hasNextLine())
	            {
				i = i + 1;
	            }
			
			System.out.println("Done cooraction");
            coor.close();
   
        }         
        catch(FileNotFoundException e)
        {
            System.out.println("Cannot find file ");
        }
        Scanner coor = new Scanner(new File(fileName3));*/
			
			
            while (coor.hasNextLine())
            {
            	String lineT = coor.nextLine();
            	String[] listT = lineT.split(",");
            	
				x_coor = Integer.parseInt(listT[0].trim());
				y_coor = Integer.parseInt(listT[1].trim());
				//System.out.println("X " + x_coor);
				//System.out.println("Y " + y_coor);
				store[z] = new Coordinate();
				store[z].setX(x_coor);
				store[z].setY(y_coor);
				System.out.println(store[z]);
				z++;
			}
			System.out.println("Done reading data...");
            coor.close();
   
        }                                    
        catch(FileNotFoundException e)
        {
            System.out.println("Cannot find file ");
        }
        
        //Sorting
        Coordinate temp;
        for(int i=0; i<store.length; i++){
        	for(int x=i; x<store.length; x++){
	        	if(store[x].compareTo(store[i]) == -1){
	        		temp = store[x];
	        		store[x] = store[i];
	        		store[i] = temp;
	        	}
        	}
        }
		int count = 0;
		for(int i=0; i<z-1;i++){
        	for(int j = i + 1; j<z;j++){
        		count++;
			}
		}
        double[] d1 = new double[count];
        int s = 0;
        for(int i=0; i<z-1;i++){
        	for(int j = i + 1; j<z;j++){
        		d1[s] = distanceBetween(store[j], store[i]);
				/*if (d1[s] == 0){
						System.out.println("store[j] :" +store[j]);
						System.out.println("store[i] :" +store[i]);
				}
				System.out.println("Dis: "+d1[s]);*/
				
        		s++;
        	}
        }
        double temp2;
        for(int i=0; i<d1.length; i++){
        	for(int x=i; x<d1.length; x++){
	        	if(d1[x] <d1[i]){
	        		temp2 = d1[x];
	        		d1[x] = d1[i];
	        		d1[i] = temp2;
	        	}
        	}
        }
        return d1;
        
   
	}
	
	/*public void run(){
		double[] d1 = storing("Person1.csv");
		double[] p1 = storing("TestFile1.csv");
		
		System.out.println("Testing... ");
		for(int i=0; i<d1.length;i++){
			System.out.printf("Distance1 Person2: %.2f  Distance1 TestFile1 %.2f \n", d1[i],p1[i]);
			if(d1[i] != p1[i]){
				System.out.println("Not a match! ");
				System.exit(0);
			}
		}
		System.out.println("its a match! ");
	}*/
	        
	
	/*public static void main(String[] args) {
		Coordinate test = new Coordinate();
		test.run();

	}*/

}

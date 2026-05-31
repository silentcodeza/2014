public class queue {

static int length;
static node front;
static node rear;

public queue() {
   front = new node ("front", 0L);
   rear  = new node ("rear", 0L);
   length=0; }

public void put (node n) {
   rear.previous = n.previous;
   n.previous = n; 
   length++; }
		
public node get () { 
node n;
   if(front == null)
      return null;
   else{
      n = front;
      front = front.previous;
      length--; }
 
	return n; }

public void display(){
        node val = front;
	int lis = 0;
	while(here != rear && lis++ < 6){
            System.out.println(here);}
	if(lis>0){
	    System.out.println("Queue's length= " + length);
	    //System.out.println("Queue's length= " + length);
	//else{
	    //System.out.println();}
}
   System.out.println("---------------------------------")
;
   System.out.println("---------------------------------");
   System.out.println("================================="); } }

/**
 previous: = null, value: one, key: 1 >  
< previous: = null, value: two, key: 2 >  
< previous: = null, value: three, key: 3 >  
< previous: = null, value: four, key: 4 >  

*/
















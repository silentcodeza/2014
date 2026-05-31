import static java.lang.System.out;
public class tableHash {
	int [] T;										//table of parent links
	Node[] Store;
	int n =0,h=1;									//h was supposed to be i

	//String [] Data = {"z#","six", "","three","seven","two",,"four",,"five",}
	//String [] Data = {"z#","two","five","three","four","six","one","seven","nine","eight"};
	
	public tableHash(int len){
		T = new int [len];
		Store = new Node[len];
		
		for(int i=0; i<len; i++){
			Store[i] = new Node("none", 0); } }
	
	public int hash(int h){	
		h = ((h*13)%9)+1;					//generates nums that define a hashTable
		return h; }
		
	public int insertHash(String data){
		
		while(!isFilledByRatio(75) && n<T.length){
			n++;									//position at Store[]	
			h = hash(h);	
			Store[n].data = data;
			
			if(T[h] != 0) {							//if Table entry is filled
				Store[n].link = T[h]; 				//link Node to T[h] position
				return h; }						//Check if Insertion was successful
			else
				T[h] = n;
				return h;
			}
			return -1;	}							//Check if Insertion was successful
			
	public void display(){
		out.println("hash()\tT[i]\tStore[i]:");
		int h4printing = 1;
		for(int i=1; i<T.length; i++){
			h4printing = hash(h4printing);
			out.println(h4printing+"\t"+T[i]+  "\t|"+i+"|"+Store[i].data);
		}
		out.println("\nMy Nodes:_______________________________________________");
		
		int nLink=	1;											//Points to Next linkedNode
		
		for(int i=1; i<T.length; i++){
			if(T[i] != 0)
				out.printf("\n|%s\t| %d|",Store[T[i]].data, Store[T[i]].link);
		
			nLink= hash(T[i])+1;
			if(T[i] !=0 && Store[nLink].link != 0)			//hash(T[i]), to access child node
				out.printf("\t|%s\t| %d|", Store[ nLink].data,  Store[nLink].link );
			
			if(T[i] != 0){
				out.print("\t\tT[i]="+T[i]+ " & hash()="+(hash(T[i])+1));
				out.println();
			}}}
	
	public boolean isFilledByRatio(int alph){
		return ((int)(n/Store.length)*100)  > alph;
	}}

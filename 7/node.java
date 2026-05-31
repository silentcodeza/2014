public class node {
node previous;
String value;
long key;

public node() {
   previous = null;
   key = 0; 
   value = ""; }

public node(String v, long k) {
   previous = null;
   key = k; 
   value = v; }

public String toString () {
	return "< previous: = " + previous 
        + ", value: " + value 
        + ", key: " + key + " >  "; } }

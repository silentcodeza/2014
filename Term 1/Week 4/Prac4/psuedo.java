Question1
Adding a Node 'x' of type Person/String
	if LinkedList is not Empty:
		front --> x
	else
		set next x to front
		front --> x
	size --> size+1
	
removing last Node of type Object
	if LinkedList is Empty
		print Empty list
		remNode --> null
		
	else if linkedList contians one Node
		remNode --> get the Node after front
		front --> null
		size --> 0
		
	else
		loop through the list until the second last Node 'sLast'
		sLast --> second last node
		remNode --> get the next Node after sLast
		set next sLast to null
		size --> size-1
		
	return remNode
		

Question 2		
Adding a Node 'x' of type Object
	if DLinkedList is not Empty:
		front --> x
	else
		set next x to front
		set prev front to x
		front --> x
	size --> size+1
	
removing last Node of type Object
	if LinkedList is Empty
		print Empty list
		remNode --> null
		
	else if linkedList contians one Node
		remNode --> get the Node after front
		front --> null
		size --> 0
		
	else
		loop through the list until the second last Node 'sLast'
		sLast --> second last node
		remNode --> get the next Node after sLast
		set next sLast to null
		size --> size-1
		
	return remNode
		
		
		
		
		
		
		
		
		
		
		
		
		
		
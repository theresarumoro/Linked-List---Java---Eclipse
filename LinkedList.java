
public class LinkedList {
	
	private MyNode head;
	
	//initializes the list with a value
	public LinkedList(int data) {
		MyNode cursor = head;	//set cursor to head so we can traverse
		if (cursor == null);	//check to see if cursor is at end of list
			head = new MyNode(data);	//make the head of the list the new value
			//statement to tell the user that they initialized the list
			System.out.println("Initializing the linked list with value: " + data);	//prints output for user
	}
	
	//finds the size of the list
	public int size() {
		MyNode cursor = head; //set cursor to head so we can traverse
		int count = 0; //initialize counter to 0
		while (cursor != null) { //check to see if we've
		//gotten to the end of the list
				count++; //increment counter
				cursor = cursor.getNext(); //move cursor through the list
		}
		return count; //return the count (i.e. size of list)
	}

	//checks to see if the linked list is empty
	public boolean isEmpty() {
		if (size()==0) {	//if size of list is zero
			return true;	//return true
		}
		else {				//if size of list is not zero
			return false;	//return false
		}
	}
	
	//adds values to list
	public void add(int a) {
		MyNode cursor = head;	//sets cursor to head so we can traverse
		MyNode tail = new MyNode(a);	//creates tail in MyNode to the integer value
		//if (cursor == null) {	//if cursor is at end of list
		if (size() == 0){	//if list size is zero
			head = new MyNode(a);	//set the new value to the head
		}
		else {	//if list size is not zero
			while (cursor.getNext() != null) {	//traverse through the list to get to end of list
				cursor = cursor.getNext();	//once at end, tell the cursor to go to the position after
				}
			cursor.setNext(tail);	//set the cursor to the tail since it is at the end of the list
			System.out.println("Inserting the value: " + a);	//print this statement for the user
			}
	}
	
	public void remove(int value) {
		MyNode cursor1 = head;	//set cursor1 to head
		if (size() == 0) {	//if size is zero
			System.out.println("List is empty");	//print output to user		
		}
		else if (cursor1.getData() == value) {	//if cursor1 (at the head of the list) is the value
			head = cursor1.getNext();	//make the head of the list the second value
			cursor1 = null;	//set cursor1 to null so there is no hanging node
			System.out.println("Removing " + value);	//print output for user
		}		
		else {
			//traverse through list and stop when cursor two gets the value or when
			//cursor 2 gets to the end of the list
			MyNode cursor2 = head.getNext(); //set cursor2 to the next value of cursor1
			while ((cursor1.getData() != value) && (cursor2.getNext() != null) && (cursor2.getData() != value)) {	
				cursor1 = cursor1.getNext();	//traverse cursor1 through the list
				cursor2 = cursor2.getNext();	//traverse cursor2 through the list
			}
			if (cursor2.getData() != value) {	//if cursor2 never reaches the value, it does not exist
				cursor2.setNext(null);	//set cursor2 to null to end the list
				System.out.println("Removing " + value);	//print what user wanted
				System.out.println(value + " does not exist in list.");	//print what happened to user
			}
			else {
				//if value does exist
				cursor1.setNext(cursor2.getNext());	//make cursor one connect to the value next to the one getting deleted
				cursor2.setNext(null);	//set cursor2 to null because it does not exist anymore
				System.out.println("Removing " + value);	//print output to user
			}
		}
	}
	
	//deletes a node
	public void delete(int position) {
		MyNode cursor1 = head;	//set cursor1 to head
		if (size() == 0) {	//if size is zero
			System.out.println("Position " + position + " does not exist.");
			System.out.println("The list is empty.");	//print output to user
		}
		else if (position == 0) {	//if position is zero (head of the list)
			head = cursor1.getNext();	//set head to the second value to remove the first one
			System.out.println("Deleting position " + position);	//print output to user
		}
		else {
			MyNode cursor2 = head.getNext();	//set cursor2 to node next to cursor1
			int count = 1;	//set counter to one since we already have a condition for zero
			//traverse through the list with the parameters that say the counter should
			//not equal the position and that the cursor should not go past the list
			while ((count != position) && (cursor1.getNext() != null)){
				count ++;	//increase the count to keep track of the position that the user wants
				cursor1 = cursor1.getNext();	//move cursor1 to the next node
				cursor2 = cursor2.getNext();	//move cursor2 to the next node
			}
			if (count != position) {	//if the count does not equal the position after the list is read
				System.out.println("Deleting position " + position);	//print output for user
				System.out.println("Position " + position + " does not exist.");	//print output for user
			}
			else if (cursor1.getNext() == null) {	//if there is no position after cursor1
				System.out.println("Deleting position " + position);	//print output for user
				System.out.println("Position " + position + " does not exist.");	//print output for user
			}
			else {	//if count does equal the position
				cursor1.setNext(cursor2.getNext());	//make cursor1 equal the value next to the position that is getting deleted
				cursor2.setNext(null);	//set cursor2 to null since it was at the position being deleted
				System.out.println("Deleting position " + position);	//print output for the user
			}
		}
	}

	//inserts items into the linked list
	public void insert(int item, int position) {
		MyNode insert = new MyNode(item);	//create insert in MyNode that has the item value
		MyNode cursor = head;	//sets cursor to head so we can traverse
		//MyNode tail = new MyNode(item);	//do we need this
		if (position == 0) {	//if position is zero
			insert.setNext(cursor);	//set insert to the cursor since it is the first value
			head = insert;	//make insert the new head since the list was zero
			System.out.println("Inserting " + item + " at position " + position);	//print output for user
		}
		else if (position >= size()) {	//if position is greater than the size
			while (cursor.getNext() != null) {	//traverse the cursor through the list, stop when it gets to end
				cursor = cursor.getNext();	//this allows the cursor to traverse through the list
			}
			cursor.setNext(insert);	//set the next value of the cursor to the insert value
			System.out.println("Inserting " + item + " at position " + position);	//print output for the user
		}
		else {
			int counter = 0;	//initialize counter to zero
			//traverse through list with the parameters that say the counter should
			//be one behind the position so that the value can be added in the position
			//that the user wants (next position) and also make sure that the cursor stops
			//before the list ends
			while ((counter < position-1) && (cursor != null)) {
				cursor = cursor.getNext();	//allows the cursor to move through the list
				counter ++;	//keeps track of the position of the cursor
			}
			insert.setNext(cursor.getNext());	//sets the insert value to the cursors next value
			cursor.setNext(insert);	//sets cursor to the next value so it does not leave the list
			System.out.println("Inserting " + item + " at position " + position);	//print output for the user
		}
	}
	
	//print items in list
	public void print() {
		MyNode cursor = head;	//sets cursor to head so we can traverse
		System.out.print("Linked list items: ");	//print the label for the data
		while (cursor != null) {	//traverse through the list without going past the list
			System.out.print(cursor.getData() + " ");	//print the values that the cursor goes over and a space
			cursor = cursor.getNext();	//move the cursor through the list
		}
		System.out.println(" ");	//print a space to organize output
	}
	
	//print size of list
	public void printsize() {
		MyNode cursor = head;	//sets cursor to head so we can traverse
		int count = 0;	//set count to zero to keep track of list size
		while (cursor != null) {	//traverse through the list without going past the list
			count ++;	//keep track of how many items the cursor goes over
			cursor = cursor.getNext();	//move the cursor through the list
		}
		System.out.println("The size of the linked list is: " + count);	//print output for the user
	}
	
	public void printempty() {
		if (size() != 0) {
			System.out.println("The list is not empty.");
		}
		else {
			System.out.println("The list is empty");
		}		
	}
	
	//main function allows the user to do what they want with the list using the
	//functions above.
	public static void main(String[] args) {
		LinkedList ll = new LinkedList(2);	//sets an initial value to the list
		ll.printsize();	//prints size to user
		ll.add(5);	//add value to list
		ll.add(7);	//add value to list
		ll.add(19);	//add value to list
		ll.add(13);	//add value to list
		ll.printsize();//prints size of list
		ll.print();	//prints list
		ll.remove(5);	//removes value from list
		ll.print();	//prints list
		ll.remove(29);	//remove value from list
		ll.printsize();	//print size of list
		ll.insert(31, 3);	//inserts value at position
		ll.print();	//prints list
		ll.delete(1);	//deletes position from list
		ll.delete(2);	//deletes position from list
		ll.delete(19);	//deletes position from list
		ll.printempty();	//says whether list is empty or not
		ll.print();	//prints list
		ll.delete(0);	//deletes position from list
		ll.delete(0);	//deletes position from list
		ll.print();	//prints list
		ll.delete(1);	//deletes position from list
		ll.printempty();	//says whether list is empty or not
		ll.delete(0);	//deletes position from list
		ll.printempty();	//says whether list is empty or not
		ll.delete(1);	//deletes position from list
		ll.printsize();	//prints size of list
		ll.print();	//prints list


	

		

	}

}

package Vjezbe;

import java.util.Iterator;

public class LinkedListB<T> implements Iterable<T>{
	
	private Node head;
	
	/**
	 * Method which adds Node in our list.
	 * @param value
	 */
	public void add(T value){
		Node newNode = new Node<T>(value);
		if(head == null){
			head = newNode;
		}else{
			Node current = head;
			while(current.getNextNode() != null)
				current = current.getNextNode();
			current.setNextNode(newNode);
		}		
	}
	
	/**
	 * Method which removes node from our list. 
	 * @param idx is parameter  at what index we are removing our node.
	 */
	public void removeAt(int idx){
		int counter = 0;
		Node current = head;
		
		if(idx == 0 ){
			head = head.getNextNode();
			return;
		}
		
		while(counter < idx-1 ){
			current = current.getNextNode();
			counter++;
		}	
		
		Node prev = current;
		current = current.nextNode;
		if( current != null)							//In case we are deleting last node.
			prev.nextNode = current.nextNode;
			
	}
	/**
	 * Method gets Node at index sent as parameter.
	 * @param idx parameter is index position of our node
	 * @return node's value
	 */
	public T getAt(int idx){
		int counter = 0;
		Node current = head;
		
		while(counter < idx){
			current = current.getNextNode();
			counter++;
		}		
		return (T) current.getValue();		
	}	
	
	public String toString(){
		String out = "";
		Node current = head;
		while(current != null){
			out += current.toString() +" ";
			current = current.getNextNode();			
		}
		
		
		return out;
		
	}
	
	/**
	 * Method checks if value sent as parameter exists in our list.
	 * @param value
	 * @return
	 */
	public boolean contains(T value){
		Node current = head;
		while(current != null){
			if(current.value.equals(value))
				return true;
			else
				current = current.getNextNode();			
		}		
		return false;
	}
	
	/**
	 * Method returns size of our list.
	 * @return
	 */
	public int getSize(){
		Node current = head;
		int counter = 0;
		while(current != null){
			counter ++;
			current = current.getNextNode();
		}
		return counter;
	}
	
	/**
	 * Method returns our list as array. NOT WORKING
	 * @return
	 */
	public T[] toArray(){
		Node current = head;
		int idx = 0;
		T[] array  = (T[]) new Object[getSize()];
		
		while(current != null){
			array[idx] = (T) current.getValue();
			current = current.getNextNode();
			idx++;			
		}
		return array;
	}

	@Override
	public Iterator<T> iterator() {
		return new Biterator<T>(head) ;
	}
	
	
	/**
	 * Node generic class, that creates our objects.
	 * @author vedadzornic
	 *
	 * @param <T>
	 */
	public class Node<T>{
		private T value;
		private Node nextNode;
		
		public Node(T value){
			this.value = value;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		public T getValue() {
			return value;
		}
		public String toString(){
			return ""+value;
		}
			
		
	}

	/**
	 * Private class, our own iterator class.
	 * @author vedadzornic
	 *
	 * @param <T>
	 */
	private class Biterator<T> implements Iterator<T>{
		private Node<T> current;
		
		public Biterator(Node start){
			current = start;	
		}
		
		@Override
		public boolean hasNext() {
			if(current != null)
				return true;
			return false;
		}

		@Override
		public T next() {
			T value = current.value;
			current = current.nextNode;
			return value;			
		}
		
	}
	
}

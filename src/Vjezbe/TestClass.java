package Vjezbe;

import java.util.Iterator;
import java.util.LinkedList;

public class TestClass {
	public static void main(String[] args) {
		LinkedListB<Integer> intList = new LinkedListB<Integer>();
		intList.add(0);
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(4);
	
		Iterator<Integer> benjo = intList.iterator();		
		while(benjo.hasNext())
			System.out.println(benjo.next());
		
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		Iterator<Integer> benjo2 = list.iterator();
		while(benjo2.hasNext())
			System.out.println(benjo2.next());
	}
}	

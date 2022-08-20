package com.queue.demo;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
	
	public static void main(String args[]) {
		
		 PriorityQueue<String> pq = new PriorityQueue<>();
		 
	        pq.add("Coding");
	        pq.add("Env");
	        pq.add("Youtube");
	 
	        System.out.println(pq);
	        
	        pq.remove("Env");
	        
	        System.out.println("After Remove - " + pq);
	        
	        System.out.println("Poll Method - " + pq.poll());
	        
	        System.out.println("After Poll - " + pq);
	        
	        pq.clear();
	        
	        System.out.println("After clear call - " + pq);
	        
	        pq.add("Coding");
	        pq.add("Env");
	        pq.add("Youtube");
	 
	        System.out.println("After clear call - " + pq);
	        
	        String element = pq.peek();
	        System.out.println("Accessed Element: " + element);
	        
	        

	        Iterator iterator = pq.iterator();
	 
	        while (iterator.hasNext()) {
	            System.out.print(iterator.next() + " ");
	        }
	}

}

package com.queue.demo;

public class CircularQueueDemo {
	  int SIZE; // Size of Circular Queue
	  int front, rear;
	  int items[];

	  CircularQueueDemo(int size) {
	    front = -1;
	    rear = -1;
	    this.SIZE = size;
	    this.items = new int[size];
	  }

	  // Check if the queue is full
	  boolean isFull() {
	    if (front == 0 && rear == SIZE - 1) {
	      return true;
	    }
	    if (front == rear + 1) {
	      return true;
	    }
	    return false;
	  }

	  // Check if the queue is empty
	  boolean isEmpty() {
	    if (front == -1)
	      return true;
	    else
	      return false;
	  }

	  // Adding an element
	  void enQueue(int element) {
	    if (isFull()) {
	      System.out.println("Queue is full");
	    } else {
	      if (front == -1)
	        front = 0;
	      rear = (rear + 1) % SIZE;
	      items[rear] = element;
	      System.out.println("Inserted " + element);
	    }
	  }

	  // Removing an element
	  int deQueue() {
	    int element;
	    if (isEmpty()) {
	      System.out.println("Queue is empty");
	      return (-1);
	    } else {
	      element = items[front];
	      if (front == rear) {
	        front = -1;
	        rear = -1;
	      } 
	      else {
	        front = (front + 1) % SIZE;
	      }
	      return (element);
	    }
	  }

	  void display() {
	    /* Function to display status of Circular Queue */
	    int i;
	    if (isEmpty()) {
	      System.out.println("Empty Queue");
	    } else {
	      System.out.print("Items -> ");
	      for (i = front; i != rear; i = (i + 1) % SIZE)
	      {
	        System.out.print(items[i] + " ");
	      }
	      System.out.println(items[i]);
	    }
	  }

	  public static void main(String[] args) {

	    CircularQueueDemo q = new CircularQueueDemo(8);

	    // Fails because front = -1
	    q.deQueue();

	    q.enQueue(1);
	    q.enQueue(2);
	    q.enQueue(3);
	    q.enQueue(4);
	    q.enQueue(5);
	    q.enQueue(6);
	    q.enQueue(7);
	    q.enQueue(8);
	    
	    q.enQueue(9); // Will fail to enqueue as size is full.

	    q.display();

	    int elem = q.deQueue();

	    if (elem != -1) {
	      System.out.println("Deleted Element is " + elem);
	    }
	    q.display();

	    q.enQueue(10);

	    q.display();

	    // Fails to enqueue because front == rear + 1
	    q.enQueue(11);
	  }
}
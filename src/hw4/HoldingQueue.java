//Halice Sachin Falcao
//115437214
//R-01

package hw4;

import java.util.LinkedList;
/**
 * Represents a holding queue that extends the VirtualLine class and implements queue operations.
 */

public class HoldingQueue extends VirtualLine {
   
	
	private int maxSize; // Maximum size of the holding queue
	
	/**
     * Constructs a HoldingQueue object with the specified maximum size.
     * @param maxSize The maximum size of the holding queue.
     */
    
    public HoldingQueue(int maxSize) {
      
        this.maxSize = maxSize;
    }
    /**
     * Removes and returns the first person in the holding queue.
     * @return The first person in the queue, or null if the queue is empty.
     */
   
    public Person dequeue() {
    	
    	return super.dequeue();
    	}
   
    /**
     * Adds a person to the holding queue if there is space available.
     * If the queue is full, prints "Out of slots!!!".
     * @param p The person to be added to the queue.
     */
    public void enqueue(Person p) {
        if (size() < maxSize) {
            super.enqueue(p);
        } else {
            System.out.println("Out of slots!!!");
        }
    }
    
    /**
     * Checks if the holding queue is full.
     * @return True if the queue is full, false otherwise.
     */
   public boolean isFull() {
        return this.size() == maxSize;
    }
   
   /**
    * Gets the maximum size of the holding queue.
    * @return The maximum size of the queue.
    */
    
    public int getMaxSize() {
        return maxSize;
    }

    /**
     * Sets the maximum size of the holding queue.
     * @param maxSize The new maximum size of the queue.
     */
    public void setMaxSize(int maxSize) {
    	this.maxSize = maxSize;
    	}
    
    /**
     * Checks if the holding queue is empty.
     * @return True if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
    	
    	return super.isEmpty();
    	}
    
    /**
     * Generates a string representation of the HoldingQueue object.
     * @return A string containing information about the holding queue.
     */
    @Override
   	public String toString() {
   		return "HoldingQueue [maxSize=" + maxSize + "]";
   	}
}



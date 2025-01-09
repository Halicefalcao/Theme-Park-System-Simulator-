//Halice Sachin Falcao
//115437214
//R-01

package hw4;

import java.util.LinkedList;
/**
 * Represents a virtual queue (line) implemented as a linked list of people.
 * Allows enqueueing, dequeuing, peeking at the front person, and checking if the queue is empty.
 */
public class VirtualLine extends LinkedList<Person> {


    /**
     * Adds a person to the end of the virtual line.
     *
     * @param p The person to enqueue.
     */
	public void enqueue(Person p) {
		add(p);
	}

	/**
     * Removes and returns the person at the front of the virtual line.
     *
     * @return The dequeued person, or null if the line is empty.
     */
	public Person dequeue() {
		if (!isEmpty()) {
			return remove();
		} else {
			return null;
		}
	}
	
	/**
     * Retrieves the person at the front of the virtual line without removing them.
     *
     * @return The person at the front, or null if the line is empty.
     */

	public Person peek() {
		if (!isEmpty()) {
			return peek();
		} else {
			return null;
		}
	}
//Checks if the virtualLine is empty
	public boolean isEmpty() {
    	
    	return super.isEmpty();
    	}
	/**
     * Gets the size of the queue.
     *
     * @return The size of the queue.
     */
	public int getSize() {
		return size();
	}
	
	/**
     * Gets the queue itself.
     *
     * @return The LinkedList representing the queue of Person objects.
     */
	 public LinkedList<Person> getQueue() {
	        return this;
	    }
	


}

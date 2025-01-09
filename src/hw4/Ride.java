//Halice Sachin Falcao
//115437214
//R-01

package hw4;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a ride in an amusement park with a virtual line, holding queue,
 * and people on the ride.
 */
public class Ride {
	private int duration; // How many time steps the ride takes up.
	private int timeLeft; // How many minutes are left until the end of the ride cycle.
	private String name; // The name of the ride; used for printing
	private int capacity; // Capacity of the ride
	private int maxHoldingSize; // Max size for the holding queue
	private VirtualLine virtualLine; // The Queue of people waiting for the ride.
	private HoldingQueue holdingQueue; // The Queue of people who are next for the ride.
	private List<Person> peopleOnRide; // People on the ride
	private int count;

	/**
	 * Default constructor.
	 *
	 * @param name The name of the ride.
	 */
	public Ride(String name, int duration) {
		this.name = name;
		this.virtualLine = new VirtualLine();
		this.holdingQueue = new HoldingQueue(maxHoldingSize);
		this.duration = duration;
		this.timeLeft = duration;
	}

	/**
	 * Parameterized constructor.
	 *
	 * @param duration       The duration of the ride in minutes.
	 * @param name           The name of the ride.
	 * @param capacity       The capacity of the ride.
	 * @param maxHoldingSize The maximum size of the holding queue.
	 */
	public Ride(int duration, String name, int capacity, int maxHoldingQueueSize) {
		this.duration = duration;
		this.name = name;
		this.capacity = capacity;

		this.maxHoldingSize = maxHoldingQueueSize;
		this.timeLeft = duration;
		this.virtualLine = new VirtualLine();
		this.holdingQueue = new HoldingQueue(maxHoldingSize);
		this.peopleOnRide = new LinkedList<Person>();
	}

	public void decrementTime() {
		if (timeLeft > 0) {
			timeLeft--;
		}
	}

	/**
	 * Adds a person to the holding queue for the ride.
	 *
	 * @param person The person to be added to the holding queue.
	 */
	public void enqueueHoldingQueue(Person person) {
		this.holdingQueue.enqueue(person);
	}

	/**
	 * Starts the ride by moving people from the holding queue to the ride until
	 * capacity is reached.
	 */
	public void startRide() {
		while (!this.holdingQueue.isEmpty() && this.peopleOnRide.size() < this.capacity) {
			Person person = this.holdingQueue.dequeue();
			this.peopleOnRide.add(person);
			person.setStatus(Status.OnRide);
		}
		this.timeLeft = this.duration; // Reset the time left for the ride
	}

	/**
	 * Gets the duration of the ride.
	 * 
	 * @return The duration of the ride in minutes.
	 */

	public int getDuration() {
		return duration;
	}

	/**
	 * Sets the duration of the ride.
	 * 
	 * @param duration The new duration of the ride in minutes.
	 */

	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * Gets the name of the ride.
	 * 
	 * @return The name of the ride.
	 */

	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the ride.
	 * 
	 * @param name The new name of the ride.
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the capacity of the ride.
	 * 
	 * @return The capacity of the ride.
	 */

	public int getCapacity() {
		return capacity;
	}

	/**
	 * Sets the capacity of the ride.
	 * 
	 * @param capacity The new capacity of the ride.
	 */

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Gets the maximum size of the holding queue.
	 * 
	 * @return The maximum size of the holding queue.
	 */

	public int getMaxHoldingSize() {
		return maxHoldingSize;
	}

	/**
	 * Sets the maximum size of the holding queue.
	 * 
	 * @param maxHoldingSize The new maximum size of the holding queue.
	 */

	public void setMaxHoldingSize(int maxHoldingSize) {
		this.maxHoldingSize = maxHoldingSize;
	}

	/**
	 * Gets the time left for the ride.
	 * 
	 * @return The time left for the ride in minutes.
	 */

	public int getTimeLeft() {
		return timeLeft;
	}

	/**
	 * Sets the time left for the ride.
	 * 
	 * @param time The new time left for the ride in minutes.
	 */

	public void setTimeLeft(int time) {
		timeLeft = time;
	}

	/**
	 * Gets the count of people on the ride.
	 *
	 * @return The count of people on the ride.
	 */

	public int getCount() {
		return count;
	}

	/**
	 * Increments the count of people on the ride.
	 */

	public void incCount() {
		count++;
	}

	/**
	 * Gets the virtual line queue of the ride.
	 * 
	 * @return The virtual line queue of the ride.
	 */
	public VirtualLine getVirtualLine() {
		return virtualLine;
	}

	/**
	 * Gets the holding queue of the ride.
	 * 
	 * @return The holding queue of the ride.
	 */

	public HoldingQueue getHoldingQueue() {
		return holdingQueue;
	}

	/**
	 * Gets the list of people currently on the ride.
	 * 
	 * @return The list of people currently on the ride.
	 */

	public List<Person> getPeopleOnRide() {
		return peopleOnRide;
	}

	/**
	 * Sets the virtual line queue of the ride.
	 * 
	 * @param Line The new virtual line queue of the ride.
	 */

	public void setVirtualLine(VirtualLine Line) {
		this.virtualLine = Line;
	}

	/**
	 * Sets the holding queue of the ride.
	 * 
	 * @param HQ The new holding queue of the ride.
	 */

	public void setHoldingQueue(HoldingQueue HQ) {
		this.holdingQueue = HQ;
	}

	/**
	 * Sets the list of people currently on the ride.
	 * 
	 * @param POR The new list of people currently on the ride.
	 */

	public void setPeopleOnRide(List<Person> POR) {
		this.peopleOnRide = POR;
	}

	/**
	 * Adds a person to the virtual line queue.
	 * 
	 * @param p The person to be added to the virtual line queue.
	 */

	public void enqueueToVirtualLine(Person p) {
		virtualLine.enqueue(p);
	}

	/**
	 * Removes and returns a person from the virtual line queue.
	 * 
	 * @return The removed person from the virtual line queue.
	 */

	public Person dequeueToVirtualLine() {
		return virtualLine.dequeue();
	}

	/**
	 * Adds a person to the holding queue of the ride.
	 * 
	 * @param p The person to be added to the holding queue.
	 */

	public void enqueueToHoldingQueue(Person p) {
		holdingQueue.enqueue(p);
	}

	/**
	 * Removes and returns a person from the holding queue of the ride.
	 * 
	 * @return The removed person from the holding queue.
	 */

	public Person dequeueToHoldingQueue() {
		return holdingQueue.dequeue();
	}

	/**
	 * Adds a person to the ride if there is space available. If the ride is full,
	 * prints "Ride full!".
	 * 
	 * @param p The person to be added to the ride.
	 */

	public void enqueueToRide(Person p) {
		if (peopleOnRide.size() <= capacity) {
			peopleOnRide.add(p);
			p.setStatus(Status.OnRide);
		} else
			System.out.println("Ride full!");
	}

	/**
	 * Removes a person from the ride.
	 *
	 * @return The removed Person, or null if the ride is empty.
	 */

	public Person dequeueToRide() {
		if (!peopleOnRide.isEmpty()) {
			Person p = peopleOnRide.remove(0);
			p.setStatus(Status.Available);
			return p;
		} else {
			System.out.println("Ride empty!");
			return null;
		}
	}

	/**
	 * Prints the current state of the ride including time remaining, people on the
	 * ride, holding queue, and virtual queue.
	 *
	 * @param time The current time step.
	 */

	public void print(int time) {
		System.out.println(name);
		System.out.println("-----------");
		System.out.print("\n");
		System.out.println("Time remaining: " + duration + " min");

		// Simulate customers on ride
		System.out.print("On Ride: ");
		for (Person p : this.peopleOnRide) {
		
			System.out.print(p.getCustomerType() + " " + p.getNumber() + ", ");
		}
		System.out.println();

		// Simulate holding queue
		System.out.print("Holding Queue: ");
		for (Person p1 : holdingQueue.getQueue()) {
			System.out.print(p1.getCustomerType() + " " + p1.getNumber() + ", ");
		}
		System.out.println();

		// Simulate virtual queue
		System.out.print("Virtual Queue: ");
		for (Person p3 : virtualLine.getQueue()) {
			System.out.print(p3.getCustomerType() + " " + p3.getNumber() + ", ");
		}
		System.out.println("\n");
	}

}
//Halice Sachin Falcao
//115437214
//R-01

package hw4;
import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;
/**
 * This class simulates a theme park called Seven Flags with different types of customers and rides.
 */
public class SevenFlags {
	private static Ride BSOD;//Represents the Blue Scream of Death (BSOD) ride.
	private static Ride KK;//Represents the Kingda Knuth (KK) ride.
	private static Ride TOT;//Represents the i386 Tower of Terror (TOT) ride.
	private static Ride GF;//Represents the GeForce (GF) ride.

	private static int Rnum;// Number of regular customers
	private static int Snum;// Number of silver customers
	private static int Gnum;// Number of gold customers
	private static int Length;// Simulation length

	public static ArrayList<Person> Gold;// List of gold customers
	public static ArrayList<Person> Silver;// List of silver customers
	public static ArrayList<Person> Regular;// List of regular customers

	public static double regularCnt;// Count of rides for regular customers
	public static double silverCnt;// Count of rides for silver customers
	public static double goldCnt;// Count of rides for silver customers
	
	 /**
     * The main method that runs the simulation for Seven Flags.
     * @param args Command-line arguments (not used in this program)
     */
	public static void main(String[] args) {
		System.out.println("Welcome to Seven Flags!");
		Scanner input = new Scanner(System.in);

		// Initialization of customers

		System.out.print("Please enter the number of regular customers: ");
		Rnum = input.nextInt();

		System.out.print("Please enter the number of silver customers: ");
		Snum = input.nextInt();

		System.out.print("Please enter the number of gold customers: ");
		Gnum = input.nextInt();

		System.out.print("Please enter simulation length: ");
		Length = input.nextInt();

		// Initialization of Rides

		System.out.print("\nPlease enter the duration of Blue Scream of Death (minutes): ");
		int duration = input.nextInt();
		System.out.print("Please enter the capacity of Blue Scream of Death: ");
		int capacity = input.nextInt();
		System.out.print("Please enter the holding queue size for Blue Scream of Death: ");
		int holdingQueueSize = input.nextInt();
		BSOD = new Ride(duration, "Blue Scream of Death", capacity, holdingQueueSize);

		System.out.print("\nPlease enter the duration of Kingda Knuth (minutes): ");
		duration = input.nextInt();
		System.out.print("Please enter the capacity of Kingda Knuth: ");
		capacity = input.nextInt();
		System.out.print("Please enter the holding queue size for Kingda Knuth: ");
		holdingQueueSize = input.nextInt();
		KK = new Ride(duration, "Kingda Knuth", capacity, holdingQueueSize);

		System.out.print("\nPlease enter the duration of i386 Tower of Terror (minutes): ");
		duration = input.nextInt();
		System.out.print("Please enter the capacity of i386 Tower of Terror: ");
		capacity = input.nextInt();
		System.out.print("Please enter the holding queue size for i386 Tower of Terror: ");
		holdingQueueSize = input.nextInt();
		TOT = new Ride(duration, "i386 Tower of Terror", capacity, holdingQueueSize);

		System.out.print("\nPlease enter the duration of GeForce (minutes): ");
		duration = input.nextInt();
		System.out.print("Please enter the capacity of GeForce: ");
		capacity = input.nextInt();
		System.out.print("Please enter the holding queue size for GeForce: ");
		holdingQueueSize = input.nextInt();
		GF = new Ride(duration, "GeForce", capacity, holdingQueueSize);

		// Simulation
		Ride[] rides = { BSOD, KK, TOT, GF };
		// Assign the Gold customers their first, second, and third rides

		Gold = new ArrayList<Person>(); // Initialize the ArrayList

		for (int i = 0; i < Gnum; i++) {
			// Add the customers in the list to print them later.
			Gold.add(new Person(i + 1));
			Gold.get(i).setMaxLines(3);
			Gold.get(i).setStatus(Status.Available);
			Gold.get(i).setCustomerType("Gold");
		
			// Add the objects to virtualLine Queue.
			Person p = Gold.get(i);
			assignRideinLine(p, rides, "Gold");
			

		}

		// Assign the Silver customers their first, second, and third rides

		Silver = new ArrayList<Person>(); // Initialize the ArrayList
		for (int i = 0; i < Snum; i++) {
			// Add the customers in the list to print them later.
			Silver.add(new Person(i + 1));
			Silver.get(i).setMaxLines(2);
			Silver.get(i).setStatus(Status.Available);
			Silver.get(i).setCustomerType("Silver");
			Person p = Silver.get(i);
			assignRideinLine(p, rides, "Silver");
			

		}

		// Assign the Regular customers their first, second, and third rides

		Regular = new ArrayList<Person>();// Initialize the ArrayList

		for (int i = 0; i < Rnum; i++) {
			// Add the customers in the list to print them later.
			Regular.add(new Person(i + 1));
			Regular.get(i).setMaxLines(1);
			Regular.get(i).setStatus(Status.Available);
			Regular.get(i).setCustomerType("Regular");
			Person p = Regular.get(i);
			assignRideinLine(p, rides, "Regular");
		}
		// Add the objects to virtualLine Queue.
		/*for (int j = 0; j < Rnum; j++) {
			Person p = new Person(j + 1);
			p.setCustomerType("Regular");

			assignRideinLine(p, rides, "Regular");
			// Ride r = assignRide(p, rides);

		}*/
	

		for (Ride ride : rides) {
			ride.decrementTime();
			if (ride.getTimeLeft() <= 0) {
				// The ride is over
				for (Person person : ride.getPeopleOnRide()) {
					// System.out.println("checkpoint 1");
					person.setStatus(Status.Available);
					assignRide(person, rides);
				}
				ride.getPeopleOnRide().clear();

			}

			// Dequeue new riders from the ride's holding queue
			while (!ride.getHoldingQueue().isEmpty() && ride.getPeopleOnRide().size() < ride.getCapacity()) {
				// System.out.println("checkpoint 2");
				Person person = ride.getHoldingQueue().dequeue();
				person.setStatus(Status.OnRide);
				ride.getPeopleOnRide().add(person);
			}

			int count = 0;
			// dequeue riders from the Virtual Line
			while (!ride.getVirtualLine().isEmpty() && !ride.getHoldingQueue().isFull()) {
				// System.out.println("checkpoint 3");

				Person person = ride.getVirtualLine().dequeue();
				if (person.getStatus() == Status.Available) {
					// System.out.println("checkpoint 4");
					ride.getHoldingQueue().enqueue(person);
					person.setStatus(Status.Holding);
				} else if((person.getStatus() == Status.OnRide)||(person.getStatus() == Status.Holding)){
					ride.getVirtualLine().enqueue(person);
				}
				else {
					// System.out.println("checkpoint 5");
					ride.getVirtualLine().enqueue(person);
					count++;
					if (count >= ride.getVirtualLine().size()) {
						break;
					}
				}
			}

		}
//Looping till time= 20
		for (int i = 0; i <= Length; i++) {
			 System.out.println("At Time " + i + ":\n");
			for (Ride ride : rides) {
	            ride.decrementTime();
	            if (ride.getTimeLeft() == 0) {
	                for (Person person : ride.getPeopleOnRide()) {
	                    person.setStatus(Status.Available);
		                if(person.getCustomerType().equals("Gold")) {
		                	goldCnt++;
		                	ride.incCount();
		                }else if(person.getCustomerType().equals("Silver")) {
		                	silverCnt++;
		                	ride.incCount();
		                }else {
		                	regularCnt++;
		                	ride.incCount();
		                }
	                    assignRideinLine(person, rides, person.getCustomerType());
	                }
	                ride.getPeopleOnRide().clear();
	                ride.startRide();
	            }

	            while (!ride.getHoldingQueue().isEmpty() && ride.getPeopleOnRide().size() < ride.getCapacity()) {
	                Person person = ride.getHoldingQueue().dequeue();
	                person.setStatus(Status.OnRide);
	                ride.getPeopleOnRide().add(person);

	            }

	            int count = 0;
	            while (!ride.getVirtualLine().isEmpty() && !ride.getHoldingQueue().isFull()) {
	                Person person = ride.getVirtualLine().dequeue();
	                if (person.getStatus() == Status.Available) {
	                    ride.getHoldingQueue().enqueue(person);
	                    person.setStatus(Status.Holding);
	                } else {
	                    ride.getVirtualLine().enqueue(person);
	                    count++;
	                    if (count >= ride.getVirtualLine().size()) {
	                        break;
	                    }
	                }
	            }
	            
				ride.print(i);
			}
			printCustomers(rides);
		}
		
		System.out.println("..........At the end of the simulation............");
		System.out.println("\nOn average, Gold customers have taken " + String.format("%.2f",(double)(goldCnt / Gnum)) + " rides.");
		System.out.println("\nOn average, Silver customers have taken " + String.format("%.2f", (double)(silverCnt /Snum)) + " rides.");
		System.out.println("\nOn average, regular customers have taken " + String.format("%.2f", (double)(regularCnt / Rnum)) + " rides.\n");
		System.out.println("BSOD has completed rides for " + (BSOD.getCount())+" people.");
		System.out.println("KK has completed rides for " + (KK.getCount())+" people.");
		System.out.println("ToT has completed rides for " + (TOT.getCount())+" people.");
		System.out.println("GF has completed rides for " + (GF.getCount())+" people.");


	}
	/**
	 * Prints information about customers and their assigned ride lines.
	 *
	 * @param rides An array of available rides.
	 */

	private static void printCustomers(Ride[] rides) {

		System.out.print("\nRegular Customers: \n\n");
		System.out.print("Num  Line  Status\n");
		System.out.print("------------------------------------------\n");
		for (int i = 0; i < Rnum; i++) {
			System.out.print(Regular.get(i).getNumber() + ".  ");
			Regular.get(i).printLines();
			System.out.print(":"+Regular.get(i).getStatus() + "\n");
		}

		System.out.print("\nSilver Customers: \n\n");
		System.out.print("Num  Line1  Line 2  Status\n");
		System.out.print("------------------------------------------\n");
		for (int i = 0; i < Snum; i++) {
			System.out.print(Silver.get(i).getNumber() + ".  ");
			Silver.get(i).printLines();
			System.out.print(":"+Silver.get(i).getStatus() + "\n");
		}

		System.out.print("\nGold Customers: \n\n");
		System.out.print("Num  Line 1  Line 2  Line 3  Status\n");
		System.out.print("------------------------------------------\n");
		for (int i = 0; i < Gnum; i++) {
			System.out.print(Gold.get(i).getNumber() + ".  ");
			Gold.get(i).printLines();
			System.out.print(":"+Gold.get(i).getStatus() + "\n");
		}

		System.out.print("------------------------------------------\n");

	}
	/**
	 * Randomly assigns a ride to a person.
	 *
	 * @param p     The person to assign a ride to.
	 * @param rides An array of available rides.
	 * @return The assigned ride.
	 */

	private static Ride assignRide(Person p, Ride[] rides) {
		// Will randomly assign rides to customers

		int index = new Random().nextInt(rides.length);
		Ride ride = rides[index];

		ride.enqueueToVirtualLine(p);
//		p.getLines().add(ride);

		return ride;

	}
	/**
	 * Assigns a person to ride lines based on their membership type (Gold, Silver, or Regular).
	 *
	 * @param p     The person to assign to ride lines.
	 * @param rides An array of available rides.
	 * @param type  The membership type (Gold, Silver, or Regular).
	 */
	private static void assignRideinLine(Person p, Ride[] rides, String type) {
		if (type.equals("Gold")) {				
				for (int j = 0; j < 3; j++) {
					int i1 = new Random().nextInt(rides.length);
					Ride r = rides[i1];
					r.getVirtualLine().enqueue(p);
					p.getLines()[j] = r;
				}
			}
		
		
		if (type.equals("Silver")) {
			
				for (int j = 0; j < 2; j++) {
					int i2 = new Random().nextInt(rides.length);
					Ride r1 = rides[i2];
					r1.getVirtualLine().enqueue(p);
					p.getLines()[j] = r1;
				}
			}
		

		if (type.equals("Regular")) {
				int i3 = new Random().nextInt(rides.length);
				Ride r2 = rides[i3];
				r2.getVirtualLine().enqueue(p);
				p.getLines()[0] = r2;

			}
		}
	
}

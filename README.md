Theme Park System Simulator

Description:
The Theme Park System Simulator is a simulation tool designed for a computer science-themed amusement park named "7 Flags" with 4 rides Blue Scream of Death (BSOD), i386 Tower of Terror (ToT), GeForce (GF) and Kingda Knuth (KK). The simulator models a queue management system that enhances visitor experience by introducing the "Virtual Line" system. This system allows visitors to join virtual and holding queues for rides, making waiting times more manageable and enabling them to enjoy other activities at the park.
The project implements features like virtual queues, holding queues, and priority handling for premium customers (Silver and Gold plans), ensuring efficient ride allocation and a seamless experience.

Features:
Virtual queue system for park rides like:
Kingda Knuth
Blue Scream of Death
i386 Tower of Terror
GeForce
Holding queue management for customers notified to show up in person.
Ride assignment for Regular, Silver, and Gold customers, with different queue priorities:
Regular: 1 queue.
Silver: Up to 2 queues.
Gold: Up to 3 queues.
Simulation of ride cycles, customer behavior, and queue dynamics.
Customizable simulation parameters for ride duration, queue sizes, and customer distribution.
Randomized ride selection for customers upon availability.

Technologies Used:
Programming Language: Java
Development Environment: Eclipse IDE
Java Collections: LinkedList for queue management.

Setup and Installation:
1.Clone the repository: git clone https://github.com/Halicefalcao/Theme-Park-System-Simulator-.git
2.Open the project in Eclipse IDE:  
     * Navigate to File > Open Projects from File System.
     * Select the directory /path/to/cloned/repository.
3.Build and compile the project in Eclipse.
4.Run the SevenFlags driver class to start the simulation.

How to Use:
1.Input the number of customers (Regular, Silver, and Gold) and customize ride and queue parameters as prompted.
2.The program will simulate:
  Queue and ride assignments.
  Virtual and holding queue dynamics.
  Ride cycles, customer availability, and status updates.
3.View the simulation output for a minute-by-minute breakdown of ride operations and queue status.


Project Classes:
1. Status
   Enum defining customer statuses:
     * Available
     * Holding
     * OnRide
2. Person
   Represents a customer in the park with:
     * Unique ID.
     * Maximum number of queues they can join (Regular, Silver, or Gold).
     * Current status and associated rides.
3. VirtualLine
   A queue implementation for managing the virtual line for each ride.
4. HoldingQueue
   A queue with a fixed capacity for customers notified to physically arrive for the ride.
5. Ride
   Represents each park ride with:
   * Ride duration.
   * Virtual and holding queues.
   * Current customers on the ride.
6. SevenFlags
   The driver class that orchestrates the entire simulation.
7. RandomGenerator
   A utility for random ride selection.

License:
This project does not currently have a license.
By default, all rights are reserved, and no permission is granted to use, modify, or distribute this code without explicit authorization from the repository owner.

   

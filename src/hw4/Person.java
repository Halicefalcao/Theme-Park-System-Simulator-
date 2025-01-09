//Halice Sachin Falcao
//115437214
//R-01


package hw4;

import java.util.ArrayList;
import java.util.List;

public class Person {
   
	
	private int number;//The number of the person
    private int maxLines; // The maximum number of lines the Person can be on.
    private Ride[] lines; // Holds an instance of each ride the person is on.
    private Status Status; // Current status
    private String customerType;//Contains the customer type
  
  
    /**
     * Default constructor of the Person class.
     *
     * @param number The number of the person.
     * @throws IllegalArgumentException if the number is not positive.
     */
    public Person(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Wrong value!");
        } else {
            this.number = number;
            this.Status = Status.Available; //Default value of status
        }
    }
    /**
     * Gets the number associated with this object.
     * @return The number associated with this object.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the number associated with this object.
     * @param number The new number to be set.
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Gets the maximum number of lines.
     * @return The maximum number of lines.
     */
    public int getMaxLines() {
        return maxLines;
    }

    /**
     * Sets the maximum number of lines and initializes the lines array accordingly.
     * @param maxLines The new maximum number of lines.
     */
    public void setMaxLines(int maxLines) {
        this.maxLines = maxLines;
        this.lines = new Ride[maxLines];
        
    }

    /**
     * Sets the lines array to the specified array of Ride objects.
     * @param lines The array of Ride objects to set as the lines array.
     */
    public void setLines(Ride[] lines){
        this.lines = lines;
    }


    /**
     * Sets the Ride object at the specified index in the lines array.
     * @param i The index where the Ride object should be set.
     * @param ride The Ride object to set at the specified index.
     */
    public void setLinesIndex(int i, Ride ride){
        lines[i] = ride;
    }

    /**
     * Gets the lines array containing Ride objects.
     * @return The lines array containing Ride objects.
     */
    public Ride[] getLines() {
    	return lines;
    }
    
    /**
     * Gets the status of this object.
     * @return The status of this object.
     */
    public Status getStatus() {
        return Status;
    }

    /**
     * Sets the status of this object.
     * @param status The new status to be set.
     */
    public void setStatus(Status status) {
        this.Status = status;
    }
    
    /**
     * Generates a string representation of this object.
     * @return A string representation of this object.
     */
    public String toString() {
        return number + ". " + lines + Status;
    }
    

/**
 * Gets the customer type associated with this object.
 * @return The customer type associated with this object.
 */
    public String getCustomerType() {
  		return customerType;
  	}

    /**
     * Sets the customer type for this customer manager.
     *
     * @param ct The customer type to set.
     */
  	public void setCustomerType(String ct) {
  		this.customerType = ct;
  	}
  
  	/**
     * Prints the names of customers in the lines.
     */
  	public void printLines(){
        for(int i = 0; i < lines.length; i++){
            System.out.print(lines[i].getName() + "  ");
        }
    }

}

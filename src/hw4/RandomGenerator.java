//Halice Sachin Falcao
//115437214
//R-01

package hw4;

public class RandomGenerator {
	/**
     * Selects a random ride from the given array of rides.
     *
     * @param rides An array of rides.
     * @return A randomly selected ride from the array.
     */
	public static Ride selectRide(Ride[] rides)
	{
	int totalRides=rides.length;
	int selectedRide=(int)(Math.random()*totalRides);
	return rides[selectedRide];
	}
}

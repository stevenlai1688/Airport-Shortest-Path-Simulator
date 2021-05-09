// --== CS400 File Header Information ==--
// Name: Andrew Aquino
// Email: aoaquino@wisc.edu
// Team: HG Red
// Role: Data Wrangler
// TA: Hang Yin
// Lecturer: Gary Dahl
// Notes to Grader: NONE

public class FlightPath implements FlightPathInterface {

	private String airport1;
	private String airport2;
	private int flightTime;
	private int flightPrice;
	
	/**
	 * Creates a new FlightPath object with the two airports, flight time, and flight price.
	 * 
	 * @param airport1 Name of first airport.
	 * @param airport2 Name of second airport.
	 * @param flightTime time of flight.
	 * @param flightPrice price of flight.
	 */
	public FlightPath(String airport1, String airport2, int flightTime, int flightPrice) {
		this.airport1 = airport1;
		this.airport2 = airport2;
		this.flightTime = flightTime;
		this.flightPrice = flightPrice;
	}
	
	/**
	 * Gets time of this flight.
	 * 
	 * @return flight time
	 */
	@Override
	public int getFlightTime() {
		return flightTime;
	}

	/**
	 * Gets price of this flight.
	 * 
	 * @return flight price
	 */
	@Override
	public int getFlightPrice() {
		return flightPrice;
	}

	/**
	 * Gets first airport.
	 * 
	 * @return first airport
	 */
	@Override
	public String getLocation1() {
		return this.airport1;
	}

	/**
	 * Gets second airport.
	 * 
	 * @return seconod airport
	 */
	@Override
	public String getLocation2() {
		return airport2;
	}

}

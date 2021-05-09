// --== CS400 File Header Information ==--
// Name: Andrew Aquino
// Email: aoaquino@wisc.edu
// Team: HG Red
// Role: Data Wrangler
// TA: Hang Yin
// Lecturer: Gary Dahl
// Notes to Grader: NONE

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataWranglerDeveloperTester {

	private FlightData flights;
	
	@BeforeEach
	public void setup() {
		flights = new FlightData();
	}
	
	/**
	 * Tests the correctness of flight O'Hare to Seattle.
	 */
	@Test
	public void testORDSEA() {
		assertTrue(flights.flightList.get(0).getLocation1().equals("ORD"));
		assertTrue(flights.flightList.get(0).getLocation2().equals("SEA"));
		assertTrue(flights.flightList.get(0).getFlightTime() == 5);
		assertTrue(flights.flightList.get(0).getFlightPrice() == 200);
	}
	
	/**
	 * Tests the correctness of flight LAX to Honolulu.
	 */
	@Test 
	public void testLAXHNL() {
		assertTrue(flights.flightList.get(21).getLocation1().equals("LAX"));
		assertTrue(flights.flightList.get(21).getLocation2().equals("HNL"));
		assertTrue(flights.flightList.get(21).getFlightTime() == 6);
		assertTrue(flights.flightList.get(21).getFlightPrice() == 450);
	}
	
	/**
	 * Tests the correctness of flight ATL to JFK.
	 */
	@Test
	public void testDCAJFK() {
		assertTrue(flights.flightList.get(10).getLocation1().equals("ATL"));
		assertTrue(flights.flightList.get(10).getLocation2().equals("JFK"));
		assertTrue(flights.flightList.get(10).getFlightTime() == 2);
		assertTrue(flights.flightList.get(10).getFlightPrice() == 150);
	}
}

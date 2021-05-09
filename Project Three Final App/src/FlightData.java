// --== CS400 File Header Information ==--
// Name: Andrew Aquino
// Email: aoaquino@wisc.edu
// Team: HG Red
// Role: Data Wrangler
// TA: Hang Yin
// Lecturer: Gary Dahl
// Notes to Grader: NONE

import java.util.ArrayList;

public class FlightData {

	// List of all flights
	public ArrayList<FlightPath> flightList;

	// Constructs the flight data and all of the flights and information.
	public FlightData() {
		flightList = new ArrayList<FlightPath>();
		flightList.add(ORDSEA());
		flightList.add(ORDLAX());
		flightList.add(ORDDEN());
		flightList.add(ORDATL());
		flightList.add(ORDDCA());
		flightList.add(ORDJFK());
		flightList.add(ATLDEN());
		flightList.add(ATLDFW());
		flightList.add(ATLMCO());
		flightList.add(ATLDCA());
		flightList.add(ATLJFK());
		flightList.add(MCODFW());
		flightList.add(MCODCA());
		flightList.add(MCOJFK());
		flightList.add(DCAJFK());
		flightList.add(JFKSEA());
		flightList.add(DFWHNL());
		flightList.add(DFWLAX());
		flightList.add(DFWDEN());
		flightList.add(DENLAX());
		flightList.add(DENSEA());
		flightList.add(LAXHNL());
		flightList.add(LAXSEA());
		flightList.add(HNLSEA());
	}

	/**
	 * O'Hare to Seatle flight.
	 * 
	 * @return O'Hare to Seatle flight.
	 */
	private FlightPath ORDSEA() {
		return new FlightPath("ORD", "SEA", 5, 200);
	}

	/**
	 * O'Hare to LAX flight.
	 * 
	 * @return O'Hare to LAX flight.
	 */
	private FlightPath ORDLAX() {
		return new FlightPath("ORD", "LAX", 6, 240);
	}

	/**
	 * O'Hare to Denver flight.
	 * 
	 * @return O'Hare to Denver flight.
	 */
	private FlightPath ORDDEN() {
		return new FlightPath("ORD", "DEN", 3, 120);
	}

	/**
	 * O'Hare to Atlanta flight.
	 * 
	 * @return O'Hare to Atlanta flight.
	 */
	private FlightPath ORDATL() {
		return new FlightPath("ORD", "ATL", 2, 130);
	}

	/**
	 * O'Hare to Ronald Regan flight.
	 * 
	 * @return O'Hare to Ronald Regan flight.
	 */
	private FlightPath ORDDCA() {
		return new FlightPath("ORD", "DCA", 2, 150);
	}

	/**
	 * O'Hare to JFK flight.
	 * 
	 * @return O'Hare to JFK flight.
	 */
	private FlightPath ORDJFK() {
		return new FlightPath("ORD", "JFK", 3, 175);
	}

	/**
	 * Atlanta to Denver flight.
	 * 
	 * @return Atlanta to Denver flight.
	 */
	private FlightPath ATLDEN() {
		return new FlightPath("ATL", "DEN", 4, 250);
	}

	/**
	 * Atlanta to Dallas flight.
	 * 
	 * @return Atlanta to Dallas flight.
	 */
	private FlightPath ATLDFW() {
		return new FlightPath("ATL", "DFW", 2, 125);
	}

	/**
	 * Atlanta to Orlando flight.
	 * 
	 * @return Atlanta to Orlando flight.
	 */
	private FlightPath ATLMCO() {
		return new FlightPath("ATL", "MCO", 3, 145);
	}

	/**
	 * Atlanta to Ronald Regan flight.
	 * 
	 * @return Atlanta to Ronald Regan flight.
	 */
	private FlightPath ATLDCA() {
		return new FlightPath("ATL", "DCA", 1, 275);
	}

	/**
	 * Atlanta to JFK flight.
	 * 
	 * @return Atlanta to JFK flight.
	 */
	private FlightPath ATLJFK() {
		return new FlightPath("ATL", "JFK", 2, 150);
	}

	/**
	 * Orlando to Dallas flight.
	 * 
	 * @return Orlando to Dallas flight.
	 */
	private FlightPath MCODFW() {
		return new FlightPath("MCO", "DFW", 4, 275);
	}

	/**
	 * Orlando to Ronald Regan flight.
	 * 
	 * @return Orlando to Ronald Regan flight.
	 */
	private FlightPath MCODCA() {
		return new FlightPath("MCO", "DCA", 1, 125);
	}

	/**
	 * Orlando to JFK flight.
	 * 
	 * @return Orlando to JFK flight.
	 */
	private FlightPath MCOJFK() {
		return new FlightPath("MCO", "JFK", 3, 155);
	}

	/**
	 * Ronald Regan to JFK flight.
	 * 
	 * @return Ronald Regan to JFK flight.
	 */
	private FlightPath DCAJFK() {
		return new FlightPath("DCA", "JFK", 1, 200);
	}

	/**
	 * JFK to Seattle flight.
	 * 
	 * @return JFK to Seattle flight.
	 */
	private FlightPath JFKSEA() {
		return new FlightPath("JFK", "SEA", 7, 500);
	}

	/**
	 * Dallas to Honolulu flight.
	 * 
	 * @return Dallas to Honolulu flight.
	 */
	private FlightPath DFWHNL() {
		return new FlightPath("DFW", "HNL", 9, 900);
	}

	/**
	 * Dallas to LAX flight.
	 * 
	 * @return Dallas to LAX flight.
	 */
	private FlightPath DFWLAX() {
		return new FlightPath("DFW", "LAX", 5, 175);
	}

	/**
	 * Dallas to Denver flight.
	 * 
	 * @return Dallas to Denver flight.
	 */
	private FlightPath DFWDEN() {
		return new FlightPath("DFW", "DEN", 2, 100);
	}

	/**
	 * Denver to LAX flight.
	 * 
	 * @return Denver to LAX flight.
	 */
	private FlightPath DENLAX() {
		return new FlightPath("DEN", "LAX", 3, 100);
	}

	/**
	 * Denver to Seattle flight.
	 * 
	 * @return Denver to Seattle flight.
	 */
	private FlightPath DENSEA() {
		return new FlightPath("DEN", "SEA", 2, 100);
	}

	/**
	 * LAX to Honolulu flight.
	 * 
	 * @return LAX to Honolulu flight.
	 */
	private FlightPath LAXHNL() {
		return new FlightPath("LAX", "HNL", 6, 450);
	}

	/**
	 * LAX to Seattle flight.
	 * 
	 * @return LAX to Seattle flight.
	 */
	private FlightPath LAXSEA() {
		return new FlightPath("LAX", "SEA", 3, 175);
	}

	/**
	 * Honolulu to Seattle flight.
	 * 
	 * @return Honolulu to Seattle flight.
	 */
	private FlightPath HNLSEA() {
		return new FlightPath("HNL", "SEA", 7, 500);
	}
}

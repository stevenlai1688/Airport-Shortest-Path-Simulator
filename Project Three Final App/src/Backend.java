// --== CS400 File Header Information ==--
// Name: Jerry Yu
// Email: jcyu4@wisc.edu
// Team: Red
// Role: Backend Developer
// TA: Hang Yin
// Lecturer: Gary Dahl
// Notes to Grader: none
import java.util.ArrayList;
import java.util.List;

public class Backend implements BackendInterface {
  public FlightData f = new FlightData();
  // Initialize list to contain flights from data wrangler
  public ArrayList<FlightPath> flights = f.flightList;
  // Graph that will hold airports and cost of flights
  public CS400Graph<String> graphPrice;
  // Graph that will hold airports and length of flights
  public CS400Graph<String> graphTime;

  /**
   * No-Argument Constructor that initializes and fills the two graphs with the data given by the
   * data wrangler
   */
  public Backend() {
    // Instantiate price graph
    graphPrice = new CS400Graph<String>();
    // Instantiate time graph
    graphTime = new CS400Graph<String>();
    // Iterate through list given by Data Wrangler to fill in graphs
    for (int i = 0; i < flights.size(); i++) {
      // Checks if the graph already contains the current airport
      if (!graphPrice.containsVertex(flights.get(i).getLocation1())) {
        // Adds into graph if it doesn't already contain the airport
        graphPrice.insertVertex(flights.get(i).getLocation1());
      }
      // Checks if the graph already contains the current airport
      if (!graphPrice.containsVertex(flights.get(i).getLocation2())) {
        // Adds into graph if it doesn't already contain the airport
        graphPrice.insertVertex(flights.get(i).getLocation2());
      }
      // Inserts the edges into the graph
      graphPrice.insertEdge(flights.get(i).getLocation1(), flights.get(i).getLocation2(),
          flights.get(i).getFlightPrice());
      graphPrice.insertEdge(flights.get(i).getLocation2(), flights.get(i).getLocation1(),
          flights.get(i).getFlightPrice());
      // Checks if the graph already contains the current airport
      if (!graphTime.containsVertex(flights.get(i).getLocation1())) {
        // Adds into graph if it doesn't already contain the airport
        graphTime.insertVertex(flights.get(i).getLocation1());
      }
      // Checks if the graph already contains the current airport
      if (!graphTime.containsVertex(flights.get(i).getLocation2())) {
        // Adds into graph if it doesn't already contain the airport
        graphTime.insertVertex(flights.get(i).getLocation2());
      }
      // Inserts the edges into the graph
      graphTime.insertEdge(flights.get(i).getLocation1(), flights.get(i).getLocation2(),
          flights.get(i).getFlightTime());
      graphTime.insertEdge(flights.get(i).getLocation2(), flights.get(i).getLocation1(),
          flights.get(i).getFlightTime());
    }
  }

  /**
   * This method calls the shortestPath method from the CS400 graph class on the price graph to find
   * the cheapest path from the starting airport to the ending airport
   * 
   * @param start - airport that you are starting at
   * @param end   - airport that you are going to
   * @return the cheapest path from the start to the end
   */
  public List<String> getCheapestPath(String start, String end) {
    return graphPrice.shortestPath(start, end);
  }

  /**
   * This method calls the shortestPath method from the CS400 graph class on the time graph to find
   * the fastest path from the starting airport to the ending airport
   * 
   * @param start - airport that you are starting at
   * @param end   - airport that you are going to\
   * @return the shortest path from the start to the end
   */
  public List<String> getShortestPath(String start, String end) {
    return graphTime.shortestPath(start, end);
  }

  /**
   * This method calls the getPathCost method from the CS400 graph class on the price graph to find
   * the total weight of the cheapest path
   * 
   * @param start - airport that you are starting at
   * @param end   - airport that you are going to
   * @return the total weight of the cheapest path from the start to the end
   */
  public int getCheapestPrice(String start, String end) {
    return graphPrice.getPathCost(start, end);
  }

  /**
   * This method calls the getPathCost method from the CS400 graph class on the time graph to find
   * the total weight of the time path
   * 
   * @param start - airport that you are starting at
   * @param end   - airport that you are going to
   * @return the total weight of the shortest path from the start to the end
   */
  public int getShortestTime(String start, String end) {
    return graphTime.getPathCost(start, end);
  }

  /**
   * This method finds the price of the shortest path
   * 
   * @param start - airport that you are starting at
   * @param end   - airport that you are going to
   * @return the price of the shortest path
   */
  public int getShortestPrice(String start, String end) {
    // Initialize an int to store the price of the whole path
    int price = 0;
    // Iterates through the shortest path
    for (int i = 1; i < graphTime.shortestPath(start, end).size(); i++) {
      // Increments the price with the weight of the edge from the price graph
      price = price + graphPrice.getWeight(graphTime.shortestPath(start, end).get(i - 1),
          graphTime.shortestPath(start, end).get(i));
    }
    return price;
  }

  /**
   * This method finds the amount of time needed for the cheapest path
   * 
   * @param start - airport that you are starting at
   * @param end   - airport that you are going to
   * @return the time of the cheapest path
   */
  public int getCheapestTime(String start, String end) {
    // Initialize an int to store the time of the whole path
    int time = 0;
    // Iterates through the cheapest path
    for (int i = 1; i < graphPrice.shortestPath(start, end).size(); i++) {
      // Increments the time with the weight of the edge from the time graph
      time = time + graphTime.getWeight(graphPrice.shortestPath(start, end).get(i - 1),
          graphPrice.shortestPath(start, end).get(i));
    }
    return time;
  }
}

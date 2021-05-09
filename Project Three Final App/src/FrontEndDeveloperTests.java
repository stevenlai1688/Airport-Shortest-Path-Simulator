// --== CS400 File Header Information ==--\
// Name: Steven Lai
// Email: sylai2@wisc.edu
// Team: red
// Role: Frontend Developer
// TA: Hang Yin
// Lecturer: Gary Dahl
// Notes to Grader: none
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class FrontEndDeveloperTests {
  // create a new frontend object to test
  Frontend f = new Frontend();
  /**
   * Test if the shortest path return between the airports is correct
   */
  @Test
  public void testShortestPathBetweenAirports() {
    // make sure the input and output is correct 
    assertTrue (f.getShortestPath("SEA", "ORD").toString().equals("[SEA, DEN, ORD]")) ;
    assertTrue (f.getShortestPath("JFK", "LAX").toString().equals("[JFK, DCA, ORD, LAX]")) ;
    assertTrue (f.getShortestPath("LAX", "JFK").toString().equals("[LAX, DEN, ATL, DCA, JFK]")) ;
  }
  /**
   * Test if the cheapest path return between the airports is correct
   */
  @Test
  public void testCheapestPathBetweenAirports() {
    // make sure the cheapest path is correct
    assertTrue(f.getCheapestPath("SEA", "ORD").toString().equals("[SEA, ORD]"));
    assertTrue(f.getCheapestPath("JFK", "LAX").toString().equals("[JFK, ORD, DEN, LAX]"));
    assertTrue(f.getCheapestPath("LAX", "JFK").toString().equals("[LAX, DEN, ORD, JFK]"));

  }
  /**
   * Test if the cheapest cost return between the airports is correct 
   */
  @Test
  public void testCheapestCostBetweenAirports() {
    // make sure the output cost is correct
    assertTrue(f.getCheapestPrice("LAX", "JFK") == 395);
    assertTrue(f.getCheapestPrice("JFK", "LAX") == 395);
    assertTrue(f.getCheapestPrice("SEA", "ORD") == 200);
  }
  /**
   * Test if the shortest path return between the airport is correct
   */
  @Test
  public void testShortestTimeBetweenAirports() {
    // make sure the output time is correct
    assertTrue(f.getShortestTime("LAX", "JFK") == 9);
    assertTrue(f.getShortestTime("JFK", "LAX") == 9);
    assertTrue(f.getShortestTime("SEA", "ORD") == 5);
  }
}

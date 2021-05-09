// --== CS400 File Header Information ==--
// Name: Jerry Yu
// Email: jcyu4@wisc.edu
// Team: Red
// Role: Backend Developer
// TA: Hang Yin
// Lecturer: Gary Dahl
// Notes to Grader: none
import java.util.List;
public interface BackendInterface {
  /**
   * This method calls the shortestPath method from the CS400 graph class on the price graph to find
   * the cheapest path from the starting airport to the ending airport
   * 
   * @param start - airport that you are starting at
   * @param end   - airport that you are going to
   * @return the cheapest path from the start to the end
   */
  public List<String> getCheapestPath(String start, String end);
  /**
   * This method calls the shortestPath method from the CS400 graph class on the time graph to find
   * the fastest path from the starting airport to the ending airport
   * 
   * @param start - airport that you are starting at
   * @param end   - airport that you are going to\
   * @return the shortest path from the start to the end
   */
  public List<String> getShortestPath(String start, String end);
  /**
   * This method calls the getPathCost method from the CS400 graph class on the price graph to find
   * the total weight of the cheapest path
   * 
   * @param start - airport that you are starting at
   * @param end   - airport that you are going to
   * @return the total weight of the cheapest path from the start to the end
   */
  public int getCheapestPrice(String start, String end);
  /**
   * This method calls the getPathCost method from the CS400 graph class on the time graph to find
   * the total weight of the time path
   * 
   * @param start - airport that you are starting at
   * @param end   - airport that you are going to
   * @return the total weight of the shortest path from the start to the end
   */
  public int getShortestTime(String start, String end);
  /**
   * This method finds the price of the shortest path
   * 
   * @param start - airport that you are starting at
   * @param end   - airport that you are going to
   * @return the price of the shortest path
   */
  public int getShortestPrice(String start, String end);
  /**
   * This method finds the amount of time needed for the cheapest path
   * 
   * @param start - airport that you are starting at
   * @param end   - airport that you are going to
   * @return the time of the cheapest path
   */
  public int getCheapestTime(String start, String end);
}

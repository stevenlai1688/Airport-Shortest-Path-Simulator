// --== CS400 File Header Information ==--
// Name: Steven Lai
// Email: sylai2@wisc.edu
// Team: red
// Role: Frontend
// TA: Hang Yin
// Lecturer: Gary Dahl
// Notes to Grader: none
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Frontend extends Backend {
  // the list of all the possible airports names
  private static String[] allAirportsName =
      {"SEA", "ORD", "LAX", "DEN", "HNL", "ATL", "JFK", "MCO", "DFW", "DCA"};
  // add all the names of airports into the arraylist in the constructor
  private static ArrayList<String> allAirportsList = new ArrayList<String>();

  /**
   * Frontend class constructor
   */
  public Frontend() {
    super();
  }

  public static void main(String[] args) {
    // create a new front end object
    Frontend frontend = new Frontend();

    // loop through all the airport names and add it to the arrayList
    for (int i = 0; i < allAirportsName.length; i++) {
      allAirportsList.add(allAirportsName[i]);
    }
    // pass that object to the main menu
    homeMenu(frontend);
  }

  /**
   * Home method of the Frontend class, it acts as the main hub with choices for user to input
   * 
   * @param frontend
   */
  public static void homeMenu(Frontend frontend) {
    // use scanner to enter user input
    Scanner scanner = new Scanner(System.in);
    // print out the main menu
    System.out.println(
        "|*~*~*-------------------------FLIGHT PATH SIMULATOR-------------------------*~*~*|");
    System.out.println(
        "|*~*~*---Press 's' to find the shortest path between your desired location---*~*~*|");
    System.out.println(
        "|*~*~*---Press 'c' to find the cheapest path between your desired location---*~*~*|");
    System.out.print(
        "|*~*~*---------------------Press 'x' to end this program---------------------*~*~*|");

    // takes the userInput
    String userInput = scanner.next().toLowerCase();
    // use a while loop to check for user input
    while (!userInput.equals("x")) {
      if (userInput.equals("s")) {
        shortestPathMenu(frontend, scanner);
      }
      if (userInput.equals("c")) {
        cheapestCostMenu(frontend, scanner);
      } else {
        userInput = scanner.next();
      }
    }
    // once while loop is exited, the system exits
    System.out.println(
        "|*~*~*-------------------------THIS PROGRAM HAS ENDED------------------------*~*~*|");
    System.out.println(
        "|_________________________________________________________________________________|");
    System.exit(0);
  }

  /**
   * Return the cheapest cost path given user input of
   * 
   * @param frontend
   * @param scanner
   */
  public static void cheapestCostMenu(Frontend frontend, Scanner scanner) {
    System.out.println();
    System.out.println(
        "|*~*~*---------------------------Cheapest Cost Menu--------------------------*~*~*|");
    // display the list of all the possible airports to visit
    System.out.println(
        "|*~*~*----------------------------LIST OF AIRPORTS---------------------------*~*~*|");

    // use the for loop to iterate through the entire possible airport list and print the paths of
    // each airports out
    for (int i = 0; i < frontend.flights.size(); i++) {
      System.out.println("|*~*~*                          " + frontend.flights.get(i).getLocation1()
          + " <---------> " + frontend.flights.get(i).getLocation2()
          + "                          *~*~*|");
    }
    // asks for user input
    System.out.println(
        "|*~*~*----------------Press 's' to Start Selecting Airport-------------------*~*~*|");
    System.out.println(
        "|*~*~*----------------Press 'x' to Return Back to Main Menu------------------*~*~*|");
    String userInput = scanner.next().toLowerCase();
    // make sure user's input is not x, and check for s
    if (!userInput.equals("x")) {
      if (userInput.equals("s")) {
        // asks user to enter the name of the airport starting point
        System.out.print(
            "|*~*~*------------------Please Select Your Starting Airport------------------*~*~*|");
        String startingAirport = scanner.next().toLowerCase();
        // make sure that the airport is valid
        if (!allAirportsList.contains(startingAirport.toUpperCase())) {
          System.out.println();
          System.out.println(
              "***ERROR THE SELECTED AIRPORT DOES NOT EXIST, RETURNING BACK TO MAIN MENU***");
          System.out.println();
          // if not, then call the menu again
          cheapestCostMenu(frontend, scanner);
        } else {
          // otherwise, display the correct airport being selected
          System.out.println("|*~*~*-----------------------Selected Airport: "
              + startingAirport.toUpperCase() + "---------------------------*~*~*|");
        }
        // asks user to enter the name of the airport destination
        System.out.print(
            "|*~*~*-----------------Please Select Your Destination Airport----------------*~*~*|");


        String endingAirport = scanner.next().toLowerCase();
        // make sure that the airport is valid
        if (!allAirportsList.contains(endingAirport.toUpperCase())) {
          System.out.println();
          System.out.println(
              "***ERROR THE SELECTED AIRPORT DOES NOT EXIST, RETURNING BACK TO SELECTION HOMESCREEN***");
          System.out.println();
          // if not, then call the menu again
          cheapestCostMenu(frontend, scanner);

        } else {
          // otherwise, display the correct airport being selected
          System.out.println("|*~*~*-----------------------Selected Airport: "
              + endingAirport.toUpperCase() + "---------------------------*~*~*|");
        }
        System.out.println(
            "|*~*~*----------------Press 'X' to Return Back to Main Menu------------------*~*~*|");
        System.out.println(
            "|*~*~*---------------------------The Cheapest Path---------------------------*~*~*|");
        // cheapest path, catch exception if no paths are found
        try {
          System.out.println();
          System.out.println("The Cheapest Path Goes From -> : " + frontend
              .getCheapestPath(startingAirport.toUpperCase(), endingAirport.toUpperCase()));
          // prints out the cost of this flight as well
          System.out.println("The Cost of this Path is: " + frontend.getCheapestPrice(
              startingAirport.toUpperCase(), endingAirport.toUpperCase()) + " dollars");
          // prints out the time it takes for this cheap flight as well
          System.out.println("The Time of this Path is: "
              + frontend.getCheapestTime(startingAirport.toUpperCase(), endingAirport.toUpperCase())
              + " dollars");
        } catch (NoSuchElementException e) {
          System.out.println();
          System.out.println("***NO PATH FOUND, RETURNING BACK TO THE MAIN MENU***");
        }
      }
      // if input is not s, then asks the user to try again and bring them back to the original path
      else {
        System.out.println();
        System.out.println("***INVALID INPUT, PLEASE TRY AGAIN***");
        cheapestCostMenu(frontend, scanner);
      }
    }
    // spacer
    System.out.println();
    System.out.println();
    System.out.println();
    // call the main menu again after the option is done
    homeMenu(frontend);

  }

  public static void shortestPathMenu(Frontend frontend, Scanner scanner) {
    System.out.println(
        "|*~*~*---------------------------Shortest Path Menu--------------------------*~*~*|");
    // display the list of all the possible airports to visit
    System.out.println(
        "|*~*~*----------------------------LIST OF AIRPORTS---------------------------*~*~*|");

    // use the for loop to iterate through the entire possible airport list and print the paths of
    // each airports out
    for (int i = 0; i < frontend.flights.size(); i++) {
      System.out.println("|*~*~*                          " + frontend.flights.get(i).getLocation1()
          + " <---------> " + frontend.flights.get(i).getLocation2()
          + "                          *~*~*|");
    }
    // asks for user inputs
    System.out.println(
        "|*~*~*----------------Press 's' to Start Selecting Airport-------------------*~*~*|");
    System.out.println(
        "|*~*~*----------------Press 'x' to Return Back to Main Menu------------------*~*~*|");
    String userInput = scanner.next().toLowerCase();
    // make sure user's input is not x, and check for s
    if (!userInput.equals("x")) {
      if (userInput.equals("s")) {
        // asks user to enter the name of the airport starting point
        System.out.print(
            "|*~*~*------------------Please Select Your Starting Airport------------------*~*~*|");
        String startingAirport = scanner.next().toLowerCase();
        // make sure that the airport is valid
        if (!allAirportsList.contains(startingAirport.toUpperCase())) {
          System.out.println();
          System.out.println(
              "***ERROR THE SELECTED AIRPORT DOES NOT EXIST, RETURNING BACK TO MAIN MENU***");
          System.out.println();
          // if not, then call the menu again
          shortestPathMenu(frontend, scanner);
        } else {
          // otherwise, display the correct airport being selected
          System.out.println("|*~*~*-----------------------Selected Airport: "
              + startingAirport.toUpperCase() + "---------------------------*~*~*|");
        }
        // asks user to enter the name of the airport destination
        System.out.print(
            "|*~*~*-----------------Please Select Your Destination Airport----------------*~*~*|");


        String endingAirport = scanner.next().toLowerCase();
        // make sure that the airport is valid
        if (!allAirportsList.contains(endingAirport.toUpperCase())) {
          System.out.println();
          System.out.println(
              "***ERROR THE SELECTED AIRPORT DOES NOT EXIST, RETURNING BACK TO SELECTION HOMESCREEN***");
          System.out.println();
          // if not, then call the menu again
          shortestPathMenu(frontend, scanner);

        } else {
          // otherwise, display the correct airport being selected
          System.out.println("|*~*~*-----------------------Selected Airport: "
              + endingAirport.toUpperCase() + "---------------------------*~*~*|");
        }
        System.out.println(
            "|*~*~*----------------Press 'X' to Return Back to Main Menu------------------*~*~*|");
        System.out.println(
            "|*~*~*---------------------------The Shortest Path---------------------------*~*~*|");
        // shortest path, catch exception if no paths are found
        try {
          System.out.println();
          System.out.println("The Shortest Path Goes From -> : " + frontend
              .getShortestPath(startingAirport.toUpperCase(), endingAirport.toUpperCase()));
          // also print the time it takes for this path
          System.out.println("The Time of this Path is: "
              + frontend.getShortestTime(startingAirport.toUpperCase(), endingAirport.toUpperCase())
              + " hours");
          // prints out the price of this path as well
          System.out.println("The Price of this Path is: " + frontend.getShortestPrice(
              startingAirport.toUpperCase(), endingAirport.toUpperCase()) + " dollars");
        } catch (NoSuchElementException e) {
          System.out.println();
          System.out.println("***NO PATH FOUND, RETURNING BACK TO THE MAIN MENU***");
        }
      }
      // if input is not s, then asks the user to try again and bring them back to the original path
      else {
        System.out.println();
        System.out.println("***INVALID INPUT, PLEASE TRY AGAIN***");
        shortestPathMenu(frontend, scanner);
      }
    }
    // spacer
    System.out.println();
    System.out.println();
    System.out.println();
    // call the main menu again after the option is done
    homeMenu(frontend);

  }
}

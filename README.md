# Airport-Shortest-Path-Simulator
UW Madison CS400 project.

Using Dijkstra's shortest path algorithm as well as simulated airport distances to calculate the shortest path cost/ cheapest path cost from one node to another.

FlightPath class is the wrapper class for FlightData, which contains flight distance and flight cost accessors.

FlightData class contains predetermined flight distances from 1 airport to another, as well as flight costs from 1 airport to another.

The above classes are then used by the backend class which takes the dijkstra's shortest path algorithm data structure to determine the shortest integer value between the airports. The Dijkstra's algorithm then returns a complete Path object which contains the beginning node all the way to the ending node (airport names), as well as the edges (distance or cost depending on user input value) associated to that path.

The returned path then is processed by the frontend class that uses a text based input system and display user's selections

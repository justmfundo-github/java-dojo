package grokking_algorithms.ch07_dijkstras_algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Weighted_Node implements Comparable<Weighted_Node> {
  private String name; // name of the node
  private Integer distance = Integer.MAX_VALUE; // total known minimum distance to that node from the starting node
  private List<Weighted_Node> shortestPath = new ArrayList<>();
  private Map<Weighted_Node, Integer> adjacentNodes = new HashMap<>(); // Stores the adjacent nodes and their distances

  public Weighted_Node(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getDistance() {
    return distance;
  }

  public void setDistance(Integer distance) {
    this.distance = distance;
  }

  public Map<Weighted_Node, Integer> getAdjacentNodes() {
    return adjacentNodes;
  }

  public void setAdjacentNodes(Map<Weighted_Node, Integer> adjacentNodes) {
    this.adjacentNodes = adjacentNodes;
  }

  public void addAdjacentNode(Weighted_Node node, int weight){
    adjacentNodes.put(node, weight);
  }

  public List<Weighted_Node> getShortestPath() {
    return shortestPath;
  }

  public void setShortestPath(List<Weighted_Node> shortestPath) {
    this.shortestPath = shortestPath;
  }
  
  @Override
  public int compareTo(Weighted_Node node) {
    return Integer.compare(this.distance, node.getDistance());
  }

  

  
}

package grokking_algorithms.ch07_dijkstras_algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class DijkstrasAlgorithm {
  public static void main(String[] args) {
    //Creating the nodes and their neighbours
    Weighted_Node nodeA = new Weighted_Node("A");
    Weighted_Node nodeB = new Weighted_Node("B");
    Weighted_Node nodeC = new Weighted_Node("C");
    Weighted_Node nodeD = new Weighted_Node("D");
    Weighted_Node nodeE = new Weighted_Node("E");
    Weighted_Node nodeF = new Weighted_Node("F");

    nodeA.addAdjacentNode(nodeB, 2);
    nodeA.addAdjacentNode(nodeC, 4);

    nodeB.addAdjacentNode(nodeC, 3);
    nodeB.addAdjacentNode(nodeD, 1);
    nodeB.addAdjacentNode(nodeE, 5);

    nodeC.addAdjacentNode(nodeD, 2);

    nodeD.addAdjacentNode(nodeE, 1);
    nodeD.addAdjacentNode(nodeF, 4);

    nodeE.addAdjacentNode(nodeF, 2);  

    calculateShortestPath(nodeA);
    printPaths(Arrays.asList(nodeA, nodeB, nodeC, nodeD, nodeE, nodeF));
    
  }

  private static void printPaths(List<Weighted_Node> nodes) {
    nodes.forEach(node -> {
      String path = node.getShortestPath().stream()
                        .map(shortestPathNode -> shortestPathNode.getName())
                        .collect(Collectors.joining(" -> "));
      System.out.println(path.isBlank()? "%s : %s".formatted(node.getName(), node.getDistance()) : "%s -> %s : %s".formatted(path, node.getName(), node.getDistance()));                  
    });             
  }

  public static void calculateShortestPath(Weighted_Node source){
    source.setDistance(0);
    Set<Weighted_Node> settledNodes = new HashSet<>();
    Queue<Weighted_Node> unsettledNodes = new PriorityQueue<>(Collections.singleton(source));

    while(!unsettledNodes.isEmpty()){
      Weighted_Node currentNode = unsettledNodes.poll();
      currentNode.getAdjacentNodes()
                  .entrySet().stream()
                  .filter(entry -> !settledNodes.contains(entry.getKey()))
                  .forEach(entry -> {
                    // System.out.println(entry.getKey().getName() + entry.getValue());
                    evaluateDistanceAndPath(entry.getKey(), entry.getValue(), currentNode);
                    unsettledNodes.add(entry.getKey());
                  });
      settledNodes.add(currentNode);
    }
  }

  private static void evaluateDistanceAndPath(Weighted_Node adjacentNode, Integer edgeWeight, Weighted_Node sourceNode) {
    Integer newDistance = sourceNode.getDistance() + edgeWeight;
    // System.out.println(newDistance + " ... " + sourceNode.getDistance() + " ....adj node.." + adjacentNode.getDistance());
    if(newDistance < adjacentNode.getDistance()){
      adjacentNode.setDistance(newDistance);
      adjacentNode.setShortestPath(Stream.concat(sourceNode.getShortestPath().stream(), Stream.of(sourceNode)).toList());
    }
  }
}

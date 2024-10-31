package grokking_algorithms.ch06_breadth_first_search;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
/*
 * Implementing the breadth first search algorithm on a graph
 *             
 */

public class BreadthFirstSearch<T> {
  private final Vertex<T> startVertex;

  public BreadthFirstSearch(Vertex<T> startVertex) {
    this.startVertex = startVertex;
  }

  public static void main(String[] args) {
    Vertex<Integer> v0 = new Vertex<>(0);
    Vertex<Integer> v1 = new Vertex<>(1);
    Vertex<Integer> v2 = new Vertex<>(2);
    Vertex<Integer> v3 = new Vertex<>(3);
    Vertex<Integer> v4 = new Vertex<>(4);
    Vertex<Integer> v5 = new Vertex<>(5);
    Vertex<Integer> v6 = new Vertex<>(6);

    v0.setNeighbours(Arrays.asList(v1, v5, v6));
    v1.setNeighbours(Arrays.asList(v3, v4, v5));
    v4.setNeighbours(Arrays.asList(v2, v6));
    v6.setNeighbours(Arrays.asList(v0));

    BreadthFirstSearch<Integer> bfs = new BreadthFirstSearch<>(v0);
    bfs.traverse();
  }

  public void traverse(){
    Queue<Vertex<T>> queue = new LinkedList<>();
    queue.add(startVertex);

    while(!queue.isEmpty()){
      Vertex<T> current = queue.poll();

      if(!current.isVisited()){
        current.setVisited(true);
        System.out.println(current);
        // System.out.println(current.getData());
        // System.out.println(current.getNeighbours());
        queue.addAll(current.getNeighbours());
      }
    }
  }
}

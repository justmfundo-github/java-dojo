package grokking_algorithms.ch06_breadth_first_search;

import java.util.List;
import java.util.LinkedList;
/*
 * Creating the node or the vertex used in the structure of graphs. 
 * Each vertex is linked to it's neighbours. Those neighbours are stored in a linked list of vertices.
 */

public class Vertex<T> {
  private T data;
  private boolean visited;

  private List<Vertex<T>> neighbours = new LinkedList<>();

  

  public Vertex(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public boolean isVisited() {
    return visited;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }

  public List<Vertex<T>> getNeighbours() {
    return neighbours;
  }

  public void setNeighbours(List<Vertex<T>> neighbours) {
    this.neighbours = neighbours;
  }

  @Override
  public String toString() {
    return "Vertex [data=" + data.toString() + ", visited=" + visited;
  }

  

}

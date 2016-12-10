package com.training.graph;

public class Edge
{ 
  private Vertex destination;
  private int weight;
  
  public Edge(Vertex destination, int weight)
  {
   this.destination = destination;
   this.weight = weight;
  }

  public Vertex getDestinationVertex()
  {
    return destination;
  }
  
  public int getWeight()
  {
    return weight;
  }
  
  @Override
  public String toString()
  {
    return "destination : " + destination.getData();
  }
}

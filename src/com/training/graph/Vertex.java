package com.training.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex
{
  private List<Edge> edges;
  private String data;
  private State state;
  
  public Vertex(String data)
  {
    this.setData(data);
    edges = new ArrayList<Edge>();
    state = State.Unvisited;
  }

  public List<Edge> getEdges()
  {
    return edges;
  }

  public void setEdges(List<Edge> edges)
  {
    this.edges = edges;
  }

  public String getData()
  {
    return data;
  }

  public void setData(String data)
  {
    this.data = data;
  }

  public State getState()
  {
    return state;
  }

  public void setState(State state)
  {
    this.state = state;
  }

  public void addEdge(Edge edge)
  {
    edges.add(edge);
  }

  public boolean isUnVisited()
  {
    return getState().equals(State.Unvisited);
  }
  
  @Override
  public String toString()
  {
    StringBuilder ver =  new StringBuilder("vertex is : " + getData());
    for (Edge edge: getEdges())
    {
      ver.append(edge.toString());
    }
    return ver.toString();
  }
}

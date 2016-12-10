package com.training.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/*
 * find strongly connected component in a graph
 */
public class StronglyConnectedComponent
{
  private static Map<Vertex, Vertex> map = new HashMap<>();

  public static void main(String[] args)
  {
    // print its strongly connected components
    Graph g = new Graph();
    g.createGraphWithStronglyConnectedComponents();
    List<List<Vertex>> scc = findStronglyConnectedComponents(g);
    // print strongly connected components here
    for (List<Vertex> vertexList : scc)
    {
      StringBuilder sccString = new StringBuilder();
      for (Vertex ver : vertexList)
      {
        sccString.append(ver.getData());
      }
      System.out.println(sccString.toString());
    }
  }

  /*
   * this kosaraju's algorithm traverses graph once and populates stacks then it
   * reverses the graph and traverses it again - and figures out the connected
   * components
   */
  static List<List<Vertex>> findStronglyConnectedComponents(Graph g)
  {
    List<List<Vertex>> vertexList = new LinkedList<List<Vertex>>();
    // create a stack
    Stack<Vertex> verticeStack = new Stack<Vertex>();
    Set<Vertex> verticeSet = g.getVertices();
    markUnvisited(verticeSet);
    for (Vertex ver : verticeSet)
    {
      traverseDFS(ver, verticeStack);
    }
    markUnvisited(verticeSet);
    Graph reverseGraph = reverseGraph(g);
    verticeSet = reverseGraph.getVertices();
    while (!verticeStack.isEmpty())
    {
      Vertex ver = map.get(verticeStack.pop());
      List<Vertex> strongComponent = new LinkedList<Vertex>();
      traverseDFS(ver, strongComponent);
      if (!strongComponent.isEmpty())
        vertexList.add(strongComponent);
    }
    return vertexList;
  }

  private static void traverseDFS(Vertex ver, List<Vertex> strongComponent)
  {
    if (!ver.isUnVisited())
    {
      return;
    }
    ver.setState(State.InProgress);
    List<Edge> edges = ver.getEdges();
    for (Edge edge : edges)
    {
      Vertex destinationVertex = edge.getDestinationVertex();
      traverseDFS(destinationVertex, strongComponent);
    }
    ver.setState(State.Visited);
    strongComponent.add(ver);
  }

  private static Graph reverseGraph(Graph g)
  {
    Graph reverseGraph = new Graph();
    Set<Vertex> vertex = g.getVertices();
    for (Vertex ver : vertex)
    {
      Vertex clone = null;
      clone = cloneVertex(map, reverseGraph, ver);
      List<Edge> edges = ver.getEdges();
      for (Edge edge : edges)
      {
        Edge newEdge = new Edge(clone, edge.getWeight());
        Vertex destination = edge.getDestinationVertex();
        Vertex destinationClone = cloneVertex(map, reverseGraph, destination);
        destinationClone.addEdge(newEdge);
      }
    }
    return reverseGraph;
  }

  private static Vertex cloneVertex(Map<Vertex, Vertex> map,
    Graph reverseGraph, Vertex ver)
  {
    Vertex clone;
    if (!map.containsKey(ver))
    {
      clone = new Vertex(ver.getData());
      reverseGraph.addVertex(clone);
      map.put(ver, clone);
    }
    else
    {
      clone = map.get(ver);
    }
    return clone;
  }

  private static void markUnvisited(Set<Vertex> verticeSet)
  {
    for (Vertex ver : verticeSet)
    {
      ver.setState(State.Unvisited);
    }
  }

  private static void traverseDFS(Vertex ver, Stack<Vertex> verticeStack)
  {
    if (!ver.isUnVisited())
    {
      return;
    }
    ver.setState(State.InProgress);
    List<Edge> edges = ver.getEdges();
    for (Edge edge : edges)
    {
      Vertex destinationVertex = edge.getDestinationVertex();
      traverseDFS(destinationVertex, verticeStack);
    }
    ver.setState(State.Visited);
    if(verticeStack != null)
      verticeStack.add(ver);
  }
}

package com.training.graph;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class GraphOperations
{
  public static void main(String[] args)
  {
    Graph g = new Graph();
    g.createGraph();
    traverseGraphDFS(g);
    traverseGraphBFS(g);
  }

  private static void traverseGraphBFS(Graph g)
  {
    Queue<Vertex> vertices = new PriorityQueue<Vertex>();
    for (Vertex v : g.getVertices())
    {
      if (v.getState().equals(State.Unvisited))
      {
        vertices.add(v);
      }
      while (!vertices.isEmpty())
      {
        Vertex current = vertices.poll();
        System.out.println("vertex: " + current.getData());
        current.setState(State.Visited);
        List<Edge> edgesList = current.getEdges();
        for (Edge edge : edgesList)
        {
          Vertex destinationVertex = edge.getDestinationVertex();
          if (destinationVertex.getState().equals(State.Unvisited))
          {
            vertices.add(destinationVertex);
          }
        }
      }
    }
  }

  private static void traverseGraphDFS(Graph g)
  {
    for (Vertex v : g.getVertices())
    {
      if (v.getState().equals(State.Unvisited))
      {
        System.out.println("working on vertex " + v.getData());
        traverseVertexDFS(v);
      }
    }
  }

  private static void traverseVertexDFS(Vertex v)
  {
    if (v == null)
    {
      return;
    }
    System.out.println("vertex: " + v.getData());
    v.setState(State.Visited);
    List<Edge> edgesList = v.getEdges();
    for (Edge edge : edgesList)
    {
      Vertex destinationVertex = edge.getDestinationVertex();
      if (destinationVertex.getState().equals(State.Unvisited))
      {
        traverseVertexDFS(destinationVertex);
      }
    }
  }
}

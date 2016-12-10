package com.training.graph;

import java.util.HashSet;
import java.util.Set;

public class Graph
{
  private Set<Vertex> vertices = new HashSet<Vertex>();

  public void createGraph()
  {
    Vertex s = new Vertex("s");
    Vertex a = new Vertex("a");
    Vertex b = new Vertex("b");
    Vertex c = new Vertex("c");
    Vertex d = new Vertex("d"); 
    this.vertices.add(s); 
    this.vertices.add(a);
    this.vertices.add(b); 
    this.vertices.add(c); 
    this.vertices.add(d);   
    s.addEdge(new Edge(a,8));
    a.addEdge(new Edge(b,10));
    b.addEdge(new Edge(c,5));
    d.addEdge(new Edge(c,2));
  }

  public Set<Vertex> getVertices()
  {
    return vertices;
  }
  
  public void addVertex(Vertex v)
  {
    this.vertices.add(v);
  }
  
  public void setVertices(Set<Vertex> vertices)
  {
    this.vertices = vertices;
  }

  public void createGraphWithStronglyConnectedComponents()
  {
    Vertex s = new Vertex("s");
    Vertex a = new Vertex("a");
    Vertex b = new Vertex("b");
    Vertex c = new Vertex("c");
    Vertex d = new Vertex("d"); 
    Vertex k = new Vertex("k");
    Vertex p = new Vertex("p");
    this.vertices.add(s); 
    this.vertices.add(a);
    this.vertices.add(b); 
    this.vertices.add(c); 
    this.vertices.add(d);   
    this.vertices.add(k);
    this.vertices.add(p);
    s.addEdge(new Edge(a,8));
    k.addEdge(new Edge(s,6));
    p.addEdge(new Edge(b,2));
    a.addEdge(new Edge(b,10));
    b.addEdge(new Edge(k,5));
    d.addEdge(new Edge(c,2));
    c.addEdge(new Edge(p,2));
    p.addEdge(new Edge(d,2));
  }
  
  public void createGraphWithStronglyConnectedComponents2()
  {
    Vertex a1 = new Vertex("1");
    Vertex b2 = new Vertex("2");
    Vertex c3 = new Vertex("3");
    Vertex d4 = new Vertex("4");
    Vertex e5 = new Vertex("5"); 
    Vertex f6 = new Vertex("6");
    Vertex g7 = new Vertex("7");
    this.vertices.add(a1); 
    this.vertices.add(b2);
    this.vertices.add(c3); 
    this.vertices.add(d4); 
    this.vertices.add(e5);   
    this.vertices.add(f6);
    this.vertices.add(g7);
    a1.addEdge(new Edge(b2,8));
    b2.addEdge(new Edge(c3,6));
    c3.addEdge(new Edge(a1,2));
    c3.addEdge(new Edge(e5,10));
    e5.addEdge(new Edge(f6,5));
    d4.addEdge(new Edge(e5,2));
    f6.addEdge(new Edge(d4,2));
    g7.addEdge(new Edge(f6,2));
  }
}

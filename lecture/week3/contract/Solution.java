import java.util.*;
class Solution{
 public static void main(String[] args) throws Exception{
  
  FileReader fr = new FileReader("kargerMinCut.txt",201);
  fr.readAll();

  Graph graph = fr.getGraph();
  //System.out.println(g);
  //g.kargerCut();
  //System.out.println(g);
 
  System.out.println("Karger Cut:: " + graph.kargerCut()); 

  Graph g = new Graph(24);
  g.addEdge(1,2);
  g.addEdge(1,3);
  g.addEdge(1,4);
  g.addEdge(2,4);
  g.addEdge(2,5);
  g.addEdge(2,8);
  g.addEdge(3,4);
  g.addEdge(3,6);
  g.addEdge(4,5);
  g.addEdge(4,6);
  g.addEdge(4,7);
  g.addEdge(4,8);
  g.addEdge(4,10);
  g.addEdge(5,8);
  g.addEdge(6,9);
  g.addEdge(6,10);
  g.addEdge(7,8);
  g.addEdge(7,10);
  
  g.addEdge(8,10);
  g.addEdge(8,11);
  g.addEdge(8,12);
  g.addEdge(8,13);
 
  g.addEdge(9,10);
  g.addEdge(9,12);

  g.addEdge(10,11);
  g.addEdge(10,12);

  g.addEdge(11,12);
  
  g.addEdge(13,14);
  g.addEdge(13,16);
  g.addEdge(13,17);
  g.addEdge(13,19);
  g.addEdge(13,21);
  g.addEdge(13,22);

  g.addEdge(14,15);
  g.addEdge(14,16);
  g.addEdge(14,18);
  g.addEdge(14,20);

  g.addEdge(15,16);
  g.addEdge(15,17);
  g.addEdge(15,18);

  g.addEdge(16,17);
 
  g.addEdge(17,18);
  g.addEdge(17,19);

  g.addEdge(18,23);

  g.addEdge(19,20);
  g.addEdge(19,21);

  g.addEdge(20,21);
  g.addEdge(20,23);

  g.addEdge(21,22);
  g.addEdge(21,23);

  g.addEdge(22,23);
  //System.out.println("KARGER:: " + g.kargerCut());
 }
}

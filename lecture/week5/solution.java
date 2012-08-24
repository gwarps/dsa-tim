import java.util.*;
class Solution{
 public static void main(String args[]){
  FileReader fr = new FileReader("dijkstraData.txt",201);
  fr.readAll();
  EdgeWeightedGraph cg = fr.getGraph();
  EdgeWeightedGraph g = new EdgeWeightedGraph(5);  
  g.addEdge(new Edge(1,2,7.0));
  g.addEdge(new Edge(1,3,4.0));
  g.addEdge(new Edge(2,3,4.0));
  g.addEdge(new Edge(2,4,1.0));
  g.addEdge(new Edge(3,4,1.0));


  //System.out.println(cg);
  ShortestPath sp = new ShortestPath(cg,1);
  
  int[] data = {7,37,59,82,99,115,133,165,188,197};
  
  //int[] data = {1,2,3,4};
  System.out.println();
  for(int i=0;i<data.length;i++){
   System.out.print((int)sp.distTo(data[i]) + ",");
  }
  System.out.println(); 
  //System.out.println(sp.distTo(3));
  //System.out.println(sp.distTo(2));
  //System.out.println(fr.getGraph());
 }//end of main
}//end of class

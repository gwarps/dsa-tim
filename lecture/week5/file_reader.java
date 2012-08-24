import java.io.*;
import java.util.*;
/**
 * Class for FileReading and storing the data in vector
 * Data Type:: Integer
 * Graph Input
 * Undirected Graph
 * 
 * @author Puneet Singh
 * @version 1.0 18th July 2012
 * 
 */

class FileReader{
 private String file_path;
 int[][] g;
 EdgeWeightedGraph graph;
 
 public FileReader(String file_path,int size){
  this.file_path = file_path;
  g = new int[size][size];
  graph = new EdgeWeightedGraph(size);
 }

 //Return Graph
 public EdgeWeightedGraph getGraph(){
  return graph;
 }
 //Read a line at a time
 public void readAll(){
   int dup = 0;
   int or = 0;
   try{
    FileInputStream fin = new FileInputStream(this.file_path);
    BufferedReader br = new BufferedReader(new InputStreamReader(fin));
    String l;
    String[] node;
    while((l=br.readLine())!=null){
     node = l.split("\\s+");

     int v = Integer.parseInt(node[0]);
     
      for(int i=1;i<node.length;i++){
      	String[] wn = node[i].split(",");
      	int w = Integer.parseInt(wn[0]);
      	double len = Double.parseDouble(wn[1]);
        boolean k = addMark(v,w,len);

       
       if(k){
        or++;
       }else{
        dup++;
       }
      }
    }

   }catch(Exception ex){
    System.out.println("File Not Found");
   }
  System.out.println("DUP:: " + dup + " ORIGINAL:: " + or);
 }
 
 // Add node and mark matrix
 public boolean addMark(int i,int j,double weight){
   if(g[i][j]==0 && g[j][i]==0){
    graph.addEdge(new Edge(i,j,weight));
    g[i][j]=1;
    g[j][i]=1;
    return true;
   }
  return false;
 } 
}

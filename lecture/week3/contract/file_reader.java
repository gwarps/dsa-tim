import java.io.*;
import java.util.*;
/**
 * Class for FileReading and storing the data in vector
 * Data Type:: Integer
 * Graph Input
 * Undirected Graph
 * 
 * @author Puneet Singh
 * @version 1.0 25th June 2012
 * 
 */
class FileReader{
 private String file_path;
 int[][] g;
 Graph graph;
 
 public FileReader(String file_path,int size){
  this.file_path = file_path;
  g = new int[size][size];
  graph = new Graph(size);
 }

 //Return Graph
 public Graph getGraph(){
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
     for(int i=1;i<node.length;i++){
      boolean k = addMark(Integer.parseInt(node[0]),Integer.parseInt(node[i]));
   
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
 public boolean addMark(int i,int j){
   if(g[i][j]==0 && g[j][i]==0){
  
    graph.addEdge(i,j);
    g[i][j]=1;
    g[j][i]=1;
    return true;
   }
  return false;
 } 
}

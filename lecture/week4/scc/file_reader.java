import java.io.*;
import java.util.*;

class FileReader{
 private String file_path;
 Digraph g;


 public FileReader(String file_path,int size){
  this.file_path = file_path;
  g = new Digraph(size);
 }

 public Digraph getGraph(){
  return this.g;
 }

 public void readAll(){
  try{
   FileInputStream fin = new FileInputStream(this.file_path);
   BufferedReader br = new BufferedReader(new InputStreamReader(fin));
   String l;

   while((l=br.readLine())!=null){
    String[] data = l.split("\\s+");
    //a -> b
    int a = Integer.parseInt(data[0]) - 1;
    int b = Integer.parseInt(data[1]) - 1;
    g.addEdge(a,b);
   }
  }catch(Exception e){
   System.out.println(e);
  }

 }
}

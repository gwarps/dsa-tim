import java.util.*;

class Test{
 public static void main(String[] args) throws Exception{
  FileReader fr = new FileReader("kargerMinCut.txt",201);
  fr.readAll();
 
 
  Graph g = fr.getGraph();
  
  int min = g.kargerCut();
  
  for(int i=0;i<92000-1;i++){
   FileReader kr = new FileReader("kargerMinCut.txt",201);
   kr.readAll();
   Graph gt = kr.getGraph();
   int cut = gt.kargerCut();
    
   if(cut < min){
    min = cut;
   }
   System.out.println("Min Cut So Far::" + min + " Current Cut" + cut);

  }

  System.out.println("Recommended Cut:: " + min); 
 }
}

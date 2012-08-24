import java.util.*;

class Test{
 public static void main(String[] args){

  FileReader fr = new FileReader("SCC.txt",875714);
  fr.readAll();

  FileReader gr = new FileReader("sample.txt",13);
  gr.readAll();
  Digraph cg = fr.getGraph();  

  System.out.println("Input Complete");
  KosarajuSharirSCC scc = new KosarajuSharirSCC(cg);
  System.out.println("SCC Return");
  
  int M = scc.count();
  System.out.println("Connected Components::" + scc.count());
  Queue<Integer>[] components = (Queue<Integer>[]) new Queue[M];
  for (int i = 0; i < M; i++) {
    components[i] = new Queue<Integer>();
  }
  for (int v = 0; v < cg.V(); v++) {   
    components[scc.id(v)].enqueue(v);
  }


  Comparator c = Collections.reverseOrder();
  ArrayList<Integer> res = new ArrayList<Integer>();


  for (int i = 0; i < M; i++) {
    //for (int v : components[i]) {
    //    System.out.print(v + " ");
    //}
    res.add(components[i].size());
    //System.out.println("QUEUE SIZE::" + components[i].size());
  }

  Collections.sort(res,c);

  System.out.println(res);

 }
}
